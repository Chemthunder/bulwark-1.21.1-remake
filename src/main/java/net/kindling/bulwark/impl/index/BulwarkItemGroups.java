package net.kindling.bulwark.impl.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import static net.kindling.bulwark.impl.index.BulwarkBlocks.*;
import static net.kindling.bulwark.impl.index.BulwarkItems.*;

public interface BulwarkItemGroups {
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Bulwark.id("bulwark"));
    ItemGroup MAIN = FabricItemGroup.builder()
            .icon(() -> new ItemStack(KLAPROTH))
            .displayName(Text.translatable("itemGroup.bulwark").styled(style -> style.withColor(0xbd00d8)))
            .build();

    static void index() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, MAIN);

        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(BulwarkItemGroups::addEntries);
    }

    private static void addEntries(FabricItemGroupEntries itemGroup) {
        itemGroup.add(KLAPROTH);
        itemGroup.add(KLAPROTH_CHUNK);
        itemGroup.add(KLAPROTH_BLOCK);
        itemGroup.add(KLAPROTH_PILLAR);

        itemGroup.add(SMALL_KLAPROTH_BUD);
        itemGroup.add(MEDIUM_KLAPROTH_BUD);
        itemGroup.add(LARGE_KLAPROTH_BUD);
        itemGroup.add(KLAPROTH_CLUSTER);
        itemGroup.add(BUDDING_KLAPROTH);

        itemGroup.add(DISRUPTER);
        itemGroup.add(RESTRICTOR);
        itemGroup.add(TAINTED_GLASS);
        itemGroup.add(OPERATOR_KEY);

        itemGroup.add(KLAPROTH_TUBE);
        itemGroup.add(LUMINANT_KLAPROTH_TUBE);
        itemGroup.add(RED_KLAPROTH_TUBE);
        itemGroup.add(SCULK_KLAPROTH_TUBE);
        itemGroup.add(SILLY_KLAPROTH_TUBE);

        itemGroup.add(KLAPMALLOW);
        itemGroup.add(KLAPMALLOW_STICK);
        itemGroup.add(KLAPROTH_CANDY);
    }
}
