package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

/**
 * Entities placing wither roses when killed by a Wither
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @ModifyArg(method = "onKilledBy", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
    private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(GameRules.Key<GameRules.BooleanRule> old) {
        return LENIENT_GRIEFING;
    }

}
