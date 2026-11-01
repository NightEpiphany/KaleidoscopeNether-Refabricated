package com.bmt.kaleidoscope_nether.api.event;

import com.github.ysbbbbbb.kaleidoscopecookery.util.event.IKCEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public record MobEffectAddedEvent(LivingEntity entity, MobEffectInstance effectInstance,
                                  @Nullable Entity source) implements IKCEvent {

    @FunctionalInterface
    public interface MobEffectAddedHandler {
        void onAdded(MobEffectAddedEvent event);
    }
}
