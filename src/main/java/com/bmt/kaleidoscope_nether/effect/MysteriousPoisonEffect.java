package com.bmt.kaleidoscope_nether.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MysteriousPoisonEffect extends MobEffect {

    public MysteriousPoisonEffect(int color) {
        super(MobEffectCategory.HARMFUL, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel serverLevel, @NotNull LivingEntity livingEntity, int amplifier) {
        float maxHealth = livingEntity.getMaxHealth();
        float damage = maxHealth * 0.01f + amplifier * 0.5f;
        damage = Math.max(damage, 1.0f);
        livingEntity.hurt(serverLevel.damageSources().magic(), damage);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int interval = 20 - (amplifier * 3);
        interval = Math.max(interval, 5);

        return duration % interval == 0;
    }
}
