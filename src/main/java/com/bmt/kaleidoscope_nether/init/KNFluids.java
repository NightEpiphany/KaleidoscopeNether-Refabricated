package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.fluid.NetherFluids;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public final class KNFluids {

    public static Fluid WARPED_JUICE;
    public static Fluid FLOWING_WARPED_JUICE;
    public static Fluid CRIMSON_JUICE;
    public static Fluid FLOWING_CRIMSON_JUICE;

    static {
        WARPED_JUICE = register("warped_juice", new NetherFluids.Source(() -> WARPED_JUICE, () -> FLOWING_WARPED_JUICE));
        FLOWING_WARPED_JUICE = register("flowing_warped_juice", new NetherFluids.Flowing(() -> WARPED_JUICE, () -> FLOWING_WARPED_JUICE));
        CRIMSON_JUICE = register("crimson_juice", new NetherFluids.Source(() -> CRIMSON_JUICE, () -> FLOWING_CRIMSON_JUICE));
        FLOWING_CRIMSON_JUICE = register("flowing_crimson_juice", new NetherFluids.Flowing(() -> CRIMSON_JUICE, () -> FLOWING_CRIMSON_JUICE));
    }

    private static Fluid register(String id, Fluid fluid) {
        return Registry.register(BuiltInRegistries.FLUID, ResourceLocation.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, id), fluid);
    }

    public static void registerFluids() {
    }
}
