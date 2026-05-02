package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.LivingIncomingDamageEvent;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import com.bmt.kaleidoscope_nether.init.KNPotions;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;

public class ModEvents {
    public static void register() {
        KNEvents.LIVING_INCOMING_DAMAGE.register(ModEvents::onLivingIncomingDamage);
    }

    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        if (!(event.getSource().getDirectEntity() instanceof AbstractArrow arrow)) {
            return;
        }

        PotionContents potionContents = getArrowPotionContents(arrow);
        if (potionContents.potion().isEmpty() || !potionContents.potion().get().is(KNPotions.MYSTERIOUS_POISON)) {
            return;
        }

        MobEffectInstance instance = event.getEntity().getEffect(KNEffects.MYSTERIOUS_POISON);
        if (instance != null) {
            event.getEntity().addEffect(new MobEffectInstance(KNEffects.MYSTERIOUS_POISON, 1500 / 8, instance.getAmplifier() + 1));
        } else {
            event.getEntity().addEffect(new MobEffectInstance(KNEffects.MYSTERIOUS_POISON, 1500, 0));
        }
    }

    private static PotionContents getArrowPotionContents(AbstractArrow arrow) {
        ItemStack pickupStack = arrow.getPickupItemStackOrigin();
        return pickupStack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
    }
}
