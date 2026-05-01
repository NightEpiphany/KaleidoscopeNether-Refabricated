package com.bmt.kaleidoscope_nether.api.event;

import com.github.ysbbbbbb.kaleidoscopecookery.api.event.ActionEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class LivingDamageModifyEvent extends ActionEvent {
    private final LivingEntity entity;
    private final DamageSource source;
    private final float originalDamage;
    private float newDamage;

    public LivingDamageModifyEvent(LivingEntity entity, DamageSource source, float originalDamage) {
        this.entity = entity;
        this.source = source;
        this.originalDamage = originalDamage;
        this.newDamage = originalDamage;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public DamageSource getSource() {
        return source;
    }

    public float getOriginalDamage() {
        return originalDamage;
    }

    public float getNewDamage() {
        return newDamage;
    }

    public void setNewDamage(float newDamage) {
        this.newDamage = newDamage;
    }

    @FunctionalInterface
    public interface LivingDamageModifyHandler {
        void onModify(LivingDamageModifyEvent event);
    }
}
