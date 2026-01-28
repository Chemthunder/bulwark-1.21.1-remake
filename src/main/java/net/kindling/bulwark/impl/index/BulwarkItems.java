package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.kindling.bulwark.impl.block.item.KlaprothBlockItem;
import net.kindling.bulwark.impl.item.ComicallyLargeLollipopItem;
import net.kindling.bulwark.impl.item.KlaprothItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.Function;

import static net.acoyt.acornlib.api.util.ItemUtils.modifyItemNameColor;

@SuppressWarnings("deprecation")
public interface BulwarkItems {

    Item KLAPROTH = create("klaproth", KlaprothItem::new, new Item.Settings()
            .maxCount(16)
            .fireproof()
    );


    // blockItems
    Item KLAPROTH_BLOCK_ITEM = create("klaproth_block", KlaprothBlockItem::new, new Item.Settings());


    // misc
    Item OPERATOR_KEY = create("operator_key", Item::new, new Item.Settings().maxCount(1));
    Item COMICALLY_LARGE_LOLLIPOP = create("comically_large_lollipop", ComicallyLargeLollipopItem::new, new Item.Settings().maxCount(1));


    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Bulwark.id(name), item);
    }

    static void index() {
        modifyItemNameColor(Item.fromBlock(BulwarkBlocks.LUMINANT_KLAPROTH_TUBE), 0xffbc5e);
        modifyItemNameColor(Item.fromBlock(BulwarkBlocks.RED_KLAPROTH_TUBE), 0xfd4b57);
        modifyItemNameColor(Item.fromBlock(BulwarkBlocks.SCULK_KLAPROTH_TUBE), 0x009295);
        modifyItemNameColor(Item.fromBlock(BulwarkBlocks.SILLY_KLAPROTH_TUBE), 0xffa1fe);
        modifyItemNameColor(Item.fromBlock(BulwarkBlocks.KLAPROTH_TUBE), 0xd5c3f5);
    }
}
