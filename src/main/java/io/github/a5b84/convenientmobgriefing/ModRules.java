package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;
import org.jspecify.annotations.Nullable;

public final class ModRules {

  private ModRules() {}

  public static final GameRule<Boolean> LENIENT_GRIEFING = registerBaseRule("lenient_griefing");
  public static final GameRule<Boolean> WITHER_GRIEFING = registerBaseRule("wither_griefing");
  public static final GameRule<Boolean> DRAGON_GRIEFING = registerBaseRule("dragon_griefing");

  public static final GameRule<Boolean>
      CREEPER_EXPLOSIONS = registerOverrideRule("creeper_explosions", GameRules.MOB_GRIEFING),
      ENDERMEN_MOVE_BLOCKS = registerOverrideRule("endermen_move_blocks", GameRules.MOB_GRIEFING),
      FIREBALL_EXPLOSIONS = registerOverrideRule("fireball_explosions", GameRules.MOB_GRIEFING),
      FIREBALLS_CREATE_FIRE = registerOverrideRule("fireballs_create_fire", GameRules.MOB_GRIEFING),
      MOBS_AFFECT_INANIMATE_ENTITIES =
          registerOverrideRule("mobs_affect_inanimate_entities", GameRules.MOB_GRIEFING),
      MOBS_BREAK_DOORS = registerOverrideRule("mobs_break_doors", GameRules.MOB_GRIEFING),
      SILVERFISH_INFESTATION =
          registerOverrideRule("silverfish_infestation", GameRules.MOB_GRIEFING),
      ALLAYS_PICK_UP_ITEMS = registerOverrideRule("allays_pick_up_items", LENIENT_GRIEFING),
      CREATE_WITHER_ROSES = registerOverrideRule("create_wither_roses", LENIENT_GRIEFING),
      EVOKERS_CONVERT_SHEEP = registerOverrideRule("evokers_convert_sheep", LENIENT_GRIEFING),
      FARMLAND_TRAMPLING = registerOverrideRule("farmland_trampling", LENIENT_GRIEFING),
      FOXES_EAT_BERRIES = registerOverrideRule("foxes_eat_berries", LENIENT_GRIEFING),
      MOBS_DAMAGE_TURTLE_EGGS = registerOverrideRule("mobs_damage_turtle_eggs", LENIENT_GRIEFING),
      MOBS_MELT_POWDER_SNOW = registerOverrideRule("mobs_melt_powder_snow", LENIENT_GRIEFING),
      MOBS_PICK_UP_ITEMS = registerOverrideRule("mobs_pick_up_items", LENIENT_GRIEFING),
      MOB_PROJECTILES_AFFECT_BLOCKS =
          registerOverrideRule("mob_projectiles_affect_blocks", LENIENT_GRIEFING),
      PIGLIN_BARTERING = registerOverrideRule("piglin_bartering", LENIENT_GRIEFING),
      RABBITS_EAT_CARROTS = registerOverrideRule("rabbits_eat_carrots", LENIENT_GRIEFING),
      RAVAGER_GRIEFING = registerOverrideRule("ravager_griefing", LENIENT_GRIEFING),
      SHEEP_EAT_GRASS = registerOverrideRule("sheep_eat_grass", LENIENT_GRIEFING),
      SNOW_GOLEMS_PLACE_SNOW = registerOverrideRule("snow_golems_place_snow", LENIENT_GRIEFING),
      VILLAGER_FARMING = registerOverrideRule("villager_farming", LENIENT_GRIEFING),
      WEAVING_CREATES_COBWEBS = registerOverrideRule("weaving_creates_cobwebs", LENIENT_GRIEFING),
      WIND_AFFECTS_WORLD = registerOverrideRule("wind_affects_world", LENIENT_GRIEFING),
      WITHER_EXPLOSIONS = registerOverrideRule("explosions", WITHER_GRIEFING),
      WITHER_DESTROYS_BLOCKS_WHEN_HURT =
          registerOverrideRule("destroys_blocks_when_hurt", WITHER_GRIEFING);

  /**
   * Rule to use instead of {@link GameRules#MOB_GRIEFING} in calls to {@link Level#explode}. Should
   * be ignored when {@code null}
   */
  @Nullable public static GameRule<Boolean> explodeRuleOverride;

  /**
   * Rule to use instead of {@link GameRules#MOB_GRIEFING} in calls to {@link
   * Projectile#mayInteract}. Should be ignored when {@code null}
   */
  @Nullable public static GameRule<Boolean> projectileMayInteractOverride;

  private static GameRule<Boolean> registerBaseRule(String name) {
    return GameRuleBuilder.forBoolean(true)
        .category(GameRuleCategory.MOBS)
        .buildAndRegister(Mod.identifier(name));
  }

  private static GameRule<Boolean> registerOverrideRule(String name, GameRule<Boolean> baseRule) {
    Identifier baseRuleIdentifier = baseRule.getIdentifier();
    Identifier overrideIdentifier =
        Mod.identifier(baseRuleIdentifier.getPath() + ".override." + name);
    GameRule<OverrideMode> overrideRule =
        GameRuleBuilder.forEnum(OverrideMode.DEFAULT)
            .category(GameRuleCategory.MOBS)
            .buildAndRegister(overrideIdentifier);
    return new MobGriefingOverrideDynamicGameRule(overrideRule, baseRule);
  }

  public static void registerRules() {
    // Everything is done in the static initializer
  }
}
