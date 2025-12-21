package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mobs picking up dropped items and Snow Golems placing snow */
@Mixin({MobEntity.class, SnowGolemEntity.class})
public abstract class EntityMovementMixin {

  @ModifyArg(method = "tickMovement", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanRule> old) {
    return LENIENT_GRIEFING;
  }
}
