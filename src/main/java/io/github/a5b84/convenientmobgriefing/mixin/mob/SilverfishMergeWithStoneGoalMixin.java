package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Silverfish infesting blocks */
@Mixin(Silverfish.SilverfishMergeWithStoneGoal.class)
public abstract class SilverfishMergeWithStoneGoalMixin {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<OverrideMode> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.SILVERFISH_INFESTATION;
  }
}
