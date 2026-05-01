package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.LivingIncomingDamageEvent;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import net.minecraft.tags.DamageTypeTags;

public class DamageEventHandler {
    public static void register() {
        KNEvents.LIVING_INCOMING_DAMAGE.register(DamageEventHandler::onLivingIncomingDamage);
    }

    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (event.getEntity().hasEffect(KNEffects.TROPICAL_STRIDER) && event.getSource().is(DamageTypeTags.IS_FIRE)) {
            event.setCanceled(true);
            event.getEntity().clearFire();
        }
    }
}
