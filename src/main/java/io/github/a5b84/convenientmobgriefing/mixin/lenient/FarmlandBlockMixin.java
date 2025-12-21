package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;

import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Farmland trampling */
@Mixin(FarmlandBlock.class)
public abstract class FarmlandBlockMixin {

  @ModifyArg(method = "onLandedUpon", at = @At(value = "INVOKE", target = Targets.GET_RULE_BOOLEAN))
  private GameRules.Key<GameRules.BooleanRule> mobGriefingProxy(
      GameRules.Key<GameRules.BooleanRule> old) {
    return LENIENT_GRIEFING;
  }
}
