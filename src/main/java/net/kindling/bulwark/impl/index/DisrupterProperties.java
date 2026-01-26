package net.kindling.bulwark.impl.index;

import net.minecraft.state.property.BooleanProperty;

public interface DisrupterProperties {
    BooleanProperty LODESTONE = BooleanProperty.of("lodestone");
    BooleanProperty SHRIEKER = BooleanProperty.of("shrieker");

    static void index() {
        // :3
    }
}
