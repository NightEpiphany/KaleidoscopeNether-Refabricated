package com.bmt.kaleidoscope_nether.init;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.world.item.alchemy.Potions;

public class KNBrewingRecipes {
    public static void register() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder ->
                builder.addMix(Potions.AWKWARD, KNItems.POISONOUS_FRUIT.get(), KNPotions.MYSTERIOUS_POISON)
        );
    }
}
