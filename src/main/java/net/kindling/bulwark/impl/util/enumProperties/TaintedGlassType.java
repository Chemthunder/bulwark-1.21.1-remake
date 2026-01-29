package net.kindling.bulwark.impl.util.enumProperties;

import net.minecraft.util.StringIdentifiable;

public enum TaintedGlassType implements StringIdentifiable {
    EMPTY("empty"),
    CRYSTALLIZED("crystallized"),
    METALLIC("metallic");

    private final String name;

    TaintedGlassType(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return name;
    }
}
