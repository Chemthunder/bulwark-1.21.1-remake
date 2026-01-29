package net.kindling.bulwark.impl.index;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
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
                                    600,
                                    0)
                    )
            );


    static void index() {
        registerRecipes();
    }

    static void registerRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(
                    Potions.WATER, // Base ingredient
                    BulwarkItems.KLAPROTH, // Input Ingredient
                    Registries.POTION.getEntry(ACTINISM) // output
            );
        });
    }
}
