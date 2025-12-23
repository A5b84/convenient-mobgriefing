package io.github.a5b84.convenientmobgriefing.mixin.wither;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.gamerules.GameRule;
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
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<OverrideMode> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.WITHER_DESTROYS_BLOCKS_WHEN_HURT;
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
    ModRules.explodeRuleOverride = ModRules.WITHER_EXPLOSIONS;
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
    ModRules.explodeRuleOverride = null;
  }
}
