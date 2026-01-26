package net.kindling.bulwark.impl.block.entity;

import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.kindling.bulwark.impl.index.BulwarkItems;
import net.kindling.bulwark.impl.index.BulwarkParticles;
import net.kindling.bulwark.impl.util.BulwarkProperties;
import net.kindling.bulwark.impl.util.DisrupterType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisrupterBlockEntity extends BlockEntity {
    public DisrupterBlockEntity(BlockPos pos, BlockState state) {
        super(BulwarkBlockEntities.DISRUPTER, pos, state);
    }

    private static final EnumProperty<DisrupterType> TYPE = BulwarkProperties.DISRUPTER_TYPE;

    public int startingDelay = 50;
    public boolean active = false;

    public static void tick(World world, BlockPos pos, BlockState state, @NotNull DisrupterBlockEntity disrupter) {
        BlockState aboveState = world.getBlockState(pos.up());

        if (disrupter.startingDelay > 0) {
            disrupter.startingDelay--;
            if (disrupter.startingDelay == 0) {
                disrupter.startingDelay = aboveState.isOf(Blocks.LODESTONE) ? 10 : 20;
                disrupter.active = true;
                world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
                disrupter.markDirty();
            }
        }

        if (aboveState.isIn(BlockTags.AIR) || aboveState.isOf(Blocks.SCULK_SHRIEKER) || aboveState.isOf(Blocks.LODESTONE)) {
            Box area = new Box(pos).expand(aboveState.isIn(BlockTags.AIR) ? 7 : aboveState.isOf(Blocks.SCULK_SHRIEKER) ? 3 : 5);
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, area, entity -> true);

            for (LivingEntity entity : entities) {
                if (disrupter.active) {
                    if (!entity.getOffHandStack().isOf(BulwarkItems.OPERATOR_KEY)) {

                        if (aboveState.isOf(Blocks.LODESTONE)) {
                            entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(0.05));

                            if (world instanceof ServerWorld serverWorld) {
                                serverWorld.spawnParticles(ParticleTypes.END_ROD
                                        , entity.getX(), entity.getY() + 1.0f, entity.getZ(),
                                        1,
                                        0,
                                        0,
                                        0,
                                        0
                                );
                            }

                            break;
                        }

                        if (aboveState.isOf(Blocks.SCULK_SHRIEKER)) {
                            entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(-0.05));

                            if (world instanceof ServerWorld serverWorld) {
                                serverWorld.spawnParticles(ParticleTypes.SCULK_CHARGE_POP
                                        , entity.getX(), entity.getY() + 1.0f, entity.getZ(),
                                        1,
                                        0,
                                        0,
                                        0,
                                        0
                                );
                            }
                            break;
                        }

                        entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(-0.1));
                        if (world instanceof ServerWorld serverWorld) {
                            serverWorld.spawnParticles(BulwarkParticles.DISRUPTER
                                    , entity.getX(), entity.getY() + 1.0f, entity.getZ(),
                                    4,
                                    0.03f,
                                    0.03f,
                                    0.03f,
                                    0.02f
                            );
                        }
                    }
                }
            }
        }
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {

        this.startingDelay = nbt.getInt("startingDelay");
        this.active = nbt.getBoolean("active");

        super.readNbt(nbt, registryLookup);
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putInt("startingDelay", startingDelay);
        nbt.putBoolean("active", active);

        super.writeNbt(nbt, registryLookup);
    }


}
