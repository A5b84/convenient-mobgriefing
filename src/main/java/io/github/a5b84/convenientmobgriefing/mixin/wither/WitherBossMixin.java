package io.github.a5b84.convenientmobgriefing.mixin.wither;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherBoss.class)
public abstract class WitherBossMixin {

  /** Wither destroying blocks when hurt */
  @ModifyArg(
      method = "customServerAiStep",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return Mod.WITHER_GRIEFING;
  }

  /** Initial explosion */
  @Inject(
      method = "customServerAiStep",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/server/level/ServerLevel;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"))
  private void enableMobGriefingOverride(CallbackInfo ci) {
    Mod.createExplosionRuleOverride = Mod.WITHER_GRIEFING;
  }

  @Inject(
      method = "customServerAiStep",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/server/level/ServerLevel;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V",
              shift = At.Shift.AFTER))
  private void disableMobGriefingOverride(CallbackInfo ci) {
    Mod.createExplosionRuleOverride = null;
  }
}
