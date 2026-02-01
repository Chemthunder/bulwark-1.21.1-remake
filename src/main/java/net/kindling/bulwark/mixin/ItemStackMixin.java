package net.kindling.bulwark.mixin;

import net.kindling.bulwark.impl.index.BulwarkBlocks;
import net.kindling.bulwark.impl.index.BulwarkItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void bulwark$turnSculkCatalystIntoOminous(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if (player != null) {
            if (player.getStackInHand(player.getActiveHand()).isOf(Items.OMINOUS_BOTTLE)) {
                if (world.getBlockState(context.getBlockPos()).isOf(Blocks.SCULK_CATALYST)) {
                    world.setBlockState(context.getBlockPos(), BulwarkBlocks.OMINOUS_CATALYST.getDefaultState());
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SCULK_CATALYST_BLOOM, SoundCategory.BLOCKS, 1, 1);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_CONDUIT_ACTIVATE, SoundCategory.BLOCKS, 1, 1);
                    player.getStackInHand(player.getActiveHand()).decrement(1);
                    player.swingHand(player.getActiveHand());
                    cir.setReturnValue(ActionResult.FAIL);
                }
            }

            if (player.getStackInHand(player.getActiveHand()).isOf(Items.GLASS_BOTTLE)) {
                if (world.getBlockState(context.getBlockPos()).isOf(BulwarkBlocks.ILL_SUBSTANCE)) {
                    world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                    player.giveItemStack(BulwarkItems.ILL_BOTTLE.getDefaultStack());
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_WEEPING_VINES_BREAK, SoundCategory.BLOCKS, 1, 1);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SCULK_BREAK, SoundCategory.BLOCKS, 1, 1);
                    player.getStackInHand(player.getActiveHand()).decrement(1);
                }
            }

            if (player.getStackInHand(player.getActiveHand()).isOf(Items.BONE_MEAL)) {
                if (world.getBlockState(context.getBlockPos()).isOf(BulwarkBlocks.OMINOUS_CATALYST)) {
                    if (world.getBlockState(context.getBlockPos().down()).isOf(Blocks.AIR)) {
                        world.setBlockState(context.getBlockPos().down(), BulwarkBlocks.ILL_SUBSTANCE.getDefaultState());
                        world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_WEEPING_VINES_BREAK, SoundCategory.BLOCKS, 1, 1);
                        world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_SCULK_BREAK, SoundCategory.BLOCKS, 1, 1);

                        if (world instanceof ServerWorld serverWorld) {
                            serverWorld.spawnParticles(ParticleTypes.HAPPY_VILLAGER, context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ(), 5, 0.7f, 0.7f, 0.7f, 0);
                        }
                        player.swingHand(player.getActiveHand());
                        player.getStackInHand(player.getActiveHand()).decrement(1);
                    }
                }
            }
        }
    }
}
