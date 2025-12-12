package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.block.BlockState;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.CollisionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.canProjectileModifyAtRuleOverride;

/**
 * Entities melting Powder Snow when on fire
 */
@Mixin(PowderSnowBlock.class)
public abstract class PowderSnowBlockMixin {

    /**
     * Lambda parameter passed to {@link EntityCollisionHandler#addPreCallback(CollisionEvent, Consumer)} in {@link PowderSnowBlock#onEntityCollision(BlockState, World, BlockPos, Entity, EntityCollisionHandler)}.
     */
    @Unique
    @SuppressWarnings("JavadocReference")
    private static final String EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME = "method_67681";

    @ModifyArg(method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME, at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private static GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return LENIENT_GRIEFING;
    }

    @Inject(method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;canModifyAt(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;)Z"))
    private static void enableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = LENIENT_GRIEFING;
    }

    @Inject(method = EXTINGUISH_ON_ENTITY_COLLISION_LAMBDA_NAME, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;canModifyAt(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;)Z", shift = At.Shift.AFTER))
    private static void disableMobGriefingOverride(CallbackInfo ci) {
        canProjectileModifyAtRuleOverride = null;
    }
}
