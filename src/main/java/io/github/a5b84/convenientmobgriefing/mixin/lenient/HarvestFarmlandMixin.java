package io.github.a5b84.convenientmobgriefing.mixin.lenient;

import io.github.a5b84.convenientmobgriefing.Mod;
import io.github.a5b84.convenientmobgriefing.mixin.Targets;
import net.minecraft.world.entity.ai.behavior.HarvestFarmland;
import net.minecraft.world.level.gamerules.GameRule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/** Mixin for farmer villagers harvesting crops */
@Mixin(HarvestFarmland.class)
public abstract class HarvestFarmlandMixin {

  @ModifyArg(
      method =
          "checkExtraStartConditions(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/npc/villager/Villager;)Z",
      at = @At(value = "INVOKE", target = Targets.GET_RULE_VALUE))
  private GameRule<Boolean> mobGriefingProxy(GameRule<Boolean> old) {
    return Mod.LENIENT_GRIEFING;
  }
}
