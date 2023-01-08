package io.github.a5b84.convenientmobgriefing.mixin.lenient;


import net.minecraft.block.Block;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.canProjectileModifyAtRuleOverride;

/**
 * Blocks reacting to being hit by projectiles through {@link Block#onEntityCollision}
 * <p>
 * Note: the affected methods don't check for {@link GameRules#DO_MOB_GRIEFING}
 * themselves (only {@link Entity#canModifyAt}) so this only affects projectiles
 */
@SuppressWarnings("deprecation") // Block#onEntityCollision
@Mixin({LeveledCauldronBlock.class, PowderSnowBlock.class})
public class BlockCollidingWithEntityMixins {

    @Inject(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;canModifyAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z"))
    private void enableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = LENIENT_GRIEFING;
    }

    @Inject(method = "onEntityCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;canModifyAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z", shift = At.Shift.AFTER))
    private void disableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = null;
    }

}
