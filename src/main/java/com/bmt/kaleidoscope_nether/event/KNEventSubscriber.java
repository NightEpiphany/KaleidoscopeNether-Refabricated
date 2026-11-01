package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.LivingDamageModifyEvent;
import com.bmt.kaleidoscope_nether.effect.CrimsonEffect;
import com.github.ysbbbbbb.kaleidoscopecookery.util.event.IKCEvent;
import net.minecraft.world.entity.LivingEntity;

public class KNEventSubscriber {
    public static void register() {
        IKCEvent.CALLBACK.register(event -> {
            if (event instanceof LivingDamageModifyEvent livingDamageModifyEvent)
                onLivingDamage(livingDamageModifyEvent);
        });
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
