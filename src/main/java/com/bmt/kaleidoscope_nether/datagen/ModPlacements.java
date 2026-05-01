package com.bmt.kaleidoscope_nether.datagen;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacements {
    public static final ResourceKey<PlacedFeature> POISONOUS_FRUIT = createKey("poisonous_fruit");

    public static final ResourceKey<PlacedFeature> TWISTING_CAVE_VINES = createKey("twisting_cave_vines");

    public static final ResourceKey<PlacedFeature> WEEPING_CAVE_VINES = createKey("weeping_cave_vines");

    public static ResourceKey<PlacedFeature> createKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, KaleidoscopeNether.id(key));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        PlacementUtils.register(
                context,
                POISONOUS_FRUIT,
                holdergetter.getOrThrow(ModFeatures.POISONOUS_FRUIT),
                PlacementUtils.FULL_RANGE,
                BiomeFilter.biome(),
                RarityFilter.onAverageOnceEvery(5)
        );

        PlacementUtils.register(
                context,
                TWISTING_CAVE_VINES,
                holdergetter.getOrThrow(ModFeatures.TWISTING_CAVE_VINES),
                CountPlacement.of(10),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.hasSturdyFace(Direction.UP), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                BiomeFilter.biome()
        );

        PlacementUtils.register(
                context,
                WEEPING_CAVE_VINES,
                holdergetter.getOrThrow(ModFeatures.WEEPING_CAVE_VINES),
                CountPlacement.of(50),
                InSquarePlacement.spread(),
                PlacementUtils.FULL_RANGE,
                EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.allOf(BlockPredicate.hasSturdyFace(Direction.DOWN), BlockPredicate.matchesBlocks(Blocks.NETHER_WART_BLOCK)), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(-1)),
                BiomeFilter.biome()
        );
    }
}
