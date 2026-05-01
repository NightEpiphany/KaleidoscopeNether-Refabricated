package com.bmt.kaleidoscope_nether.init;

import net.minecraft.world.level.block.ComposterBlock;

@SuppressWarnings("deprecation")
public class KNComposterRegistry {

    public static void register() {
        ComposterBlock.COMPOSTABLES.put(KNItems.CRIMSON_FRUIT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(KNItems.WARPED_FRUIT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(KNItems.POISONOUS_FRUIT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(KNItems.SOUL_PEPPER.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(KNItems.WARPED_CAKE.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(KNItems.NETHER_CATERPILLAR.get(), 1.0F);
    }
}