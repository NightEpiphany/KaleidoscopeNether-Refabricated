package com.bmt.kaleidoscope_nether.datapack;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

import static com.bmt.kaleidoscope_nether.KaleidoscopeNether.MOD_ID;

public class DatapackLoader {
    public static void load() {
        FabricLoader
                .getInstance()
                .getModContainer(MOD_ID)
                .ifPresent(container ->
                        ResourceManagerHelper.registerBuiltinResourcePack(
                                Identifier.withDefaultNamespace(""),
                                container,
                                ResourcePackActivationType.NORMAL
                        ));
    }
}
