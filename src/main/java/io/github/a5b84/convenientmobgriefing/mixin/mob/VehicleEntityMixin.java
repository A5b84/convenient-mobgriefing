package io.github.a5b84.convenientmobgriefing.mixin.mob;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VehicleEntity.class)
public abstract class VehicleEntityMixin {

  @ModifyArg(
      method = "ignoreExplosion",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private static GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.MOBS_AFFECT_INANIMATE_ENTITIES;
  }
}
