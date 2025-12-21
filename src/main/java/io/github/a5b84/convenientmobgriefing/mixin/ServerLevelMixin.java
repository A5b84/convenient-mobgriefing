package io.github.a5b84.convenientmobgriefing.mixin;

import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

  @ModifyArg(method = "explode", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return createExplosionRuleOverride != null ? createExplosionRuleOverride : old;
  }
}
