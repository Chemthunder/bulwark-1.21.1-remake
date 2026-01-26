package net.kindling.bulwark.impl.client;

import net.fabricmc.api.ClientModInitializer;
import net.kindling.bulwark.impl.index.BulwarkBlocks;
import net.kindling.bulwark.impl.index.BulwarkParticles;

public class BulwarkClient implements ClientModInitializer {


    public void onInitializeClient() {
        BulwarkParticles.clientIndex();
        BulwarkBlocks.clientIndex();
    }
}
