package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.effect.WeavingMobEffect;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for entities with the Weaving status effect placing cobweb on death */
@Mixin(WeavingMobEffect.class)
public abstract class WeavingMobEffectMixin {

  @ModifyArg(method = "onMobRemoved", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.WEAVING_CREATES_COBWEBS;
  }
}
