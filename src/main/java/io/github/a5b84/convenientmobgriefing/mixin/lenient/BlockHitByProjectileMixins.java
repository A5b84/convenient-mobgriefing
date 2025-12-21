package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.block.TntBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for blocks reacting to being hit by projectiles through {@link Block#onProjectileHit} */
@SuppressWarnings("JavadocReference")
@Mixin({CampfireBlock.class, ChorusFlowerBlock.class, PointedDripstoneBlock.class, TntBlock.class})
public class BlockHitByProjectileMixins {

  @Inject(
      method = "onProjectileHit",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/projectile/Projectile;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z"))
  private void enableMobGriefingOverride(CallbackInfo ci) {
    Mod.canProjectileModifyAtRuleOverride = Mod.LENIENT_GRIEFING;
  }

  @Inject(
      method = "onProjectileHit",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/projectile/Projectile;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z",
              shift = At.Shift.AFTER))
  private void disableMobGriefingOverride(CallbackInfo ci) {
    Mod.canProjectileModifyAtRuleOverride = null;
  }
}
