package com.bmt.kaleidoscope_nether.api.event;

import com.github.ysbbbbbb.kaleidoscopecookery.api.event.ActionEvent;
import com.github.ysbbbbbb.kaleidoscopecookery.api.event.IActionCancelable;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class LivingIncomingDamageEvent extends ActionEvent implements IActionCancelable {
    private final LivingEntity entity;
    private final DamageSource source;
    private final float amount;

    public LivingIncomingDamageEvent(LivingEntity entity, DamageSource source, float amount) {
        this.entity = entity;
        this.source = source;
        this.amount = amount;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public DamageSource getSource() {
        return source;
    }

    public float getAmount() {
        return amount;
    }

    @FunctionalInterface
    public interface LivingIncomingDamageHandler {
        void onIncomingDamage(LivingIncomingDamageEvent event);
    }
}
