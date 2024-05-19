package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

@Mixin(World.class)
public abstract class WorldMixin {

    @ModifyArg(method = "createExplosion(Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/damage/DamageSource;Lnet/minecraft/world/explosion/ExplosionBehavior;DDDFZLnet/minecraft/world/World$ExplosionSourceType;ZLnet/minecraft/particle/ParticleEffect;Lnet/minecraft/particle/ParticleEffect;Lnet/minecraft/registry/entry/RegistryEntry;)Lnet/minecraft/world/explosion/Explosion;", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
    private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(GameRules.Key<GameRules.BooleanRule> old) {
        return createExplosionRuleOverride != null
                ? createExplosionRuleOverride
                : old;
    }

}
