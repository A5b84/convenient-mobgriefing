package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Allays picking up items */
@Mixin(Allay.class)
public abstract class AllayMixin {

  @ModifyArg(
      method = "wantsToPickUp",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return Mod.LENIENT_GRIEFING;
  }
}
