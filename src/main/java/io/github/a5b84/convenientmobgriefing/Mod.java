package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;

public class Mod implements ModInitializer {

  private static final String NAMESAPCE = "convenient_mobgriefing";

  public static final GameRule<Boolean> LENIENT_GRIEFING = registerRule("lenient_griefing");
  public static final GameRule<Boolean> WITHER_GRIEFING = registerRule("wither_griefing");
  public static final GameRule<Boolean> DRAGON_GRIEFING = registerRule("dragon_griefing");

  /**
   * Rule to use when not {@code null} instead of {@link GameRules#MOB_GRIEFING} in calls to {@link
   * Level#explode}
   */
  public static GameRule<Boolean> explodeRuleOverride;

  /**
   * Rule to use when not {@code null} instead of {@link GameRules#MOB_GRIEFING} in calls to {@link
   * Projectile#mayInteract}
   */
  public static GameRule<Boolean> projectileMayInteractOverride;

  private static GameRule<Boolean> registerRule(String name) {
    return GameRuleBuilder.forBoolean(true)
        .category(GameRuleCategory.MOBS)
        .buildAndRegister(identifier(name));
  }

  private static Identifier identifier(String path) {
    return Identifier.fromNamespaceAndPath(NAMESAPCE, path);
  }

  @Override
  public void onInitialize() {
    // Everything is done in the static initializer
  }
}
