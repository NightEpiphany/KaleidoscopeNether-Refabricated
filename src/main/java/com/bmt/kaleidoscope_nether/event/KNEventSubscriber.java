package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.LivingDamageModifyEvent;
import com.bmt.kaleidoscope_nether.effect.CrimsonEffect;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import net.minecraft.world.entity.LivingEntity;

public class KNEventSubscriber {
    public static void register() {
        KNEvents.MODIFY_LIVING_DAMAGE.register(KNEventSubscriber::onLivingDamage);
    }

    public static void onLivingDamage(LivingDamageModifyEvent event) {
        if (event.getSource().getDirectEntity() instanceof LivingEntity attacker) {
            float modifiedDamage = CrimsonEffect.calculateDamageBonus(attacker, event.getNewDamage());
            if (modifiedDamage != event.getNewDamage()) {
                event.setNewDamage(modifiedDamage);
            }
        }
    }
}
