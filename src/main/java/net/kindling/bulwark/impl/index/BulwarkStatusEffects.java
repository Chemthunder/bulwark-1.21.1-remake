package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.effect.ActinismStatusEffect;
import net.kindling.bulwark.impl.effect.TestStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;

public interface BulwarkStatusEffects {
    RegistryEntry<StatusEffect> ACTINISM = create("actinism", new ActinismStatusEffect(StatusEffectCategory.HARMFUL, 0xbd00d8));
    RegistryEntry<StatusEffect> TEST = create("test", new TestStatusEffect(StatusEffectCategory.NEUTRAL, 0xbd00d8));

    private static RegistryEntry<StatusEffect> create(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Bulwark.id(name), statusEffect);
    }

    static void index() {
    }
}
