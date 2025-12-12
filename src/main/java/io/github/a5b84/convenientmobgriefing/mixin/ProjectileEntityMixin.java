package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.rule.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.canProjectileModifyAtRuleOverride;

@Mixin(ProjectileEntity.class)
public abstract class ProjectileEntityMixin {

    @ModifyArg(method = "canModifyAt", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return canProjectileModifyAtRuleOverride != null
                ? canProjectileModifyAtRuleOverride
                : old;
    }

}
