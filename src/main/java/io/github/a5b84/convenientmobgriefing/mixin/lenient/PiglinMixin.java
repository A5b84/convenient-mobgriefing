package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Piglin bartering */
@Mixin(Piglin.class)
public abstract class PiglinMixin {

  @ModifyArg(method = "wantsToPickUp", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return Mod.LENIENT_GRIEFING;
  }
}
