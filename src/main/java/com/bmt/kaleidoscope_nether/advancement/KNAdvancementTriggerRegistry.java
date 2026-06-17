package com.bmt.kaleidoscope_nether.advancement;

import net.minecraft.advancements.triggers.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class KNAdvancementTriggerRegistry {
    public static KNAdvancementTrigger SIMPLE_ID;

    public static void register() {
        SIMPLE_ID = register("kaleidoscope_nether:simple_id", new KNAdvancementTrigger());
    }

    private static <T extends CriterionTrigger<?>> T register(final String name, final T criterion) {
        return (T)(Registry.register(BuiltInRegistries.TRIGGER_TYPES, name, criterion));
    }
}
