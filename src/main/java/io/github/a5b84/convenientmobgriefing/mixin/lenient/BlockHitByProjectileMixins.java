package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import net.minecraft.block.Block;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.block.PointedDripstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.canProjectileModifyAtRuleOverride;

/**
 * Blocks reacting to being hit by projectiles through {@link Block#onProjectileHit}
 */
@SuppressWarnings("deprecation") // Block#onProjectileHit
@Mixin({CampfireBlock.class, ChorusFlowerBlock.class, PointedDripstoneBlock.class})
public class BlockHitByProjectileMixins {

    @Inject(method = "onProjectileHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/ProjectileEntity;canModifyAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z"))
    private void enableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = LENIENT_GRIEFING;
    }

    @Inject(method = "onProjectileHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/ProjectileEntity;canModifyAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z", shift = At.Shift.AFTER))
    private void disableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = null;
    }

}
