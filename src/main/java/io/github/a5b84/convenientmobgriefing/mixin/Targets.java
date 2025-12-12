package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;

public class Targets {
    // Can be referenced from mixins because constants are inlined at compilation

    /**
     * @see GameRules#getValue(GameRule)
     */
    public static final String GET_RULE_VALUE = "Lnet/minecraft/world/rule/GameRules;getValue(Lnet/minecraft/world/rule/GameRule;)Ljava/lang/Object;";
}
