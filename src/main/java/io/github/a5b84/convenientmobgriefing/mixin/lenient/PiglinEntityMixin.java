package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

/**
 * Piglin bartering
 */
@Mixin(PiglinEntity.class)
public abstract class PiglinEntityMixin {

    @ModifyArg(method = "canGather", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return LENIENT_GRIEFING;
    }

}
