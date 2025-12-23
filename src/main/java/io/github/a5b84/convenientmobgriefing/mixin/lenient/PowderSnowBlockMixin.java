package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Mixin for entities melting Powder Snow when on fire */
@Mixin(PowderSnowBlock.class)
public abstract class PowderSnowBlockMixin {

  /**
   * Lambda parameter passed to {@link InsideBlockEffectApplier#runBefore(InsideBlockEffectType,
   * Consumer)} in {@link PowderSnowBlock#entityInside(BlockState, Level, BlockPos, Entity,
   * InsideBlockEffectApplier)}.
   */
  @Unique
  @SuppressWarnings("JavadocReference")
  private static final String EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME = "method_67681";

  @ModifyArg(
      method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME,
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.MOBS_MELT_POWDER_SNOW;
  }

  @Inject(
      method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME,
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/Entity;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z"))
  private static void enableMobGriefingOverride(CallbackInfo ci) {
    ModRules.projectileMayInteractOverride = ModRules.MOB_PROJECTILES_AFFECT_BLOCKS;
  }

  @Inject(
      method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME,
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/Entity;mayInteract(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)Z",
              shift = At.Shift.AFTER))
  private static void disableMobGriefingOverride(CallbackInfo ci) {
    ModRules.projectileMayInteractOverride = null;
  }
}
