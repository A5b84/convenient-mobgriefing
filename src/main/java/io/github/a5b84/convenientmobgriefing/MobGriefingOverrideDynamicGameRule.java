package io.github.a5b84.convenientmobgriefing;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;

/** {@link DynamicGameRule} that supports rules returning an {@link OverrideMode} */
public class MobGriefingOverrideDynamicGameRule extends DynamicGameRule<Boolean> {

  private final GameRule<OverrideMode> overrideRule;
  private final GameRule<Boolean> baseRule;

  public MobGriefingOverrideDynamicGameRule(
      GameRule<OverrideMode> overrideRule, GameRule<Boolean> baseRule) {
    this.overrideRule = overrideRule;
    this.baseRule = baseRule;
  }

  @Override
  public Boolean evaluate(GameRules gameRules) {
    return switch (gameRules.get(overrideRule)) {
      case TRUE -> true;
      case FALSE -> false;
      case DEFAULT -> gameRules.get(baseRule);
    };
  }
}
