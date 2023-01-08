package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.World;

public class Mod implements ModInitializer {

    public static final GameRules.Key<BooleanRule>
            LENIENT_GRIEFING = register("lenientGriefing"),
            WITHER_GRIEFING = register("witherGriefing"),
            DRAGON_GRIEFING = register("dragonGriefing");

    /**
     * Rule used to replace {@link GameRules#DO_MOB_GRIEFING} in calls to
     * {@link World#createExplosion}, or {@code null} to do nothing
     */
    public static GameRules.Key<BooleanRule> explosionRuleOverride;

    private static GameRules.Key<BooleanRule> register(String name) {
        return GameRuleRegistry.register(
                name, GameRules.Category.MOBS,
                GameRuleFactory.createBooleanRule(true)
        );
    }

    @Override
    public void onInitialize() {}

}
