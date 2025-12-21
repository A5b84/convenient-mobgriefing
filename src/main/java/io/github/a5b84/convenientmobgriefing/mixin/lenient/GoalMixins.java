package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for miscellaneous AI goals */
@Mixin(
    value = {RemoveBlockGoal.class, Evoker.EvokerWololoSpellGoal.class},
    targets = "net/minecraft/world/entity/animal/Rabbit$RaidGardenGoal")
public abstract class GoalMixins {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return Mod.LENIENT_GRIEFING;
  }
}
