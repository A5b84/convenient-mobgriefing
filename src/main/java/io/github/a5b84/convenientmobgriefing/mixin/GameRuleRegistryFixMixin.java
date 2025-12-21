package io.github.a5b84.convenientmobgriefing.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.mojang.serialization.Dynamic;
import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.util.datafix.fixes.GameRuleRegistryFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/** Mixin that fixes names of game rules when opening 1.21.10- worlds */
@Mixin(GameRuleRegistryFix.class)
public class GameRuleRegistryFixMixin {

  @ModifyReturnValue(method = "method_76071", at = @At("RETURN"))
  private static Dynamic<?> fixModeGameRules(Dynamic<?> dynamic) {
    return dynamic
        .renameAndFixField(
            "lenientGriefing", Mod.LENIENT_GRIEFING.id(), GameRuleRegistryFixMixin::convertBoolean)
        .renameAndFixField(
            "witherGriefing", Mod.WITHER_GRIEFING.id(), GameRuleRegistryFixMixin::convertBoolean)
        .renameAndFixField(
            "dragonGriefing", Mod.DRAGON_GRIEFING.id(), GameRuleRegistryFixMixin::convertBoolean);
  }

  @Shadow
  private static Dynamic<?> convertBoolean(Dynamic<?> dynamic) {
    throw new AssertionError();
  }
}
