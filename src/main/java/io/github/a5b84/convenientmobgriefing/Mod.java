package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.Level;

public class Mod implements ModInitializer {

  public static final GameRules.Key<BooleanValue> LENIENT_GRIEFING = register("lenientGriefing"),
      WITHER_GRIEFING = register("witherGriefing"),
      DRAGON_GRIEFING = register("dragonGriefing");

  /**
   * Rule used to replace {@link GameRules#RULE_MOBGRIEFING} in calls to {@link
   * Level#explode}, or {@code null} to do nothing
   */
  public static GameRules.Key<BooleanValue> createExplosionRuleOverride;

  /**
   * Rule used to replace {@link GameRules#RULE_MOBGRIEFING} in calls to {@link
   * Projectile#mayInteract}, or {@code null} to do nothing
   */
  public static GameRules.Key<BooleanValue> canProjectileModifyAtRuleOverride;

  private static GameRules.Key<BooleanValue> register(String name) {
    return GameRuleRegistry.register(
        name, GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));
  }

  @Override
  public void onInitialize() {
    // Everything is done in the static initializer
  }
}
