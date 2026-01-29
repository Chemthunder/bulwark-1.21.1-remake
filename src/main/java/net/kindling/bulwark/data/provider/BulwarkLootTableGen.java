package net.kindling.bulwark.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kindling.bulwark.impl.index.BulwarkBlocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.kindling.bulwark.impl.index.BulwarkBlocks.*;

public class BulwarkLootTableGen extends FabricBlockLootTableProvider {
    public BulwarkLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generate() {
        addDrop(KLAPROTH_TUBE);
        addDrop(SCULK_KLAPROTH_TUBE);
        addDrop(RED_KLAPROTH_TUBE);
        addDrop(SILLY_KLAPROTH_TUBE);
        addDrop(LUMINANT_KLAPROTH_TUBE);

        addDrop(KLAPROTH_BLOCK);
        addDrop(KLAPROTH_PILLAR);

        addDrop(DISRUPTER);
        addDrop(RESTRICTOR);

        addDropWithSilkTouch(KLAPROTH_CLUSTER);
        addDropWithSilkTouch(LARGE_KLAPROTH_BUD);
        addDropWithSilkTouch(MEDIUM_KLAPROTH_BUD);
        addDropWithSilkTouch(SMALL_KLAPROTH_BUD);
    }
}
