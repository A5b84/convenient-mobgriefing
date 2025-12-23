package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.animal.goat.GoatAi;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Goats ramming Armor Stands */
@Mixin(GoatAi.class)
public abstract class GoatAiMixin {

  @ModifyArg(method = "method_36285", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.MOBS_AFFECT_INANIMATE_ENTITIES;
  }
}
