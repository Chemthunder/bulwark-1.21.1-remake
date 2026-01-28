package net.kindling.bulwark.impl.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class KlaprothClusterBlock extends Block {
    public KlaprothClusterBlock(Settings settings) {
        super(settings);
    }

    //private static final VoxelShape SHAPE;

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getOutlineShape(state, world, pos, context);
    }

    // Block.createCuboidShape((double)xzOffset, (double)0.0F, (double)xzOffset, (double)(16.0F - xzOffset), (double)height, (double)(16.0F - xzOffset));

    static {
        //SHAPE = Block.createCuboidShape((double)xzOffset, (double)0.0F, (double)xzOffset, (double)(16.0F - xzOffset), (double)height, (double)(16.0F - xzOffset));
    }
}
