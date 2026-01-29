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

    private static final VoxelShape SHAPE = createCuboidShape(3.0F, 0.0F, 3.0F, 13.0F, 10.0F, 13.0F);

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected boolean hasSidedTransparency(BlockState state) {
        return true;
    }
}
