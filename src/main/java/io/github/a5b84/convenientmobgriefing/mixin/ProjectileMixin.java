package io.github.a5b84.convenientmobgriefing.mixin;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Projectile.class)
public abstract class ProjectileMixin {

  @ModifyArg(method = "mayInteract", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return Mod.canProjectileModifyAtRuleOverride != null
        ? Mod.canProjectileModifyAtRuleOverride
        : old;
  }
}
