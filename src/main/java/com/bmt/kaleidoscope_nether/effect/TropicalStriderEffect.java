package com.bmt.kaleidoscope_nether.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;

public class TropicalStriderEffect extends MobEffect {
    public TropicalStriderEffect(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        boolean isInNether = livingEntity.level().dimension().equals(Level.NETHER);

        if (isInNether) {
            BlockPos posBelow = livingEntity.getOnPos();
            if (livingEntity.isOnFire() && livingEntity.level().getBlockState(posBelow).getBlock() == Blocks.MAGMA_BLOCK) {
                livingEntity.clearFire();
            }
        }
        return true;
    }
}