package com.bmt.kaleidoscope_nether.api;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface KNTags {
    interface Blocks {
        TagKey<Block> SOUL_SOIL_SAND = register();

        private static TagKey<Block> register() {
            return TagKey.create(Registries.BLOCK, KaleidoscopeNether.id("soul_soil_sand"));
        }
    }

    interface Items {
        TagKey<Item> MOD_ITEMS = register("mod_items");
        TagKey<Item> SOUL_PEPPER_TRANSFORMABLE = register("soul_pepper_transformable");
        TagKey<Item> BLAZE_FOODS = register("blaze_foods");
        TagKey<Item> MAGMA_CREAM_FOODS = register("magma_cream_foods");
        TagKey<Item> STAR_BLESSING_FOODS = register("star_blessing_foods");
        TagKey<Item> WARPED_FOOD = register("warped_food");

        private static TagKey<Item> register(String name) {
            return TagKey.create(Registries.ITEM, KaleidoscopeNether.id(name));
        }
    }
}
