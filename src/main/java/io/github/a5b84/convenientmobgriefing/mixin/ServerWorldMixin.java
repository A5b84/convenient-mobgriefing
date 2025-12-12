package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.createExplosionRuleOverride;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin {

    @ModifyArg(method = "createExplosion", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return createExplosionRuleOverride != null
                ? createExplosionRuleOverride
                : old;
    }

}
