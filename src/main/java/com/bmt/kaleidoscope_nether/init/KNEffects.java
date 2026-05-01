package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.effect.CrimsonEffect;
import com.bmt.kaleidoscope_nether.effect.GhostEffect;
import com.bmt.kaleidoscope_nether.effect.MysteriousPoisonEffect;
import com.bmt.kaleidoscope_nether.effect.StarBlessingEffect;
import com.bmt.kaleidoscope_nether.effect.TropicalStriderEffect;
import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

public class KNEffects {
    public static Holder<MobEffect> CRIMSON;
    public static Holder<MobEffect> WARPED;
    public static Holder<MobEffect> STAR_BLESSING;
    public static Holder<MobEffect> GHOST;
    public static Holder<MobEffect> TROPICAL_STRIDER;
    public static Holder<MobEffect> MYSTERIOUS_POISON;

    public static void registerEffects() {
        CRIMSON = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("crimson"), new CrimsonEffect(0xFF0000));
        WARPED = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("warped"), new WarpedEffect(0x00FFA2));
        STAR_BLESSING = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("star_blessing"), new StarBlessingEffect(0x87CEEB));
        GHOST = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("ghost"), new GhostEffect(0x4A90E2));
        TROPICAL_STRIDER = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("tropical_strider"), new TropicalStriderEffect(0xCC3300));
        MYSTERIOUS_POISON = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, KaleidoscopeNether.id("mysterious_poison"), new MysteriousPoisonEffect(0x8A2BE2));
    }
}
