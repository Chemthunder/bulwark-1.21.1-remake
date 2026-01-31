package net.kindling.bulwark.impl.item;

import net.kindling.bulwark.impl.index.BulwarkBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IllBottleItem extends Item {
    public IllBottleItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (state.isOf(Blocks.BUDDING_AMETHYST)) {
            if (player != null) {
                world.setBlockState(pos, BulwarkBlocks.BUDDING_KLAPROTH.getDefaultState());
                world.playSound(null, pos, SoundEvents.BLOCK_CONDUIT_ACTIVATE, SoundCategory.BLOCKS, 1, 1);
                world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
                player.getStackInHand(player.getActiveHand()).decrement(1);
            }
        }
        return super.useOnBlock(context);
    }
}
