package io.github.a5b84.convenientmobgriefing.mixin;

import net.minecraft.block.CampfireBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.TurtleEggBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.FarmerVillagerTask;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.StepAndDestroyBlockGoal;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.mob.EndermanEntity.PlaceBlockGoal;
import net.minecraft.entity.mob.EndermanEntity.PickUpBlockGoal;
import net.minecraft.entity.mob.EvokerEntity.WololoGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.passive.FoxEntity.EatSweetBerriesGoal;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.Key;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static io.github.a5b84.convenientmobgriefing.Mod.DRAGON_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.ENDERMAN_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;

/** Class holding all the mixins */
public final class RulesImpl {

    private RulesImpl() {}

    private static final String TARGET = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z";



    /** lenientGriefing implementation */
    public static final class Lenient {

        private Lenient() {}

        /** Projectiles litting campfires */
        @Mixin(CampfireBlock.class)
        public static abstract class CampfireBlockMixin {
            // `require = 0` because it was added somewhere in 1.15 and later
            // removed (during the 1.17 snapshots?)
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "onProjectileHit", at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Farmland trampling */
        @Mixin(FarmlandBlock.class)
        public static abstract class FarmlandBlockMixin {
            @ModifyArg(method = "onLandedUpon", at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }

            // <= 1.16.5 (?)
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "method_9554(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;F)V", remap = false, at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy_pre1_17(Key<BooleanRule> old) {
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
            @ModifyArg(method = "shouldRun", at = @At(value = "INVOKE", target = TARGET))
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

        /** Foxes eating Sweet Berries */
        @Mixin(EatSweetBerriesGoal.class)
        public static abstract class EatSweetBerriesGoalMixin {
            @ModifyArg(method = "eatSweetBerry", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Entities placing wither roses when killed by a Wither */
        @Mixin(LivingEntity.class)
        public static abstract class LivingEntityMixin {
            @ModifyArg(method = "onKilledBy", at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }

            /** Pre 19w45a */
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "onDeath", at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy_pre19w45a(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

    }



    /** endermanGriefing implementation */
    public static final class Enderman {

        private Enderman() {}

        @Mixin(PlaceBlockGoal.class)
        public static abstract class PlaceBlockGoalMixin {
            @ModifyArg(method = "canStart", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return ENDERMAN_GRIEFING;
            }
        }

        @Mixin(PickUpBlockGoal.class)
        public static abstract class PickUpBlockGoalMixin {
            @ModifyArg(method = "canStart", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return ENDERMAN_GRIEFING;
            }
        }
    }



    /** witherGriefing implementation */
    public static final class Wither {

        private Wither() {}

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

            /** Pre 20w13a */
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "method_7488", remap = false,
                at = @At(value = "INVOKE", target = TARGET), require = 0)
            private Key<BooleanRule> mobGriefingProxy_pre20w13a(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }
        }

    }



    /** dragonGriefing implementation */
    public static final class Dragon {

        private Dragon() {}

        @Mixin(EnderDragonEntity.class)
        public static abstract class EnderDragonEntityMixin {
            @ModifyArg(method = "destroyBlocks", at = @At(value = "INVOKE", target = TARGET))
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return DRAGON_GRIEFING;
            }
        }

    }

}
