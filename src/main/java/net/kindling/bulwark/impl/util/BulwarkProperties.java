package net.kindling.bulwark.impl.util;

import net.kindling.bulwark.impl.util.enumProperties.DisrupterType;
import net.kindling.bulwark.impl.util.enumProperties.TaintedGlassType;
import net.minecraft.state.property.EnumProperty;

public class BulwarkProperties {
    public static final EnumProperty<DisrupterType> DISRUPTER_TYPE = EnumProperty.of("disrupter_type", DisrupterType.class);
    public static final EnumProperty<TaintedGlassType> GLASS_TYPE = EnumProperty.of("tainted_glass_type", TaintedGlassType.class);

    public static void index() {
        // :3
    }
}
