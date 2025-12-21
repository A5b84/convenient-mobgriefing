package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for cauldrons reacting to being hit by projectiles
 *
 * <p>Note: the affected methods don't check for {@link GameRules#MOB_GRIEFING} themselves (only
 * {@link Entity#mayInteract}) so this only affects projectiles
 */
@Mixin(LayeredCauldronBlock.class)
public class LayeredCauldronBlockMixin {

  @Inject(
      method = "method_71627",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/Entity;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z"))
  private void enableMobGriefingOverride(CallbackInfo ci) {
    Mod.projectileMayInteractOverride = Mod.LENIENT_GRIEFING;
  }

  @Inject(
      method = "method_71627",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/Entity;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z",
              shift = At.Shift.AFTER))
  private void disableMobGriefingOverride(CallbackInfo ci) {
    Mod.projectileMayInteractOverride = null;
  }
}
