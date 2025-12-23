package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for foxes eating berries */
@Mixin(Fox.FoxEatBerriesGoal.class)
public abstract class EatBerriesGoalMixin {

  @ModifyArg(
      method = "onReachedTarget",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.FOXES_EAT_BERRIES;
  }
}
