package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for mobs picking up dropped items and Snow Golems placing snow */
@Mixin({Mob.class, SnowGolem.class})
public abstract class EntityMovementMixin {

  @ModifyArg(method = "aiStep", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return Mod.LENIENT_GRIEFING;
  }
}
