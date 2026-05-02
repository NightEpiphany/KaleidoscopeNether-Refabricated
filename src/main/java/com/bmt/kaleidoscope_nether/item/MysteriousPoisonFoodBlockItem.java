package com.bmt.kaleidoscope_nether.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class MysteriousPoisonFoodBlockItem extends BlockItem {
    public MysteriousPoisonFoodBlockItem(Block block, Item.Properties properties, FoodProperties food, Consumable consumable, Rarity rarity) {
        super(block, properties.food(food, consumable).rarity(rarity));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
        return super.finishUsingItem(stack, level, entity);
    }
}
