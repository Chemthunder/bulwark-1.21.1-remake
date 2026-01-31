package net.kindling.bulwark.impl.block.entity;

import net.acoyt.acornlib.impl.init.tag.AcornBlockTags;
import net.kindling.bulwark.impl.index.*;
import net.kindling.bulwark.impl.util.BulwarkProperties;
import net.kindling.bulwark.impl.util.enumProperties.DisrupterType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DisrupterBlockEntity extends BlockEntity {
    public DisrupterBlockEntity(BlockPos pos, BlockState state) {
        super(BulwarkBlockEntities.DISRUPTER, pos, state);
    }

    private static final EnumProperty<DisrupterType> TYPE = BulwarkProperties.DISRUPTER_TYPE;

    public String ownerUuid = "";
    public int startingDelay = 50;
    public int delay = 35;
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

        if (aboveState.isIn(BlockTags.AIR) || aboveState.isOf(Blocks.SCULK_SHRIEKER) || aboveState.isOf(Blocks.LODESTONE) || aboveState.isOf(Blocks.CAMPFIRE)) {
            Box area = new Box(pos).expand(aboveState.isIn(BlockTags.AIR) ? 7 : aboveState.isOf(Blocks.SCULK_SHRIEKER) ? 3 : aboveState.isOf(Blocks.CAMPFIRE) ? 10 : 5);
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, area, entity -> true);

            for (LivingEntity entity : entities) {
                if (disrupter.active) {
                    if (!entity.getOffHandStack().isOf(BulwarkItems.OPERATOR_KEY)) {
                        if (!disrupter.ownerUuid.equals(entity.getUuidAsString())) {
                            if (!entity.isInCreativeMode()) {
                                if (aboveState.isOf(Blocks.LODESTONE)) {
                                    if (disrupter.delay > 0) {
                                        disrupter.delay--;
                                        if (disrupter.delay == 0) {
                                            disrupter.delay = 10;
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
                                        }
                                    }
                                    break;
                                }

                                if (aboveState.isOf(Blocks.SCULK_SHRIEKER)) {
                                    if (disrupter.delay > 0) {
                                        disrupter.delay--;
                                        if (disrupter.delay == 0) {
                                            disrupter.delay = 45;
                                            entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(-0.05));
                                            entity.damage(BulwarkDamageSources.radiation(entity), 3.5f);
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
                                        }
                                    }
                                    break;
                                }

                                if (aboveState.isOf(Blocks.CAMPFIRE)) {
                                    if (disrupter.delay > 0) {
                                        disrupter.delay--;
                                        if (disrupter.delay == 0) {
                                            disrupter.delay = 20;

                                            entity.setOnFireFor(3);

                                            if (world instanceof ServerWorld serverWorld) {
                                                serverWorld.spawnParticles(ParticleTypes.FLAME
                                                        , disrupter.pos.getX() + 0.5f, disrupter.pos.getY() + 0.5f, disrupter.pos.getZ() + 0.5f,
                                                        4,
                                                        0.3f,
                                                        0.3f,
                                                        0.3f,
                                                        0.02f
                                                );
                                            }
                                        }
                                    }
                                    break;
                                }

                                if (disrupter.delay > 0) {
                                    disrupter.delay--;
                                    if (disrupter.delay == 0) {
                                        disrupter.delay = 20;
                                        entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(-0.1));
                                        entity.damage(BulwarkDamageSources.radiation(entity), 0.5f);
                                        if (world instanceof ServerWorld serverWorld) {
                                            serverWorld.spawnParticles(BulwarkParticles.DISRUPTER
                                                    , entity.getX(), entity.getY() + 1.0f, entity.getZ(),
                                                    4,
                                                    0.03f,
                                                    0.03f,
                                                    0.03f,
                                                    0.02f
                                            );

                                            serverWorld.spawnParticles(BulwarkParticles.SHOCKWAVE
                                                    , disrupter.pos.getX() + 0.5f, disrupter.pos.getY() + 0.5f, disrupter.pos.getZ() + 0.5f,
                                                    4,
                                                    0.3f,
                                                    0.3f,
                                                    0.3f,
                                                    0.02f
                                            );
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (aboveState.isIn(AcornBlockTags.PLUSHIES)) {
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.playSound(null, pos, BulwarkSounds.PLUSH_EXPLODE, SoundCategory.MASTER, 1, 5);
                serverWorld.createExplosion(null, disrupter.pos.getX() + 0.5f, disrupter.pos.getY() + 0.5f, disrupter.pos.getZ() + 0.5f, 6.7f, World.ExplosionSourceType.BLOCK);
            }
        }
    }

    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {

     //   this.ownerUuids = nbt.get("ownerUuids");

        this.ownerUuid = nbt.getString("ownerUuid");
        this.startingDelay = nbt.getInt("startingDelay");
        this.delay = nbt.getInt("delay");
        this.active = nbt.getBoolean("active");
        super.readNbt(nbt, registryLookup);
    }

    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
 //       nbt.put("ownerUuids", ownerUuids);
        nbt.putString("ownerUuid", ownerUuid);
        nbt.putInt("startingDelay", startingDelay);
        nbt.putInt("delay", delay);
        nbt.putBoolean("active", active);
        super.writeNbt(nbt, registryLookup);
    }
}
