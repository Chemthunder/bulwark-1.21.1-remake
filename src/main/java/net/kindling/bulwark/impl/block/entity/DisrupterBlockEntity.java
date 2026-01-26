package net.kindling.bulwark.impl.block.entity;

import net.kindling.bulwark.impl.index.BulwarkBlockEntities;
import net.kindling.bulwark.impl.index.BulwarkItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DisrupterBlockEntity extends BlockEntity {
    public DisrupterBlockEntity(BlockPos pos, BlockState state) {
        super(BulwarkBlockEntities.DISRUPTER, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, @NotNull DisrupterBlockEntity disrupter) {

        BlockState aboveState = world.getBlockState(pos.up());

        if (aboveState.isIn(BlockTags.AIR) || aboveState.isOf(Blocks.SCULK_SHRIEKER) || aboveState.isOf(Blocks.LODESTONE)) {
            Box area = new Box(pos).expand(aboveState.isIn(BlockTags.AIR) ? 7 : aboveState.isOf(Blocks.SCULK_SHRIEKER) ? 3 : 5);
            List<LivingEntity> entities = world.getEntitiesByClass(LivingEntity.class, area, entity -> true);

            for (LivingEntity entity : entities) {

                if (!((PlayerEntity) entity).getInventory().contains(BulwarkItems.OPERATOR_KEY.getDefaultStack())) {
                    entity.setVelocity(area.getCenter().subtract(entity.getPos()).multiply(-0.1));
                }
            }
        }
    }


}
