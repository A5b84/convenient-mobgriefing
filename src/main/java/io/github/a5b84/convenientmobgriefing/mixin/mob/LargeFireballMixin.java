package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.projectile.hurtingprojectile.LargeFireball;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LargeFireball.class)
public abstract class LargeFireballMixin {

  @ModifyArg(method = "onHit", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.FIREBALL_EXPLOSIONS;
  }

  @Inject(
      method = "onHit",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"))
  private void enableMobGriefingOverride(CallbackInfo ci) {
    ModRules.explodeRuleOverride = ModRules.FIREBALL_EXPLOSIONS;
  }

  @Inject(
      method = "onHit",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V",
              shift = At.Shift.AFTER))
  private void disableMobGriefingOverride(CallbackInfo ci) {
    ModRules.explodeRuleOverride = null;
  }
}
