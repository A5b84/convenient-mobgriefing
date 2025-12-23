package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.ModRules;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.PitcherCropBlock;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for Ravagers breaking crops and Pitcher Pods */
@Mixin({CropBlock.class, PitcherCropBlock.class})
public abstract class CropBlocksMixins {

  @ModifyArg(method = "entityInside", at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return ModRules.RAVAGER_GRIEFING;
  }
}
