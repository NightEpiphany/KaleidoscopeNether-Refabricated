package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.Enchantment;

public final class KNEnchantments {
    public static final ResourceKey<Enchantment> LAVA_WALKER = ResourceKey.create(Registries.ENCHANTMENT, 
            Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "lava_walker"));
}
