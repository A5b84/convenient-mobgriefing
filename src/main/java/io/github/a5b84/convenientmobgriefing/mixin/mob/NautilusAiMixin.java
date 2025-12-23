package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.animal.nautilus.NautilusAi;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Nautiluses (supposedly) attacking Armor Stands */
@Mixin(NautilusAi.class)
public abstract class NautilusAiMixin {

  @ModifyArg(method = "method_75171", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<OverrideMode> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.MOBS_AFFECT_INANIMATE_ENTITIES;
  }
}
