package io.github.a5b84.convenientmobgriefing.mixin.wither;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

@Mixin(WitherEntity.class)
public abstract class WitherEntityMixin {

    /** Wither destroying blocks when hurt */
    @ModifyArg(method = "mobTick", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return WITHER_GRIEFING;
    }


    /** Initial explosion */
    @Inject(method = "mobTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/World$ExplosionSourceType;)V"))
    private void enableMobGriefingOverride(CallbackInfo ci) {
        createExplosionRuleOverride = WITHER_GRIEFING;
    }

    @Inject(method = "mobTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;createExplosion(Lnet/minecraft/entity/Entity;DDDFZLnet/minecraft/world/World$ExplosionSourceType;)V", shift = At.Shift.AFTER))
    private void disableMobGriefingOverride(CallbackInfo ci) {
        createExplosionRuleOverride = null;
    }

}
