package com.bmt.kaleidoscope_nether.init;

import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.minecraft.world.item.alchemy.Potions;

public final class KNBrewingRecipes {
    public static void register() {
        FabricPotionBrewingBuilder.BUILD.register(builder ->
                builder.addMix(Potions.AWKWARD, KNItems.POISONOUS_FRUIT.get(), KNPotions.MYSTERIOUS_POISON)
        );
    }
}
