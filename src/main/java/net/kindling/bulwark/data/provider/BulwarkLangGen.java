package net.kindling.bulwark.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.kindling.bulwark.impl.index.BulwarkBlocks.*;
import static net.kindling.bulwark.impl.index.BulwarkItems.*;

public class BulwarkLangGen extends FabricLanguageProvider {
    public BulwarkLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // items
        translationBuilder.add(KLAPROTH, "Klaproth");
        translationBuilder.add(KLAPROTH_CHUNK, "Klaproth Chunk");
        translationBuilder.add(IMPURE_KLAPROTH, "Impure Klaproth");

        translationBuilder.add(OPERATOR_KEY, "Operator Key");

        translationBuilder.add(KLAPMALLOW, "Klapmallow");
        translationBuilder.add(KLAPMALLOW_STICK, "Klapmallow on a Stick");
        translationBuilder.add(KLAPROTH_CANDY, "Klaproth Candy");

        translationBuilder.add(ILL_BOTTLE, "Bottle of Ill Substance");

        translationBuilder.add(COMICALLY_LARGE_LOLLIPOP, "Comically Large Lollipop");

        // blocks
        translationBuilder.add(KLAPROTH_BLOCK, "Block of Klaproth");
        translationBuilder.add(KLAPROTH_PILLAR, "Klaproth Pillar");

        translationBuilder.add(DISRUPTER, "Disrupter");
        translationBuilder.add(RESTRICTOR, "Restrictor");
        translationBuilder.add(TAINTED_GLASS, "Tainted Glass");

        translationBuilder.add(KLAPROTH_TUBE, "Klaproth Tube");
        translationBuilder.add(RED_KLAPROTH_TUBE, "Red Klaproth Tube");
        translationBuilder.add(SCULK_KLAPROTH_TUBE, "Sculk Klaproth Tube");
        translationBuilder.add(LUMINANT_KLAPROTH_TUBE, "Luminant Klaproth Tube");
        translationBuilder.add(SILLY_KLAPROTH_TUBE, "Silly Klaproth Tube");
        translationBuilder.add(ORANGE_KLAPROTH_TUBE, "Orange Klaproth Tube");
        translationBuilder.add(EXOTIC_KLAPROTH_TUBE, "Exotic Klaproth Tube");

        translationBuilder.add(SMALL_KLAPROTH_BUD, "Small Klaproth Bud");
        translationBuilder.add(MEDIUM_KLAPROTH_BUD, "Medium Klaproth Bud");
        translationBuilder.add(LARGE_KLAPROTH_BUD, "Large Klaproth Bud");
        translationBuilder.add(KLAPROTH_CLUSTER, "Klaproth Cluster");
        translationBuilder.add(BUDDING_KLAPROTH, "Budding Klaproth");

        translationBuilder.add(ILL_SUBSTANCE, "Ill Substance");
        translationBuilder.add(OMINOUS_CATALYST, "Ominous Catalyst");

        // misc
        translationBuilder.add("itemGroup.bulwark", "Bulwark");
        translationBuilder.add("effect.bulwark.actinism", "Actinism");

        translationBuilder.add("item.minecraft.potion.effect.actinism", "Potion of Distortion");
        translationBuilder.add("item.minecraft.splash_potion.effect.actinism", "Splash Potion of Distortion");
        translationBuilder.add("item.minecraft.lingering_potion.effect.actinism", "Lingering Potion of Distortion");
        translationBuilder.add("item.minecraft.tipped_arrow.effect.actinism", "Arrow of Distortion");

        translationBuilder.add("tooltip.roasted", "Roasted");
        translationBuilder.add("text.lollipop", "yummers");
    }
}
