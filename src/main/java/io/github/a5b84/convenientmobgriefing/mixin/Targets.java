package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;

public class Targets {
  // Can be referenced from mixins because constants are inlined at compilation

  /**
   * @see GameRules#get(GameRule)
   */
  public static final String GET_RULE_VALUE =
      "Lnet/minecraft/world/level/gamerules/GameRules;get(Lnet/minecraft/world/level/gamerules/GameRule;)Ljava/lang/Object;";
}
