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

    private static void create(String name, ParticleType<?> particle) {
        Registry.register(Registries.PARTICLE_TYPE, Bulwark.id(name), particle);
    }

    static void index() {
        create("warning", WARNING);
    }

    static void clientIndex() {
        ParticleFactoryRegistry.getInstance().register(WARNING, EndRodParticle.Factory::new);
    }
}
