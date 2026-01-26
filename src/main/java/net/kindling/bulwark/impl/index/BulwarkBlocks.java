package net.kindling.bulwark.impl.index;

import net.acoyt.acornlib.impl.item.TranslationBlockItem;
import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.block.DisrupterBlock;
import net.kindling.bulwark.impl.block.KlaprothBlock;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public interface BulwarkBlocks {
    Block KLAPROTH_BLOCK = create("klaproth_block", KlaprothBlock::new, Settings.copy(Blocks.AMETHYST_BLOCK));
    Block DISRUPTER = createWithItem("disrupter", DisrupterBlock::new, Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.TRIAL_SPAWNER).emissiveLighting((state, world, pos) -> true).luminance(value -> 1), new Item.Settings());

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

    static void clientIndex() {}
}
