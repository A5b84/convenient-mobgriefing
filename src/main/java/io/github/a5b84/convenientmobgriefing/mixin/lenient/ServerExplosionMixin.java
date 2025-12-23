package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.level.ServerExplosion;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerExplosion.class)
public abstract class ServerExplosionMixin {

  @ModifyArg(
      method = "canTriggerBlocks",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<Boolean> canTriggerBlocksMobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.WIND_AFFECTS_WORLD;
  }

  @ModifyArg(
      method = "shouldAffectBlocklikeEntities",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<Boolean> shouldAffectBlocklikeEntitiesMobGriefingProxy(
      GameRule<Boolean> old) {
    return ModRules.WIND_AFFECTS_WORLD;
  }
}
