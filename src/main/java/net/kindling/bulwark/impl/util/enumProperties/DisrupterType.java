package net.kindling.bulwark.impl.util.enumProperties;

import net.minecraft.util.StringIdentifiable;

public enum DisrupterType implements StringIdentifiable {
    EMPTY("empty"),
    LODESTONE("lodestone"),
    CAMPFIRE("campfire"),
    SHRIEKER("shrieker");


    private final String name;

    DisrupterType(final String name) {
        this.name = name;
    }

    public String asString() {
        return name;
    }
}
