package net.kindling.bulwark.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static net.kindling.bulwark.impl.index.BulwarkItems.*;


public class BulwarkModelGen extends FabricModelProvider {
    public BulwarkModelGen(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator generator) {

    }

    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(KLAPROTH, Models.GENERATED);
        generator.register(OPERATOR_KEY, Models.GENERATED);
        generator.register(COMICALLY_LARGE_LOLLIPOP, Models.GENERATED);

        generator.register(KLAPMALLOW, Models.GENERATED);
        generator.register(KLAPMALLOW_STICK, Models.HANDHELD);
        generator.register(KLAPROTH_CANDY, Models.GENERATED);
    }
}
