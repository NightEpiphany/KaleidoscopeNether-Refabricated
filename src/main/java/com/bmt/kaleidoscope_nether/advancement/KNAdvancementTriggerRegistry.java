package com.bmt.kaleidoscope_nether.advancement;

import net.minecraft.advancements.CriteriaTriggers;

public class KNAdvancementTriggerRegistry {
    public static KNAdvancementTrigger SIMPLE_ID;

    public static void register() {
        SIMPLE_ID = CriteriaTriggers.register("kaleidoscope_nether:simple_id", new KNAdvancementTrigger());
    }
}
