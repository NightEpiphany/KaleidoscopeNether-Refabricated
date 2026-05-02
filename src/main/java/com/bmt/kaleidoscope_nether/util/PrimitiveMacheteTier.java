package com.bmt.kaleidoscope_nether.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public final class PrimitiveMacheteTier {
    public static final ToolMaterial INSTANCE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            7.0F,
            7.0F,
            15,
            ItemTags.NON_FLAMMABLE_WOOD
    );

    private PrimitiveMacheteTier() {
    }
}
