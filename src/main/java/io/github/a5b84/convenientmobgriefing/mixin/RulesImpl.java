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
import static io.github.a5b84.convenientmobgriefing.Mod.LENIENT_GRIEFING;
import static io.github.a5b84.convenientmobgriefing.Mod.WITHER_GRIEFING;

/**
 * Classe qui contient toutes les mixins qui injectent des trucs
 */
public final class RulesImpl {

    private RulesImpl() {}

    private static final String TARGET = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z";



    /** Implémentation de `lenientGriefing` */
    public static final class Lenient {

        private Lenient() {}

        /** Projectiles qui allument des feux de camp */
        @Mixin(CampfireBlock.class)
        public static abstract class CampfireBlockMixin {
            // `require = 0` pour pre 1.15 où ça utilise pas encore mobGriefing
            @ModifyArg(method = "onProjectileHit", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Entités qui cassent les champs en tombant */
        @Mixin(FarmlandBlock.class)
        public static abstract class FarmlandBlockMixin {
            @ModifyArg(method = "onLandedUpon", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Mobs qui essaient de casser les oeufs de tortues */
        @Mixin(TurtleEggBlock.class)
        public static abstract class TurtleEggBlockMixin {
            @ModifyArg(method = "breaksEgg", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Villageois paysans qui font leur travail */
        @Mixin(FarmerVillagerTask.class)
        public static abstract class FarmerVillagerTaskMixin {
            @ModifyArg(method = "shouldRun", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Moutons qui mange de l'herbe */
        @Mixin(EatGrassGoal.class)
        public static abstract class EatGrassGoalMixin {
            @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Objectifs d'IA */
        @Mixin(value = { StepAndDestroyBlockGoal.class, WololoGoal.class },
               targets = "net/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal")
        public static abstract class GoalsMixin {
            @ModifyArg(method = "canStart()Z", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Mobs qui lootent et golem de neige qui mettent de la neige par terre */
        @Mixin({ MobEntity.class, SnowGolemEntity.class })
        public static abstract class EntityMovementMixin {
            @ModifyArg(method = "tickMovement", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Échanges avec les Piglins */
        @Mixin(PiglinEntity.class)
        public static abstract class PiglinEntityMixin {
            @ModifyArg(method = "canGather", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Renards qui mangent des baies */
        @Mixin(EatSweetBerriesGoal.class)
        public static abstract class EatSweetBerriesGoalMixin {
            @ModifyArg(method = "eatSweetBerry", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

        /** Entités qui droppent des wither roses */
        @Mixin(LivingEntity.class)
        public static abstract class LivingEntityMixin {
            @ModifyArg(method = "onKilledBy", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }

            /** Pre 19w45a */
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "onDeath", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private Key<BooleanRule> mobGriefingProxy_pre19w45a(Key<BooleanRule> old) {
                return LENIENT_GRIEFING;
            }
        }

    }



    /** Implémentation de `witherGriefing` */
    public static final class Wither {

        private Wither() {}

        /** Explosion du Wither */
        @Mixin(WitherEntity.class)
        public static abstract class WitherEntityMixin {
            @ModifyArg(method = "mobTick", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }
        }

        /** Explosion des crânes */
        @Mixin(WitherSkullEntity.class)
        public static abstract class WitherSkullEntityMixin {
            @ModifyArg(method = "onCollision", at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }

            /** Pre 20w13a */
            @SuppressWarnings("UnresolvedMixinReference")
            @ModifyArg(method = "method_7488", remap = false,
                at = @At(value = "INVOKE", target = TARGET), index = 0, require = 0)
            private Key<BooleanRule> mobGriefingProxy_post1_15_2(Key<BooleanRule> old) {
                return WITHER_GRIEFING;
            }
        }

    }



    /** Implémentation de `dragonGriefing` */
    public static final class Dragon {

        private Dragon() {}

        /** Explosion du Wither */
        @Mixin(EnderDragonEntity.class)
        public static abstract class EnderDragonEntityMixin {
            @ModifyArg(method = "destroyBlocks", at = @At(value = "INVOKE", target = TARGET), index = 0)
            private Key<BooleanRule> mobGriefingProxy(Key<BooleanRule> old) {
                return DRAGON_GRIEFING;
            }
        }

    }

}
