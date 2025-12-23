package io.github.a5b84.convenientmobgriefing.mixin;

import io.github.a5b84.convenientmobgriefing.ModRules;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Projectile.class)
public abstract class ProjectileMixin {

  @ModifyArg(method = "mayInteract", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<?> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.projectileMayInteractOverride != null
        ? ModRules.projectileMayInteractOverride
        : old;
  }
}
