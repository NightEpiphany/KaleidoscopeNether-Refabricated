package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.api.event.*;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public final class KNEvents {
    public static final Event<AnvilUpdateEvent.AnvilUpdateHandler> UPDATE_ANVIL = EventFactory.createArrayBacked(AnvilUpdateEvent.AnvilUpdateHandler.class, listeners -> event -> {
        for (AnvilUpdateEvent.AnvilUpdateHandler listener : listeners) {
            listener.onUpdate(event);
        }
    });

    public static final Event<LivingIncomingDamageEvent.LivingIncomingDamageHandler> LIVING_INCOMING_DAMAGE = EventFactory.createArrayBacked(LivingIncomingDamageEvent.LivingIncomingDamageHandler.class, listeners -> event -> {
        for (LivingIncomingDamageEvent.LivingIncomingDamageHandler listener : listeners) {
            listener.onIncomingDamage(event);
        }
    });

    public static final Event<LivingDamageModifyEvent.LivingDamageModifyHandler> MODIFY_LIVING_DAMAGE = EventFactory.createArrayBacked(LivingDamageModifyEvent.LivingDamageModifyHandler.class, listeners -> event -> {
        for (LivingDamageModifyEvent.LivingDamageModifyHandler listener : listeners) {
            listener.onModify(event);
        }
    });

    public static final Event<MobEffectAddedEvent.MobEffectAddedHandler> MOB_EFFECT_ADDED = EventFactory.createArrayBacked(MobEffectAddedEvent.MobEffectAddedHandler.class, listeners -> event -> {
        for (MobEffectAddedEvent.MobEffectAddedHandler listener : listeners) {
            listener.onAdded(event);
        }
    });

    public static final Event<EntityTickEvent.Pre.PreHandler> ENTITY_PRE = EventFactory.createArrayBacked(EntityTickEvent.Pre.PreHandler.class, listeners -> event -> {
        for (EntityTickEvent.Pre.PreHandler listener : listeners) {
            listener.pre(event);
        }
    });

    public static final Event<EntityTickEvent.Post.PostHandler> ENTITY_POST = EventFactory.createArrayBacked(EntityTickEvent.Post.PostHandler.class, listeners -> event -> {
        for (EntityTickEvent.Post.PostHandler listener : listeners) {
            listener.post(event);
        }
    });

    private KNEvents() {
    }
}
