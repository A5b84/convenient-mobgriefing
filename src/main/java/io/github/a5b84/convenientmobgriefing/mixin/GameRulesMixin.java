package io.github.a5b84.convenientmobgriefing.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.a5b84.convenientmobgriefing.GameRuleAccess;
import io.github.a5b84.convenientmobgriefing.OverrideMode;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/** Mixin that makes {@link GameRules#get(GameRule)} properly handle {@link OverrideMode} */
@Mixin(GameRules.class)
public abstract class GameRulesMixin {

  @ModifyReturnValue(method = "get", at = @At("RETURN"))
  private Object modifyGetResult(Object original, GameRule<?> gameRule) {
    if (original instanceof OverrideMode overrideMode) {
      return switch (overrideMode) {
        case TRUE -> true;
        case FALSE -> false;
        case DEFAULT -> {
          GameRule<Boolean> baseRule =
              ((GameRuleAccess) (Object) gameRule).convenientMobGriefing_getBaseRule();
          yield get(baseRule);
        }
      };
    } else {
      return original;
    }
  }

  @Shadow
  public abstract <T> T get(GameRule<T> gameRule);
}
