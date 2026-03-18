package net.kindling.bulwark.impl.index;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.GameRules;

public interface BulwarkServerProperties {

    GameRules.Key<GameRules.BooleanRule> KLAPROTH_CAN_GROW = GameRuleRegistry.register(
            "klaprothCanGrow",
            GameRules.Category.UPDATES,
            GameRuleFactory.createBooleanRule(true)
    );



    static void index() {
        FuelRegistry.INSTANCE.add(BulwarkItems.KLAPROTH, 432000);
    }
}
