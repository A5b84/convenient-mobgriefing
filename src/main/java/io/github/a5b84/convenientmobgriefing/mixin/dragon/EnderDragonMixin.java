package io.github.a5b84.convenientmobgriefing.mixin.dragon;

import static io.github.a5b84.convenientmobgriefing.Mod.DRAGON_GRIEFING;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for the Ender Dragon destroying blocks */
@Mixin(EnderDragon.class)
public abstract class EnderDragonMixin {

  @ModifyArg(method = "checkWalls", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanValue> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanValue> old) {
    return DRAGON_GRIEFING;
  }
}
