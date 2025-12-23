package io.github.a5b84.convenientmobgriefing.mixin;

import io.github.a5b84.convenientmobgriefing.ModRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

  @ModifyArg(method = "explode", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<?> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.explodeRuleOverride != null ? ModRules.explodeRuleOverride : old;
  }
}
