package net.kindling.bulwark.impl.index;

import net.minecraft.component.type.FoodComponent;

public interface BulwarkFoodComponents {
    FoodComponent KLAPMALLOW = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(4)
            .build();

    FoodComponent KLAPMALLOW_STICK = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(8)
            .saturationModifier(4.0f)
            .build();

    static void index() {

    }
}
