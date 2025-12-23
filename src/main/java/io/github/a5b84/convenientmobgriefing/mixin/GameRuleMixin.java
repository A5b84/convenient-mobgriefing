package io.github.a5b84.convenientmobgriefing.mixin;

import io.github.a5b84.convenientmobgriefing.GameRuleAccess;
import net.minecraft.world.level.gamerules.GameRule;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/** Mixin that makes game rules implement {@link GameRuleAccess} */
@Mixin(GameRule.class)
public abstract class GameRuleMixin implements GameRuleAccess {

  @Unique @Nullable private GameRule<Boolean> baseRule;

  @Override
  @Nullable
  public GameRule<Boolean> convenientMobGriefing_getBaseRule() {
    return baseRule;
  }

  @Override
  public void convenientMobGriefing_setBaseRule(GameRule<Boolean> baseRule) {
    this.baseRule = baseRule;
  }
}
