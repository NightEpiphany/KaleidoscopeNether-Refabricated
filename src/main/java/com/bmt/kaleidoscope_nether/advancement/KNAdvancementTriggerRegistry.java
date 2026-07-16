package com.bmt.kaleidoscope_nether.advancement;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public class KNAdvancementTriggerRegistry {
    public static KNAdvancementTrigger SIMPLE_ID;

    public static void register() {
        SIMPLE_ID = register(new KNAdvancementTrigger());
    }

    private static <T extends CriterionTrigger<?>> T register(final T criterion) {
        return (T)(Registry.register(BuiltInRegistries.TRIGGER_TYPES, "kaleidoscope_nether:simple_id", criterion));
    }
}
