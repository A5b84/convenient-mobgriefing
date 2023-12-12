package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.world.GameRules;

public class Targets {
    // Can be referenced from mixins because constants are inlined at compilation

    /**
     * @see GameRules#getBoolean(GameRules.Key)
     */
    public static final String GET_RULE_BOOLEAN = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z";
}
