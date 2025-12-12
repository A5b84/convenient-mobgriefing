package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

/**
 * Farmer villagers harvesting crops
 */
@Mixin(FarmerVillagerTask.class)
public abstract class FarmerVillagerTaskMixin {

    @ModifyArg(method = "shouldRun(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/VillagerEntity;)Z", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
    private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
        return LENIENT_GRIEFING;
    }

}
