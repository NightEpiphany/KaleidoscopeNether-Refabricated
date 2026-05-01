package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.LivingDamageModifyEvent;
import com.bmt.kaleidoscope_nether.api.event.MobEffectAddedEvent;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class StarBlessingEffectEvents {
    public static void register() {
        KNEvents.MODIFY_LIVING_DAMAGE.register(StarBlessingEffectEvents::onLivingDamage);
        KNEvents.MOB_EFFECT_ADDED.register(StarBlessingEffectEvents::onEffectAdded);
    }

    public static void onLivingDamage(LivingDamageModifyEvent event) {
        if (event.getEntity().hasEffect(KNEffects.STAR_BLESSING)) {
            event.setNewDamage(event.getNewDamage() * 0.2F);
        }
    }

    public static void onEffectAdded(MobEffectAddedEvent event) {
        if (!event.getEffectInstance().getEffect().is(KNEffects.STAR_BLESSING)) {
            return;
        }

        List<Holder<MobEffect>> effectsToRemove = new ArrayList<>();
        for (MobEffectInstance effect : event.getEntity().getActiveEffectsMap().values()) {
            if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                effectsToRemove.add(effect.getEffect());
            }
        }

        for (Holder<MobEffect> effect : effectsToRemove) {
            event.getEntity().removeEffect(effect);
        }
    }
}
