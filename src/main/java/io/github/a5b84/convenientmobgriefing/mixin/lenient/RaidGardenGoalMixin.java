package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.animal.rabbit.Rabbit;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Rabbits eating carrot crops */
@Mixin(Rabbit.RaidGardenGoal.class)
public abstract class RaidGardenGoalMixin {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<OverrideMode> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.RABBITS_EAT_CARROTS;
  }
}
