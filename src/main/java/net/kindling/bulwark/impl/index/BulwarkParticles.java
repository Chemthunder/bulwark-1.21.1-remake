package net.kindling.bulwark.impl.index;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface BulwarkParticles {

    SimpleParticleType WARNING = FabricParticleTypes.simple(true);
    SimpleParticleType ACTINISM = FabricParticleTypes.simple(true);
    SimpleParticleType DISRUPTER = FabricParticleTypes.simple(true);

    SimpleParticleType SPARKLE_BASE = FabricParticleTypes.simple(true);
    SimpleParticleType SPARKLE_LUMINANT = FabricParticleTypes.simple(true);
    SimpleParticleType SPARKLE_RED = FabricParticleTypes.simple(true);
    SimpleParticleType SPARKLE_SCULK = FabricParticleTypes.simple(true);
    SimpleParticleType SPARKLE_SILLY_1 = FabricParticleTypes.simple(true);
    SimpleParticleType SPARKLE_SILLY_2 = FabricParticleTypes.simple(true);

    private static void create(String name, ParticleType<?> particle) {
        Registry.register(Registries.PARTICLE_TYPE, Bulwark.id(name), particle);
    }

    static void index() {
        create("warning", WARNING);
        create("actinism", ACTINISM);
        create("disrupter", DISRUPTER);

        create("sparkle_base", SPARKLE_BASE);
        create("sparkle_luminant", SPARKLE_LUMINANT);
        create("sparkle_red", SPARKLE_RED);
        create("sparkle_sculk", SPARKLE_SCULK);
        create("sparkle_silly_1", SPARKLE_SILLY_1);
        create("sparkle_silly_2", SPARKLE_SILLY_2);
    }

    static void clientIndex() {
        ParticleFactoryRegistry.getInstance().register(WARNING, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ACTINISM, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(DISRUPTER, EndRodParticle.Factory::new);

        ParticleFactoryRegistry.getInstance().register(SPARKLE_BASE, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPARKLE_LUMINANT, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPARKLE_RED, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPARKLE_SCULK, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPARKLE_SILLY_1, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SPARKLE_SILLY_2, EndRodParticle.Factory::new);
    }
}
