package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Zombies destroying turtle eggs */
@Mixin(RemoveBlockGoal.class)
public abstract class RemoveBlockGoalMixin {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<?> mobGriefingProxy(GameRule<Boolean> old) {
    if ((Object) this instanceof Zombie.ZombieAttackTurtleEggGoal) {
      return ModRules.MOBS_DAMAGE_TURTLE_EGGS;
    } else {
      return old;
    }
  }
}
