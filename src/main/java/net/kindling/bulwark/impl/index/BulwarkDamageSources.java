package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface BulwarkDamageSources {
    RegistryKey<DamageType> RADIATION = of("radiation");
    static DamageSource radiation(LivingEntity entity) {
        return entity.getDamageSources().create(RADIATION);
    }


    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Bulwark.id(name));
    }
}