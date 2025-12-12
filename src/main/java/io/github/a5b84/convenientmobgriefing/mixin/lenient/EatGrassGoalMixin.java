package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

/**
 * Sheep eating grass
 */
@Mixin(EatGrassGoal.class)
public abstract class EatGrassGoalMixin {

    @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return LENIENT_GRIEFING;
    }

}
