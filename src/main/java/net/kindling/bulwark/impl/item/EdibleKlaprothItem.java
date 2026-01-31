package net.kindling.bulwark.impl.item;

import net.kindling.bulwark.impl.index.BulwarkItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class EdibleKlaprothItem extends Item {
    public EdibleKlaprothItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (stack.isOf(BulwarkItems.COMICALLY_LARGE_LOLLIPOP)) {
            if (user instanceof PlayerEntity player) {
                player.sendMessage(Text.translatable("text.lollipop").withColor(0x351f3d).formatted(Formatting.LIGHT_PURPLE).formatted(Formatting.ITALIC), true);
            }
        }

        return super.finishUsing(stack, world, user);
    }
}
