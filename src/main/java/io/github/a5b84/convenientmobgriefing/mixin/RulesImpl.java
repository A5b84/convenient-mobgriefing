package io.github.a5b84.convenientmobgriefing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.block.CampfireBlock;
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
import net.minecraft.entity.passive.FoxEntity.EatSweetBerriesGoal;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.RuleKey;

/**
 * Classe qui contient toutes les mixins qui injectent des trucs
 */
public final class RulesImpl {

    private RulesImpl() {}

    private static final String TARGET = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$RuleKey;)Z";



    /** Implémentation de `mobGriefingLenient` */
    public static final class Lenient {

        private Lenient() {}

        /** Projectiles qui allument des feux de camp */
        @Mixin(CampfireBlock.class)
        public static abstract class CampfireBlockMixin {
            /** @see CampfireBlock#onProjectileHit */
            // `require = 0` pour pre 1.15 où ça utilise pas encore mobGriefing
            @ModifyArg(method = "onProjectileHit", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Entités qui cassent les champs en tombant */
        @Mixin(FarmlandBlock.class)
        public static abstract class FarmlandBlockMixin {
            /** @see FarmlandBlock#onLandedUpon */
            @ModifyArg(method = "onLandedUpon", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Mobs qui essaient de casser les oeufs de tortues */
        @Mixin(TurtleEggBlock.class)
        public static abstract class TurtleEggBlockMixin {
            /** @see TurtleEggBlock#breaksEgg */
            @ModifyArg(method = "breaksEgg", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Villageois paysans qui font leur travail */
        @Mixin(FarmerVillagerTask.class)
        public static abstract class FarmerVillagerTaskMixin {
            /** @see FarmerVillagerTask#shouldRun */
            @ModifyArg(method = "shouldRun", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Moutons qui mange de l'herbe */
        @Mixin(EatGrassGoal.class)
        public static abstract class EatGrassGoalMixin {
            /** @see EatGrassGoal#tick */
            @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Objectifs d'IA */
        @Mixin(value = { StepAndDestroyBlockGoal.class, WololoGoal.class },
               targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
        public static abstract class GoalsMixin {
            /** @see StepAndDestroyBlockGoal#canStart
             *  @see WololoGoal#canStart
             *  @see RabbitEntity.EatCarrotCropGoal#canStart */
            @ModifyArg(method = "canStart()Z", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Mobs qui lootent et golem de neige qui mettent de la neige par terre */
        @Mixin({ MobEntity.class, SnowGolemEntity.class })
        public static abstract class EntityMovementMixin {
            /** @see MobEntity#tickMovement
             *  @see SnowGolemEntity#tickMovement */
            @ModifyArg(method = "tickMovement", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Échanges avec les Piglins */
        @Mixin(PiglinEntity.class)
        public static abstract class PiglinEntityMixin {
            /** @see PiglinEntity#canGather */
            @ModifyArg(method = "canGather", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Renards qui mangent des baies */
        @Mixin(EatSweetBerriesGoal.class)
        public static abstract class EatSweetBerriesGoalMixin {
            /** @see EatSweetBerriesGoal#eatSweetBerry */
            @ModifyArg(method = "eatSweetBerry", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

        /** Entités qui droppent des wither roses */
        @Mixin(LivingEntity.class)
        public static abstract class LivingEntityMixin {
            /** @see LivingEntity#onKilledBy */
            @ModifyArg(method = "onKilledBy", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }

            // Pre 19w45a, compiler en post 19w45a pour que les deux méthodes existent
            /** @see LivingEntity#onDeath */
            @ModifyArg(method = "onDeath", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private RuleKey<BooleanRule> mobGriefingProxy_pre19w45a(RuleKey<BooleanRule> old) {
                return Mod.LENIENT_MOB_GRIEFING;
            }
        }

    }



    /** Implémentation de `mobGriefingWither` */
    public static final class Wither {

        private Wither() {}

        /** Explosion du Wither */
        @Mixin(WitherEntity.class)
        public static abstract class WitherEntityMixin {
            /** @see WitherEntity#mobTick */
            @ModifyArg(method = "mobTick", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.WITHER_MOB_GRIEFING;
            }
        }

        /** Explosion des crânes */
        @Mixin(WitherSkullEntity.class)
        public static abstract class WitherSkullEntityMixin {
            /** @see WitherSkullEntity#onCollision */
            @ModifyArg(method = "onCollision", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.WITHER_MOB_GRIEFING;
            }

            /** @see WitherSkullEntity#onCollision */
            // Snapshots 1.16
            @ModifyArg(method = "method_7488", remap = false,
                at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private RuleKey<BooleanRule> mobGriefingProxy_post1_15_2(RuleKey<BooleanRule> old) {
                return Mod.WITHER_MOB_GRIEFING;
            }
        }

    }



    /** Implémentation de `mobGriefingDragon` */
    public static final class Dragon {

        private Dragon() {}

        /** Explosion du Wither */
        @Mixin(EnderDragonEntity.class)
        public static abstract class EnderDragonEntityMixin {
            /** @see EnderDragonEntity#destroyBlocks */
            @ModifyArg(method = "destroyBlocks", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private RuleKey<BooleanRule> mobGriefingProxy(RuleKey<BooleanRule> old) {
                return Mod.DRAGON_MOB_GRIEFING;
            }
        }

    }

}
