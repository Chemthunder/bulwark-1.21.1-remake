package net.kindling.bulwark.impl.effect;

import net.kindling.bulwark.impl.index.BulwarkParticles;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;

public class ActinismStatusEffect extends StatusEffect {
    public ActinismStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public ParticleEffect createParticle(StatusEffectInstance effect) {
        return new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.AIR.getDefaultState());
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 5;
        return duration % i == 0;
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.spawnParticles(BulwarkParticles.ACTINISM, entity.getX(), entity.getY(), entity.getZ(), 1, 0.5, 0.7, 0.5, 0.04);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }
}
