package com.bmt.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.client.ClientEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class KaleidoscopeNetherClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientEvents.register();
    }
}
