package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface BulwarkPotions {

    Potion ACTINISM =
            Registry.register(
                    Registries.POTION,
                    Bulwark.id("actinism"),
                    new Potion("actinism",
                            new StatusEffectInstance(
                                    BulwarkStatusEffects.ACTINISM,
                                    3600,
                                    0)
                    )
            );


    static void index() {
        // :3
    }
}
