package net.kindling.bulwark.impl.index;

import com.mojang.serialization.Codec;
import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface BulwarkDataComponents {
    Map<ComponentType<?>, Identifier> COMPONENTS = new LinkedHashMap<>();

    ComponentType<Boolean> IS_ROASTED = create("is_roasted", new ComponentType.Builder<Boolean>()
            .codec(Codec.BOOL)
            .build()
    );

    static <T extends ComponentType<?>> T create(String name, T component) {
        COMPONENTS.put(component, Bulwark.id(name));
        return component;
    }

    static void index() {
        COMPONENTS.keySet().forEach(component -> {
            Registry.register(Registries.DATA_COMPONENT_TYPE, COMPONENTS.get(component), component);
        });
    }
}
