package com.bmt.kaleidoscope_nether.integration;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.player.Player;

public class CuriosIntegration {
    private static final String TRINKETS_MOD_ID = "trinkets";

    public static boolean hasItemInCurios(Player player, Class<?> itemClass) {
        if (!isLoaded()) {
            return false;
        }
        return CuriosIntegrationImpl.hasItemInCurios(player, itemClass);
    }

    public static boolean isLoaded() {
        return FabricLoader.getInstance().isModLoaded(TRINKETS_MOD_ID);
    }
}
