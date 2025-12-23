package io.github.a5b84.convenientmobgriefing;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;

/** Transient {@link GameRule} that is evaluated on the fly. */
public abstract class DynamicGameRule<T> extends GameRule<T> {

  protected DynamicGameRule() {
    //noinspection DataFlowIssue
    super(null, null, null, null, null, null, null, null);
  }

  public abstract T evaluate(GameRules gameRules);
}
