package net.kindling.bulwark.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.kindling.bulwark.data.provider.BulwarkLangGen;
import net.kindling.bulwark.data.provider.BulwarkModelGen;

public class BulwarkDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BulwarkLangGen::new);
        pack.addProvider(BulwarkModelGen::new);
	}
}
