package net.kindling.bulwark.impl.effect;

import net.kindling.bulwark.api.IgnoredByActinismEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class TestStatusEffect extends StatusEffect implements IgnoredByActinismEffect {
    public TestStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
}
