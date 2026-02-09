package net.kindling.bulwark.impl;

import net.acoyt.acornlib.api.ALib;
import net.fabricmc.api.ModInitializer;
import net.kindling.bulwark.impl.index.*;
import net.kindling.bulwark.impl.util.BulwarkProperties;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bulwark implements ModInitializer {
	public static final String MOD_ID = "bulwark";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }

	public void onInitialize() {
        BulwarkParticles.index();
        BulwarkBlocks.index();
        BulwarkBlockEntities.index();
        BulwarkItems.index();
        BulwarkItemGroups.index();
        BulwarkProperties.index();
        BulwarkStatusEffects.index();
        BulwarkSounds.index();
        BulwarkPotions.index();
        BulwarkDataComponents.index();
        BulwarkServerProperties.index();

		LOGGER.info("Kindling the cinders");

        ALib.registerModIcon(MOD_ID, Bulwark.id("lil_guy_but_he_sparkles.png"));
        ALib.registerModMenu(MOD_ID, 0xbd00d8);
	}
}