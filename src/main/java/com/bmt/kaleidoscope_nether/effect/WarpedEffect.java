package com.bmt.kaleidoscope_nether.effect;

import com.bmt.kaleidoscope_nether.config.MainConfig;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.Identifier;

import java.util.List;

public class WarpedEffect extends MobEffect {
    public WarpedEffect(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return false;
    }

    public static boolean shouldAffectMob(LivingEntity target, LivingEntity player) {
        if (!player.hasEffect(KNEffects.WARPED)) {
            return false;
        }
        return isAffectedMob(target);
    }

    public static boolean isAffectedMob(LivingEntity entity) {
        List<? extends String> affectedMobIds = MainConfig.WARPED_BUFF_AFFECTED_MOBS.get();

        if (affectedMobIds.isEmpty()) {
            return false;
        }

        Identifier entityId = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType());

        String entityIdString = entityId.toString();
        return affectedMobIds.contains(entityIdString);
    }
}