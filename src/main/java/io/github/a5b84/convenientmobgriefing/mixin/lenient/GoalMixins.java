package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.mob.EvokerEntity;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

/**
 * Miscellaneous AI goals
 */
@Mixin(value = {StepAndDestroyBlockGoal.class, EvokerEntity.WololoGoal.class},
        targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
public abstract class GoalMixins {

    @ModifyArg(method = "canStart()Z", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return LENIENT_GRIEFING;
    }

}
