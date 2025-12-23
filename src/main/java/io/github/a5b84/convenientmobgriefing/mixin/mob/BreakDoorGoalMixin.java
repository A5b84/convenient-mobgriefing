package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Zombies and Vindicators breaking doors */
@Mixin(BreakDoorGoal.class)
public abstract class BreakDoorGoalMixin {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.MOBS_BREAK_DOORS;
  }
}
