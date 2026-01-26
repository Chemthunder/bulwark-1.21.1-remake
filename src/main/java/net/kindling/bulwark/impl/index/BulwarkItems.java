package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.block.item.KlaprothBlockItem;
import net.kindling.bulwark.impl.item.KlaprothItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.Function;

public interface BulwarkItems {

    Item KLAPROTH = create("klaproth", KlaprothItem::new, new Item.Settings()
            .maxCount(16)
            .fireproof()
    );


    // blockItems
    Item KLAPROTH_BLOCK_ITEM = create("klaproth_block", KlaprothBlockItem::new, new Item.Settings());


    // misc
    Item OPERATOR_KEY = create("operator_key", Item::new, new Item.Settings().maxCount(1));


    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Bulwark.id(name), item);
    }

    static void index() {

    }
}
