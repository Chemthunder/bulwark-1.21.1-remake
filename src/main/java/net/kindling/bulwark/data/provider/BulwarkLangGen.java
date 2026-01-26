package net.kindling.bulwark.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.kindling.bulwark.impl.index.BulwarkBlocks.*;
import static net.kindling.bulwark.impl.index.BulwarkItems.KLAPROTH;
import static net.kindling.bulwark.impl.index.BulwarkItems.OPERATOR_KEY;

public class BulwarkLangGen extends FabricLanguageProvider {
    public BulwarkLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // items
        translationBuilder.add(KLAPROTH, "Klaproth");
        translationBuilder.add(OPERATOR_KEY, "Operator Key");


        // blocks
        translationBuilder.add(KLAPROTH_BLOCK, "Block of Klaproth");
        translationBuilder.add(DISRUPTER, "Disrupter");
        translationBuilder.add(RESTRICTOR, "Restrictor");

        translationBuilder.add(KLAPROTH_TUBE, "Klaproth Tube");
        translationBuilder.add(RED_KLAPROTH_TUBE, "Red Klaproth Tube");
        translationBuilder.add(SCULK_KLAPROTH_TUBE, "Sculk Klaproth Tube");
        translationBuilder.add(LUMINANT_KLAPROTH_TUBE, "Luminant Klaproth Tube");
        translationBuilder.add(SILLY_KLAPROTH_TUBE, "Silly Klaproth Tube");

        // misc
        translationBuilder.add("itemGroup.bulwark", "Bulwark");
    }
}
