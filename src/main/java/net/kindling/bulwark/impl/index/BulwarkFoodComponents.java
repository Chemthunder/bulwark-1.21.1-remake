package net.kindling.bulwark.impl.index;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Items;

public interface BulwarkFoodComponents {
    FoodComponent KLAPMALLOW = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(4)
            .build();

    FoodComponent KLAPMALLOW_STICK = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(8)
            .saturationModifier(4.0f)
            .usingConvertsTo(Items.STICK)
            .build();

    FoodComponent KLAPROTH_CANDY = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(4)
            .saturationModifier(1.5f)
            .usingConvertsTo(Items.PAPER)
            .build();

    FoodComponent LOLLIPOP = new FoodComponent.Builder()
            .alwaysEdible()
            .nutrition(0)
            .snack()
            .build();

    static void index() {

    }
}
