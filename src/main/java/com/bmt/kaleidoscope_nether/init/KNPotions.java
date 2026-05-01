package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class KNPotions {
    public static Holder<Potion> MYSTERIOUS_POISON;

    public static void registerPotions() {
        MYSTERIOUS_POISON = Registry.registerForHolder(
                BuiltInRegistries.POTION,
                KaleidoscopeNether.id("mysterious_poison"),
                new Potion(new MobEffectInstance(KNEffects.MYSTERIOUS_POISON, 1500, 0))
        );
    }
}
