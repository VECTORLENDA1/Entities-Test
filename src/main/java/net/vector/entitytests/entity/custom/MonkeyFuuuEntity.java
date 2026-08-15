package net.vector.entitytests.entity.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.vector.entitytests.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class MonkeyFuuuEntity extends Animal implements NeutralMob {
    public static final ResourceLocation SPEED_MODIFIER_ATTACKING_ID = ResourceLocation.withDefaultNamespace("attacking");
    private static final AttributeModifier SPEED_MODIFIER_ATTACKING = new AttributeModifier(
            SPEED_MODIFIER_ATTACKING_ID, 0.05, AttributeModifier.Operation.ADD_VALUE
    );
    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;

    public static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(10, 20);
    public static final UniformInt ALERT_INTERVAL = TimeUtil.rangeOfSeconds(4, 6);
    public int remainingPersistentAngerTime;
    public UUID persistentAngerTarget;
    public int ticksUntilNextAlert;

    public MonkeyFuuuEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 3;
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1, Ingredient.of(Items.APPLE), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.2));
        this.goalSelector.addGoal(4, new MonkeyFuuuAttackGoal(this));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 3.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    public void addBehaviourGoals() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(MonkeyFuuuEntity.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 5)
                .add(Attributes.JUMP_STRENGTH, 0.8)
                .add(Attributes.ATTACK_DAMAGE, 1.5);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        float jumpBuffer = getJumpHeightBuffer();
        return super.causeFallDamage(pFallDistance - jumpBuffer, pMultiplier, pSource);
    }

    private float getJumpHeightBuffer() {
        double jumpStrength = this.getAttributeValue(Attributes.JUMP_STRENGTH);
        // This will make that the entity will NOT take damage from FallDamage when jump from a specific height
        return (float) ((jumpStrength * jumpStrength) / (2 * 0.08)) * 0.6F; // 0.08 is the gravity per tick of minecraft
        // Your "JumpBuffer = (0.8 square 2 / 0.16 (2 * 0.08)) * 1.2 = (0.64 / 0.16) * 1.2 = 4 * 1.2 = 4.8 + 3 (before fall damage in minecraft) =
        // 7.8 before the entity start taking fall damage"
    }



    public boolean isFood(ItemStack stack) {
        return stack.is(Items.APPLE);
    }

    @Override
    public void checkDespawn() {
        if (this.level().getNearestPlayer(this, 64.0) == null) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    private void setupAnimationStates() {
        boolean isMoving = this.walkAnimation.speed() > 0.1F;

        if (!isMoving) {
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = 40;
                this.idleAnimationState.start(this.tickCount);
            } else {
                --this.idleAnimationTimeout;
            }
        } else {
            this.idleAnimationState.stop();
            this.idleAnimationTimeout = 0;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }


    public void maybeAlertOthers() {
        if (this.getTarget() == null) {
            return;
        }
        if (this.ticksUntilNextAlert > 0) {
            this.ticksUntilNextAlert--;
        } else {
            if (this.getSensing().hasLineOfSight(this.getTarget())) {
                this.alertOthers();
            }

            this.ticksUntilNextAlert = ALERT_INTERVAL.sample(this.random);
        }
    }

    public void alertOthers() {
        double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(d0, 10.0, d0);
        this.level()
                .getEntitiesOfClass(MonkeyFuuuEntity.class, aabb, EntitySelector.NO_SPECTATORS)
                .stream()
                .filter(p_34463_ -> p_34463_ != this)
                .filter(p_325818_ -> p_325818_.getTarget() == null)
                .filter(p_325817_ -> !p_325817_.isAlliedTo(this.getTarget()))
                .forEach(p_325816_ -> p_325816_.setTarget(this.getTarget()));
    }

    @Override
    protected void customServerAiStep() {
        AttributeInstance attributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (this.isAngry()) {
            if (!this.isBaby() && !attributeinstance.hasModifier(SPEED_MODIFIER_ATTACKING_ID)) {
                attributeinstance.addTransientModifier(SPEED_MODIFIER_ATTACKING);
            }

        } else if (attributeinstance.hasModifier(SPEED_MODIFIER_ATTACKING_ID)) {
            attributeinstance.removeModifier(SPEED_MODIFIER_ATTACKING_ID);
        }

        this.updatePersistentAnger((ServerLevel)this.level(), true);
        if (this.getTarget() != null) {
            this.maybeAlertOthers();
        }

        if (this.isAngry()) {
            this.lastHurtByPlayerTime = this.tickCount;
        }

        super.customServerAiStep();
    }


    @Nullable
    public MonkeyFuuuEntity getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.MONKEYFUUU.get().create(level);
    }

    static class MonkeyFuuuAttackGoal extends MeleeAttackGoal {
        public MonkeyFuuuAttackGoal(MonkeyFuuuEntity monkeyFuuuEntity) {
            super(monkeyFuuuEntity, 1.0, true);
        }
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) {
        this.remainingPersistentAngerTime = time;
    }

    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID target) {
        this.persistentAngerTarget = target;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }
}
