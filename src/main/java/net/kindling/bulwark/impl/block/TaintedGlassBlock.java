package net.kindling.bulwark.impl.block;

import net.kindling.bulwark.impl.util.BulwarkProperties;
import net.kindling.bulwark.impl.util.enumProperties.TaintedGlassType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TaintedGlassBlock extends Block {
    public TaintedGlassBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(TYPE, TaintedGlassType.EMPTY)
        );
    }

    private static final EnumProperty<TaintedGlassType> TYPE = BulwarkProperties.GLASS_TYPE;

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(TYPE);
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockPos north = pos.north();
        BlockPos up = pos.up();
        BlockPos down = pos.down();
        BlockPos east = pos.east();
        BlockPos south = pos.south();
        BlockPos west = pos.west();


        if (player.getStackInHand(player.getActiveHand()).isOf(Items.AMETHYST_SHARD)) {
            world.setBlockState(pos, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));

            if (world.getBlockState(north).isOf(this)) {
                world.setBlockState(north, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }

            if (world.getBlockState(up).isOf(this)) {
                world.setBlockState(up, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }

            if (world.getBlockState(down).isOf(this)) {
                world.setBlockState(down, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }

            if (world.getBlockState(east).isOf(this)) {
                world.setBlockState(east, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }

            if (world.getBlockState(south).isOf(this)) {
                world.setBlockState(south, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }

            if (world.getBlockState(west).isOf(this)) {
                world.setBlockState(west, world.getBlockState(pos).with(TYPE, TaintedGlassType.CRYSTALLIZED));
            }
        }

        if (player.getStackInHand(player.getActiveHand()).isOf(Items.IRON_NUGGET)) {
            world.setBlockState(pos, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));

            if (world.getBlockState(north).isOf(this)) {
                world.setBlockState(north, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }

            if (world.getBlockState(up).isOf(this)) {
                world.setBlockState(up, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }

            if (world.getBlockState(down).isOf(this)) {
                world.setBlockState(down, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }

            if (world.getBlockState(east).isOf(this)) {
                world.setBlockState(east, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }

            if (world.getBlockState(south).isOf(this)) {
                world.setBlockState(south, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }

            if (world.getBlockState(west).isOf(this)) {
                world.setBlockState(west, world.getBlockState(pos).with(TYPE, TaintedGlassType.METALLIC));
            }
        }

        if (player.getStackInHand(player.getActiveHand()).isOf(Items.AIR)) {
            world.setBlockState(pos, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));

            if (world.getBlockState(north).isOf(this)) {
                world.setBlockState(north, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }

            if (world.getBlockState(up).isOf(this)) {
                world.setBlockState(up, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }

            if (world.getBlockState(down).isOf(this)) {
                world.setBlockState(down, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }

            if (world.getBlockState(east).isOf(this)) {
                world.setBlockState(east, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }

            if (world.getBlockState(south).isOf(this)) {
                world.setBlockState(south, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }

            if (world.getBlockState(west).isOf(this)) {
                world.setBlockState(west, world.getBlockState(pos).with(TYPE, TaintedGlassType.EMPTY));
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }
}
