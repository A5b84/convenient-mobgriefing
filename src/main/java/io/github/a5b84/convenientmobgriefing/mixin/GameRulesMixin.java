package io.github.a5b84.convenientmobgriefing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Rule;
import net.minecraft.world.GameRules.RuleCategory;
import net.minecraft.world.GameRules.RuleKey;
import net.minecraft.world.GameRules.RuleType;

/**
 * Mixin qui enregistre les nouvelles gamerules
 */
@Mixin(GameRules.class)
public abstract class GameRulesMixin {

    /** @see GameRules#register */
    @Shadow
    private static <T extends Rule<T>> RuleKey<T> register(String name, RuleCategory category, RuleType<T> type) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onStaticInit(CallbackInfo ci) {
        Mod.LENIENT_MOB_GRIEFING = register("mobGriefingLenient", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
        Mod.WITHER_MOB_GRIEFING = register("mobGriefingWither", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
        Mod.DRAGON_MOB_GRIEFING = register("mobGriefingDragon", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
    }

}
