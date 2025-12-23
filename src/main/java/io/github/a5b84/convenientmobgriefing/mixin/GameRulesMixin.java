package io.github.a5b84.convenientmobgriefing.mixin;

import io.github.a5b84.convenientmobgriefing.DynamicGameRule;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Mixin that makes {@link GameRules#get(GameRule)} properly handle {@link OverrideMode} */
@Mixin(GameRules.class)
public abstract class GameRulesMixin {

  @Inject(method = "get", at = @At("HEAD"), cancellable = true)
  private <T> void beforeGet(GameRule<T> gameRule, CallbackInfoReturnable<T> cir) {
    if (gameRule instanceof DynamicGameRule<T> dynamicGameRule) {
      cir.setReturnValue(dynamicGameRule.evaluate((GameRules) (Object) this));
    }
  }
}
