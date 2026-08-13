package net.vector.entitytests.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class FixeEntity extends AbstractFish {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public FixeEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 6;
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 2d)
                .add(Attributes.FOLLOW_RANGE, 5D)
                .add(Attributes.MOVEMENT_SPEED, 1.0D);
    }


    public boolean isFood(ItemStack stack) {
        return stack.is(Items.STICK);
    }


    public ItemStack getBucketItemStack() {
        return new ItemStack(Items.COD_BUCKET);
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
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }


}
