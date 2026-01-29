package net.kindling.bulwark.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

import static net.kindling.bulwark.impl.index.BulwarkBlocks.*;

public class BulwarkBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public BulwarkBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(DISRUPTER)
                .add(RESTRICTOR)

                .add(KLAPROTH_BLOCK)
                .add(KLAPROTH_PILLAR)

                .add(KLAPROTH_TUBE)
                .add(SCULK_KLAPROTH_TUBE)
                .add(RED_KLAPROTH_TUBE)
                .add(LUMINANT_KLAPROTH_TUBE)
                .add(SILLY_KLAPROTH_TUBE)

                .add(SMALL_KLAPROTH_BUD)
                .add(MEDIUM_KLAPROTH_BUD)
                .add(LARGE_KLAPROTH_BUD)
                .add(KLAPROTH_CLUSTER)

                ;

        this.getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(DISRUPTER)
                .add(RESTRICTOR)

                .add(KLAPROTH_BLOCK)
                .add(KLAPROTH_PILLAR)

                .add(KLAPROTH_TUBE)
                .add(SCULK_KLAPROTH_TUBE)
                .add(RED_KLAPROTH_TUBE)
                .add(LUMINANT_KLAPROTH_TUBE)
                .add(SILLY_KLAPROTH_TUBE)

                .add(SMALL_KLAPROTH_BUD)
                .add(MEDIUM_KLAPROTH_BUD)
                .add(LARGE_KLAPROTH_BUD)
                .add(KLAPROTH_CLUSTER)

        ;
    }
}
