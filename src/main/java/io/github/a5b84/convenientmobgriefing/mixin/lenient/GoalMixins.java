package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Miscellaneous AI goals */
@Mixin(
    value = {StepAndDestroyBlockGoal.class, EvokerEntity.WololoGoal.class},
    targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
public abstract class GoalMixins {

  @ModifyArg(method = "canStart()Z", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanRule> old) {
    return LENIENT_GRIEFING;
  }
}
