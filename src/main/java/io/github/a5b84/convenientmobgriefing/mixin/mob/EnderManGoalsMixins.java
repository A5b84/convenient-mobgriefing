package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Endermen picking up and placing blocks */
@Mixin({EnderMan.EndermanLeaveBlockGoal.class, EnderMan.EndermanTakeBlockGoal.class})
public abstract class EnderManGoalsMixins {

  @ModifyArg(method = "canUse", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<OverrideMode> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.ENDERMEN_MOVE_BLOCKS;
  }
}
