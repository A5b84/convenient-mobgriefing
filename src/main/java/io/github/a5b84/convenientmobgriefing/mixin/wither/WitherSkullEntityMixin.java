package io.github.a5b84.convenientmobgriefing.mixin.wither;

import net.minecraft.entity.projectile.WitherSkullEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

/**
 * Skull explosions
 */
@Mixin(WitherSkullEntity.class)
public abstract class WitherSkullEntityMixin {

    @Inject(method = "onCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;"))
    private void enableMobGriefingOverride(CallbackInfo ci) {
        createExplosionRuleOverride = WITHER_GRIEFING;
    }

    @Inject(method = "onCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/World$ExplosionSourceType;)Lnet/minecraft/world/explosion/Explosion;", shift = At.Shift.AFTER))
    private void disableMobGriefingOverride(CallbackInfo ci) {
        createExplosionRuleOverride = null;
    }

}
