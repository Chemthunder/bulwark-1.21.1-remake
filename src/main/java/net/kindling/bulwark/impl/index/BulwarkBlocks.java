package net.kindling.bulwark.impl.index;

import net.acoyt.acornlib.impl.item.TranslationBlockItem;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.block.*;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public interface BulwarkBlocks {
    Block KLAPROTH_BLOCK = createWithItem("klaproth_block", KlaprothBlock::new, Settings.copy(Blocks.AMETHYST_BLOCK).luminance(value -> 1).emissiveLighting((state, world, pos) -> true), new Item.Settings());
    Block KLAPROTH_PILLAR = createWithItem("klaproth_pillar", PillarBlock::new, Settings.copy(Blocks.AMETHYST_BLOCK).luminance(value -> 1).emissiveLighting((state, world, pos) -> true), new Item.Settings());

    Block DISRUPTER = createWithItem("disrupter", DisrupterBlock::new, Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.TRIAL_SPAWNER).emissiveLighting((state, world, pos) -> true).luminance(value -> 1), new Item.Settings());
    Block RESTRICTOR = createWithItem("restrictor", RestrictorBlock::new, Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.TRIAL_SPAWNER).emissiveLighting((state, world, pos) -> true).luminance(value -> 1), new Item.Settings());
    Block TAINTED_GLASS = createWithItem("tainted_glass", TaintedGlassBlock::new, Settings.copy(Blocks.TINTED_GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque(), new Item.Settings());

    Block BUDDING_KLAPROTH = createWithItem("budding_klaproth", BuddingKlaprothBlock::new, Settings.copy(Blocks.BUDDING_AMETHYST).nonOpaque().emissiveLighting((state, world, pos) -> true).sounds(BlockSoundGroup.BASALT).luminance(value -> 3), new Item.Settings());
    Block SMALL_KLAPROTH_BUD = createWithItem("small_klaproth_bud", KlaprothClusterBlock::new, Settings.copy(Blocks.SMALL_AMETHYST_BUD).nonOpaque().emissiveLighting((state, world, pos) -> true).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(value -> 2), new Item.Settings());
    Block MEDIUM_KLAPROTH_BUD = createWithItem("medium_klaproth_bud", KlaprothClusterBlock::new, Settings.copy(Blocks.SMALL_AMETHYST_BUD).nonOpaque().emissiveLighting((state, world, pos) -> true).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(value -> 4), new Item.Settings());
    Block LARGE_KLAPROTH_BUD = createWithItem("large_klaproth_bud", KlaprothClusterBlock::new, Settings.copy(Blocks.SMALL_AMETHYST_BUD).nonOpaque().emissiveLighting((state, world, pos) -> true).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(value -> 6), new Item.Settings());
    Block KLAPROTH_CLUSTER = createWithItem("klaproth_cluster", KlaprothClusterBlock::new, Settings.copy(Blocks.SMALL_AMETHYST_BUD).nonOpaque().emissiveLighting((state, world, pos) -> true).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(value -> 8), new Item.Settings());


    Block KLAPROTH_TUBE = createWithItem("klaproth_tube", KlaprothTubeBlock::new,
            Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.TRIAL_SPAWNER)
                    .emissiveLighting((state, world, pos) -> true).luminance(value -> 9),
            new Item.Settings().maxCount(16));

    Block LUMINANT_KLAPROTH_TUBE = createWithItem("klaproth_tube_luminant", KlaprothTubeBlock::new,
            Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.TRIAL_SPAWNER)
                    .emissiveLighting((state, world, pos) -> true).luminance(value -> 9),
            new Item.Settings().maxCount(16));

    Block SCULK_KLAPROTH_TUBE = createWithItem("klaproth_tube_sculk", KlaprothTubeBlock::new,
            Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.TRIAL_SPAWNER)
                    .emissiveLighting((state, world, pos) -> true).luminance(value -> 9),
            new Item.Settings().maxCount(16));

    Block SILLY_KLAPROTH_TUBE = createWithItem("klaproth_tube_silly", KlaprothTubeBlock::new,
            Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.TRIAL_SPAWNER)
                    .emissiveLighting((state, world, pos) -> true).luminance(value -> 9),
            new Item.Settings().maxCount(16));

    Block RED_KLAPROTH_TUBE = createWithItem("klaproth_tube_red", KlaprothTubeBlock::new,
            Settings.copy(Blocks.CHAIN).sounds(BlockSoundGroup.TRIAL_SPAWNER)
                    .emissiveLighting((state, world, pos) -> true).luminance(value -> 9),
            new Item.Settings().maxCount(16));

    static Block create(String name, Function<Settings, Block> factory, Settings settings) {
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, Bulwark.id(name), block);
    }

    static Block createWithItem(String name, Function<Settings, Block> factory, Settings settings, Item.Settings itemSetting) {
        Block block = create(name, factory, settings);
        BulwarkItems.create(name, itemSettings -> new TranslationBlockItem(block, itemSettings), itemSetting);
        return block;
    }

    static void index() {

    }

    static void clientIndex() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                KLAPROTH_CLUSTER,
                KLAPROTH_CLUSTER,
                SMALL_KLAPROTH_BUD,
                LARGE_KLAPROTH_BUD,
                MEDIUM_KLAPROTH_BUD,
                KLAPROTH_TUBE,
                RED_KLAPROTH_TUBE,
                SILLY_KLAPROTH_TUBE,
                SCULK_KLAPROTH_TUBE,
                LUMINANT_KLAPROTH_TUBE
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
                TAINTED_GLASS
        );

    }
}
