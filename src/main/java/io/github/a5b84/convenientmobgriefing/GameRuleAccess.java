package io.github.a5b84.convenientmobgriefing;

import net.minecraft.world.level.gamerules.GameRule;
import org.jspecify.annotations.Nullable;

/** Duck interface for additional {@link GameRule} methods */
public interface GameRuleAccess {

  @Nullable GameRule<Boolean> convenientMobGriefing_getBaseRule();

  void convenientMobGriefing_setBaseRule(GameRule<Boolean> baseRule);
}
