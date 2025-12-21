package io.github.a5b84.convenientmobgriefing.mixin;

import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

  @ModifyArg(
      method = "createExplosion",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanRule> old) {
    return createExplosionRuleOverride != null ? createExplosionRuleOverride : old;
  }
}
