package net.kindling.bulwark.impl.item;

import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.index.BulwarkDataComponents;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class KlapmallowStickItem extends Item implements ModelVaryingItem {
    public KlapmallowStickItem(Settings settings) {
        super(settings
                .component(BulwarkDataComponents.IS_ROASTED, false)
        );
    }

    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();

        if (player != null) {
            Hand hand = player.getActiveHand();
            ItemStack stack = player.getStackInHand(hand);
            var component = BulwarkDataComponents.IS_ROASTED;

            if (stack.getOrDefault(component, false) == false) {
                stack.set(component, true);
                player.swingHand(hand);
                player.playSound(SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE);
                player.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE);
            }
        }

        return super.useOnBlock(context);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        var comp = BulwarkDataComponents.IS_ROASTED;

        if (stack.getOrDefault(comp, false) == true) {
            tooltip.add(Text.translatable("tooltip.roasted").withColor(0xffbd38));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        var comp = BulwarkDataComponents.IS_ROASTED;

        if (stack.getOrDefault(comp, false) == true) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400));
        }
        return super.finishUsing(stack, world, user);
    }

    public Identifier getModel(ModelTransformationMode modelTransformationMode, ItemStack itemStack, @Nullable LivingEntity livingEntity) {
        var component = BulwarkDataComponents.IS_ROASTED;

        if (itemStack.getOrDefault(component, false) == true) {
            return Bulwark.id("roasted_klapmallow_stick");
        }

        return Bulwark.id("klapmallow_stick");
    }


    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Bulwark.id("klapmallow_stick"),
                Bulwark.id("roasted_klapmallow_stick")
        );
    }
}
