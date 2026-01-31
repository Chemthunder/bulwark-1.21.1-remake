package net.kindling.bulwark.impl.item;

import net.acoyt.acornlib.api.item.ModelVaryingItem;
import net.acoyt.acornlib.api.util.MiscUtils;
import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ComicallyLargeLollipopItem extends EdibleKlaprothItem implements ModelVaryingItem {
    public ComicallyLargeLollipopItem(Settings settings) {
        super(settings);
    }

    public Identifier getModel(ModelTransformationMode renderMode, ItemStack stack, @Nullable LivingEntity entity) {
        return MiscUtils.isGui(renderMode) ? Bulwark.id("comically_large_lollipop") : Bulwark.id("lollipop_hand");
    }

    public List<Identifier> getModelsToLoad() {
        return Arrays.asList(
                Bulwark.id("comically_large_lollipop"),
                Bulwark.id("lollipop_hand")
        );
    }

    public SoundEvent getEatSound() {
        return SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE;
    }
}
