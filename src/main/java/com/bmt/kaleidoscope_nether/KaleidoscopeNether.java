package com.bmt.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.advancement.KNAdvancementTriggerRegistry;
import com.bmt.kaleidoscope_nether.config.MainConfig;
import com.bmt.kaleidoscope_nether.event.AnvilEventHandler;
import com.bmt.kaleidoscope_nether.event.DamageEventHandler;
import com.bmt.kaleidoscope_nether.event.ItemTabEventHandler;
import com.bmt.kaleidoscope_nether.event.KNEventSubscriber;
import com.bmt.kaleidoscope_nether.event.LavaWalkerEventHandler;
import com.bmt.kaleidoscope_nether.event.ModEvents;
import com.bmt.kaleidoscope_nether.event.StarBlessingEffectEvents;
import com.bmt.kaleidoscope_nether.init.*;
import com.bmt.kaleidoscope_nether.integration.KaleidoscopeDollIntegration;
import com.mojang.logging.LogUtils;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

public final class KaleidoscopeNether implements ModInitializer {
    public static final String MOD_ID = "kaleidoscope_nether";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        ConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.COMMON, MainConfig.SPEC);

        KNEffects.registerEffects();
        KNSounds.registerSoundEvents();
        KNBlocks.registerBlocks();
        KNEntities.registerEntities();
        KNPotions.registerPotions();
        KNAdvancementTriggerRegistry.register();
        KNItems.registerItems();
        KNFoodBiteRegistry.registerFoodBiteBlocks();
        KNCreativeTabs.registerTabs();
        KNFoods.init();
        KNComposterRegistry.register();
        KNBrewingRecipes.register();
        KNFluids.registerFluids();
        KNEventSubscriber.register();
        ModEvents.register();
        DamageEventHandler.register();
        LavaWalkerEventHandler.register();
        StarBlessingEffectEvents.register();
        AnvilEventHandler.register();
        ItemTabEventHandler.register();
        KaleidoscopeDollIntegration.register();

        LOGGER.info("Kaleidoscope Nether initialized on Fabric");
    }

    public static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }
}
