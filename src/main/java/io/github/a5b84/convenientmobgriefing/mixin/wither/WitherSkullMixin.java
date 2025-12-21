package io.github.a5b84.convenientmobgriefing.mixin.wither;

import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

import net.minecraft.world.entity.projectile.WitherSkull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for Wither skull explosions */
@Mixin(WitherSkull.class)
public abstract class WitherSkullMixin {

  @Inject(
      method = "onHit",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;)V"))
  private void enableMobGriefingOverride(CallbackInfo ci) {
    createExplosionRuleOverride = WITHER_GRIEFING;
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
    createExplosionRuleOverride = null;
  }
}
