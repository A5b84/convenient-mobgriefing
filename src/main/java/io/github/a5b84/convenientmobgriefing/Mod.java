package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;
import net.minecraft.world.rule.GameRules;

public class Mod implements ModInitializer {

    public static final GameRule<Boolean>
            LENIENT_GRIEFING = register("lenient_griefing"),
            WITHER_GRIEFING = register("wither_griefing"),
            DRAGON_GRIEFING = register("dragon_griefing");

    /**
     * Rule used to replace {@link GameRules#MOB_GRIEFING} in calls to
     * {@link World#createExplosion}, or {@code null} to do nothing
     */
    public static GameRule<Boolean> createExplosionRuleOverride;

    /**
     * Rule used to replace {@link GameRules#MOB_GRIEFING} in calls to
     * {@link ProjectileEntity#canModifyAt}, or {@code null} to do nothing
     */
    public static GameRule<Boolean> canProjectileModifyAtRuleOverride;

    private static GameRule<Boolean> register(String name) {
        // Access widener makes this private method accessible
        return GameRules.registerBooleanRule(
                name,
                GameRuleCategory.MOBS,
                true
        );
    }

    @Override
    public void onInitialize() {
        // Everything is done in the static initializer
    }

}
