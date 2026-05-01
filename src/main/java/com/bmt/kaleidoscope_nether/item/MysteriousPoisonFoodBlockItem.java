package com.bmt.kaleidoscope_nether.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class MysteriousPoisonFoodBlockItem extends BlockItem {
    public MysteriousPoisonFoodBlockItem(Block block, FoodProperties food, Rarity rarity) {
        super(block, new Item.Properties().food(food).rarity(rarity));
    }

    @Override
    public @NotNull String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        return super.finishUsingItem(stack, level, entity);
    }
}
