package com.bmt.kaleidoscope_nether.worldgen;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class KNWorldGeneration {
    private static final ResourceKey<PlacedFeature> POISONOUS_FRUIT = placedFeature("poisonous_fruit");
    private static final ResourceKey<PlacedFeature> TWISTING_CAVE_VINES = placedFeature("twisting_cave_vines");
    private static final ResourceKey<PlacedFeature> WEEPING_CAVE_VINES = placedFeature("weeping_cave_vines");

    private KNWorldGeneration() {
    }

    public static void register() {
        addVegetation(Biomes.SOUL_SAND_VALLEY, POISONOUS_FRUIT);
        addVegetation(Biomes.WARPED_FOREST, TWISTING_CAVE_VINES);
        addVegetation(Biomes.CRIMSON_FOREST, WEEPING_CAVE_VINES);
    }

    private static void addVegetation(
            ResourceKey<Biome> biome,
            ResourceKey<PlacedFeature> feature
    ) {
        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(biome),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                feature
        );
    }

    private static ResourceKey<PlacedFeature> placedFeature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, KaleidoscopeNether.id(name));
    }
}
