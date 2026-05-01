package com.bmt.kaleidoscope_nether.item;

import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SpecialFruitBlockItem extends BlockItem {
    public SpecialFruitBlockItem(Block block, FoodProperties food, Rarity rarity) {
        super(block, new Item.Properties().food(food).rarity(rarity));
    }

    public @NotNull String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        return super.finishUsingItem(stack, level, entity);
    }
}