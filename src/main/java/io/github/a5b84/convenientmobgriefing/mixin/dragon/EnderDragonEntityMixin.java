package io.github.a5b84.convenientmobgriefing.mixin.dragon;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.DRAGON_GRIEFING;

/**
 * Ender Dragon destroying blocks
 */
@Mixin(EnderDragonEntity.class)
public abstract class EnderDragonEntityMixin {

    @ModifyArg(method = "destroyBlocks", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
    private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(GameRules.Key<GameRules.BooleanRule> old) {
        return DRAGON_GRIEFING;
    }

}
