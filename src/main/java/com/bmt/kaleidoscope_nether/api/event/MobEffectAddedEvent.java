package com.bmt.kaleidoscope_nether.api.event;

import com.github.ysbbbbbb.kaleidoscopecookery.api.event.ActionEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class MobEffectAddedEvent extends ActionEvent {
    private final LivingEntity entity;
    private final MobEffectInstance effectInstance;
    private final @Nullable Entity source;

    public MobEffectAddedEvent(LivingEntity entity, MobEffectInstance effectInstance, @Nullable Entity source) {
        this.entity = entity;
        this.effectInstance = effectInstance;
        this.source = source;
    }

    public LivingEntity getEntity() {
        return entity;
    }

    public MobEffectInstance getEffectInstance() {
        return effectInstance;
    }

    public @Nullable Entity getSource() {
        return source;
    }

    @FunctionalInterface
    public interface MobEffectAddedHandler {
        void onAdded(MobEffectAddedEvent event);
    }
}
