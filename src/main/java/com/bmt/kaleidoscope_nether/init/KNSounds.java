package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class KNSounds {
    public static final Supplier<SoundEvent> LAVA_ROASTED_CHICKEN_EAT = registerSoundEvent("lava_roasted_chicken_eat");
    public static final Supplier<SoundEvent> STAR_DUST_REPAIR = registerSoundEvent("star_dust_repair");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation location = KaleidoscopeNether.id(name);
        SoundEvent soundEvent = Registry.register(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
        return () -> soundEvent;
    }

    public static void registerSoundEvents() {
        // 由静态字段完成注册，保留空方法作为统一入口。
    }
}
