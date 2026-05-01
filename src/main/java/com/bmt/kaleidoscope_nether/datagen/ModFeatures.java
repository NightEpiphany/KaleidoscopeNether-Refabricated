package com.bmt.kaleidoscope_nether.datagen;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.api.KNTags;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.List;

public class ModFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> POISONOUS_FRUIT = createKey("poisonous_fruit");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TWISTING_CAVE_VINES = createKey("twisting_cave_vines");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WEEPING_CAVE_VINES = createKey("weeping_cave_vines");


    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, KaleidoscopeNether.id(name));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RandomizedIntStateProvider TwistingCaveVinesHead = new RandomizedIntStateProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(KNBlocks.TWISTING_CAVE_VINES.get().defaultBlockState(), 4).add(KNBlocks.TWISTING_CAVE_VINES.get().defaultBlockState().setValue(CaveVines.BERRIES, true), 1).build()), CaveVinesBlock.AGE, UniformInt.of(23, 25));
        WeightedStateProvider TwistingCaveVinesPlant = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(KNBlocks.TWISTING_CAVE_VINES_PLANT.get().defaultBlockState(), 1).add(KNBlocks.TWISTING_CAVE_VINES_PLANT.get().defaultBlockState().setValue(CaveVines.BERRIES, true), 1));


        RandomizedIntStateProvider WeepingCaveVinesHead = new RandomizedIntStateProvider(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(KNBlocks.WEEPING_CAVE_VINES.get().defaultBlockState(), 4).add(KNBlocks.WEEPING_CAVE_VINES.get().defaultBlockState().setValue(CaveVines.BERRIES, true), 1).build()), CaveVinesBlock.AGE, UniformInt.of(23, 25));
        WeightedStateProvider WeepingCaveVinesPlant = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(KNBlocks.WEEPING_CAVE_VINES_PLANT.get().defaultBlockState(), 1).add(KNBlocks.WEEPING_CAVE_VINES_PLANT.get().defaultBlockState().setValue(CaveVines.BERRIES, true), 1));


        FeatureUtils.register(
                context,
                POISONOUS_FRUIT,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        96,
                        7,
                        3,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        BlockStateProvider.simple(KNBlocks.POISONOUS_FRUIT.get().defaultBlockState().setValue(CropBlock.AGE, 7))
                                ),
                                ModFeatureUtils.simplePatchPredicate(KNTags.Blocks.SOUL_SOIL_SAND)
                        )
                ));

        FeatureUtils.register(
                context,
                TWISTING_CAVE_VINES,
                Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(List.of(
                        BlockColumnConfiguration.layer(
                                new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(UniformInt.of(0, 19), 1)
                                        .add(UniformInt.of(0, 2), 3)
                                        .add(UniformInt.of(0, 6), 10)
                                        .build()), TwistingCaveVinesPlant
                        )
                        , BlockColumnConfiguration.layer(ConstantInt.of(1), TwistingCaveVinesHead)
                ),
                        Direction.UP,
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        true
                )
        );

        FeatureUtils.register(
                context,
                WEEPING_CAVE_VINES,
                Feature.BLOCK_COLUMN,
                new BlockColumnConfiguration(List.of(
                        BlockColumnConfiguration.layer(
                                new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder()
                                        .add(UniformInt.of(0, 19), 1)
                                        .add(UniformInt.of(0, 2), 3)
                                        .add(UniformInt.of(0, 6), 10)
                                        .build()), WeepingCaveVinesPlant
                        )
                        , BlockColumnConfiguration.layer(ConstantInt.of(1), WeepingCaveVinesHead)
                ),
                        Direction.DOWN,
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        true
                )
        );

    }
}
