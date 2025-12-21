package io.github.a5b84.convenientmobgriefing.mixin;

import static io.github.a5b84.convenientmobgriefing.Mod.canProjectileModifyAtRuleOverride;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileEntityMixin {

  @ModifyArg(method = "canModifyAt", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanRule> old) {
    return canProjectileModifyAtRuleOverride != null ? canProjectileModifyAtRuleOverride : old;
  }
}
