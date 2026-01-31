package net.kindling.bulwark.impl.block;

import net.kindling.bulwark.impl.index.BulwarkBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OminousCatalystBlock extends Block {
    public OminousCatalystBlock(Settings settings) {
        super(settings);
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos down = pos.down();

        if (world.getBlockState(down).isOf(Blocks.AIR)) {
            world.setBlockState(down, BulwarkBlocks.ILL_SUBSTANCE.getDefaultState());
            world.playSound(null, down, SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, SoundCategory.BLOCKS, 1, 1);
            world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
        }
        super.randomTick(state, world, pos, random);
    }
}
