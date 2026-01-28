package net.kindling.bulwark.impl.block.entity;

import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.kindling.bulwark.impl.index.BulwarkItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RestrictorBlockEntity extends BlockEntity {
    public RestrictorBlockEntity(BlockPos pos, BlockState state) {
        super(BulwarkBlockEntities.RESTRICTOR, pos, state);
    }

    public int delay = 40;

    public static void tick(World world, BlockPos pos, BlockState state, @NotNull RestrictorBlockEntity restrictor) {
        Box area = new Box(pos).expand(5);
        List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, area, entity -> true);

        for (LivingEntity entity : entities) {
            if (!entity.getOffHandStack().isOf(BulwarkItems.OPERATOR_KEY)) {
                if (!entity.isSneaking()) {
                    if (!entity.isInCreativeMode()) {
                        if (restrictor.delay > 0) {
                            restrictor.delay--;
                            if (restrictor.delay == 0) {
                                restrictor.delay = 40;
                                entity.addVelocity(0, 1, 0);
                                entity.velocityModified = true;

                                if (world instanceof ServerWorld serverWorld) {
                                    serverWorld.spawnParticles(ParticleTypes.END_ROD,
                                            restrictor.pos.getX() + 0.5f,
                                            restrictor.pos.getY(),
                                            restrictor.pos.getZ() + 0.5f,
                                            5,
                                            0.1f,
                                            0.1f,
                                            0.1f,
                                            0.09f
                                    );
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putInt("delay", delay);
        super.writeNbt(nbt, registryLookup);
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        this.delay = nbt.getInt("delay");
        super.readNbt(nbt, registryLookup);
    }
}
