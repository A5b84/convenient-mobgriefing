package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.EvokerEntity.WololoGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.FoxEntity.EatBerriesGoal;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.Key;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.DRAGON_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;

public final class RulesImpl {

    private static final String TARGET = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z";


    /** lenientGriefing implementation */
    public static final class Lenient {

		/** Allay picking up items (1.19+) */
		@Mixin(AllayEntity.class)
		public static abstract class AllayPickupMixin {
			@ModifyArg(method = "canGather", at = @At(value = "INVOKE", target = TARGET))
			private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
				return LENIENT_GRIEFING;
			}
		}

        /** Farmland trampling */
        @Mixin(FarmlandBlock.class)
        public static abstract class FarmlandBlockMixin {
            @ModifyArg(method = "onLandedUpon", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Mobs trying to destroy turtle eggs */
        @Mixin(TurtleEggBlock.class)
        public static abstract class TurtleEggBlockMixin {
            @ModifyArg(method = "breaksEgg", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Farmer villagers harvesting crops */
        @Mixin(FarmerVillagerTask.class)
        public static abstract class FarmerVillagerTaskMixin {
            @ModifyArg(method = "shouldRun(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/VillagerEntity;)Z", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Sheep eating grass */
        @Mixin(EatGrassGoal.class)
        public static abstract class EatGrassGoalMixin {
            @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Miscellaneous AI goals */
        @Mixin(value = { StepAndDestroyBlockGoal.class, WololoGoal.class },
               targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
        public static abstract class GoalsMixin {
            @ModifyArg(method = "canStart()Z", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Mobs picking up drop items and Snow Golem placing snow */
        @Mixin({ MobEntity.class, SnowGolemEntity.class })
        public static abstract class EntityMovementMixin {
            @ModifyArg(method = "tickMovement", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Piglin bartering */
        @Mixin(PiglinEntity.class)
        public static abstract class PiglinEntityMixin {
            @ModifyArg(method = "canGather", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Foxes eating berries */
        @Mixin(EatBerriesGoal.class)
        public static abstract class EatBerriesGoalMixin {
            @ModifyArg(method = "eatBerries", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Entities placing wither roses when killed by a Wither */
        @Mixin(LivingEntity.class)
        public static abstract class LivingEntityMixin {
            @ModifyArg(method = "onKilledBy", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

    }


    /** witherGriefing implementation */
    public static final class Wither {

        /** Wither explosion */
        @Mixin(WitherEntity.class)
        public static abstract class WitherEntityMixin {
            @ModifyArg(method = "mobTick", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }
        }

        /** Skull explosions */
        @Mixin(WitherSkullEntity.class)
        public static abstract class WitherSkullEntityMixin {
            @ModifyArg(method = "onCollision", at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }
        }

    }


    /** dragonGriefing implementation */
    public static final class Dragon {

        @Mixin(EnderDragonEntity.class)
        public static abstract class EnderDragonEntityMixin {
            @ModifyArg(method = "destroyBlocks", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return DRAGON_GRIEFING;
            }
        }

    }

}
