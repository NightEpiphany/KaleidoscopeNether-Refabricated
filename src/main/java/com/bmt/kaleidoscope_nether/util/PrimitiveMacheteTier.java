package com.bmt.kaleidoscope_nether.util;

import com.bmt.kaleidoscope_nether.init.KNItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class PrimitiveMacheteTier implements Tier {
    @Override
    public int getUses() {
        return 2031;
    }

    @Override
    public float getSpeed() {
        return 7.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 7.0F;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(KNItems.HOGLIN_TUSK.get());
    }
}