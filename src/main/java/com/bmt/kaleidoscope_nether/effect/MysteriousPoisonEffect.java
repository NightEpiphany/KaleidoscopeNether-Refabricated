package com.bmt.kaleidoscope_nether.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import org.jetbrains.annotations.NotNull;

public class MysteriousPoisonEffect extends MobEffect {

    public MysteriousPoisonEffect(int color) {
        super(MobEffectCategory.HARMFUL, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.level().isClientSide()) {
            float maxHealth = livingEntity.getMaxHealth();
            float damage = maxHealth * 0.01f + amplifier * 0.5f;

            damage = Math.max(damage, 1.0f);

            livingEntity.hurt(livingEntity.damageSources().magic(), damage);
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int interval = 20 - (amplifier * 3);
        interval = Math.max(interval, 5);

        return duration % interval == 0;
    }

    @Override
    public void addAttributeModifiers(@NotNull AttributeMap attributeMap, int amplifier) {
        super.addAttributeModifiers(attributeMap, amplifier);
    }

    @Override
    public void removeAttributeModifiers(@NotNull AttributeMap attributeMap) {
        super.removeAttributeModifiers(attributeMap);
    }
}