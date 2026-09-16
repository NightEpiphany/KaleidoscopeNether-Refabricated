package com.bmt.kaleidoscope_nether.worldgen;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class WorldGenerationGameTest {
    @GameTest
    public void featuresLoadAndAttachToNetherBiomes(GameTestHelper helper) {
        assertFeature(helper, "poisonous_fruit", Biomes.SOUL_SAND_VALLEY);
        assertFeature(helper, "twisting_cave_vines", Biomes.WARPED_FOREST);
        assertFeature(helper, "weeping_cave_vines", Biomes.CRIMSON_FOREST);
        helper.succeed();
    }

    @GameTest
    public void poisonousFruitGeneratesMatureOnSoulSoil(GameTestHelper helper) {
        BlockPos origin = new BlockPos(1, 2, 1);
        helper.setBlock(origin.below(), Blocks.SOUL_SOIL);
        helper.setBlock(origin, Blocks.AIR);
        place(helper, "poisonous_fruit", origin);
        helper.assertBlockPresent(KNBlocks.POISONOUS_FRUIT.get(), origin);
        helper.assertBlockProperty(origin, BlockStateProperties.AGE_7, 7);
        helper.succeed();
    }

    @GameTest
    public void twistingVinesGenerateUpward(GameTestHelper helper) {
        assertVine(helper, "twisting_cave_vines", KNBlocks.TWISTING_CAVE_VINES.get(),
                KNBlocks.TWISTING_CAVE_VINES_PLANT.get(), true);
        helper.succeed();
    }

    @GameTest
    public void weepingVinesGenerateDownward(GameTestHelper helper) {
        assertVine(helper, "weeping_cave_vines", KNBlocks.WEEPING_CAVE_VINES.get(),
                KNBlocks.WEEPING_CAVE_VINES_PLANT.get(), false);
        helper.succeed();
    }

    private static void assertFeature(GameTestHelper helper, String name, ResourceKey<Biome> biomeKey) {
        var access = helper.getLevel().registryAccess();
        var feature = access.lookupOrThrow(Registries.FEATURE)
                .getOrThrow(ResourceKey.create(Registries.FEATURE, KaleidoscopeNether.id(name)));
        var placed = access.lookupOrThrow(Registries.PLACED_FEATURE)
                .getOrThrow(ResourceKey.create(Registries.PLACED_FEATURE, KaleidoscopeNether.id(name)));
        helper.assertTrue(placed.value().feature().value() == feature.value(), name + " must resolve its feature");
        var biome = access.lookupOrThrow(Registries.BIOME).getOrThrow(biomeKey).value();
        var vegetation = biome.getGenerationSettings().features()
                .get(GenerationStep.Decoration.VEGETAL_DECORATION.ordinal());
        helper.assertTrue(vegetation.contains(placed), name + " must be present in " + biomeKey.identifier());
    }

    private static void assertVine(GameTestHelper helper, String name, Block head, Block plant, boolean upward) {
        // Limit the column to two air blocks: this also exercises tip preservation when truncated.
        BlockPos origin = new BlockPos(1, upward ? 1 : 2, 1);
        BlockPos next = upward ? origin.above() : origin.below();
        helper.setBlock(1, 0, 1, Blocks.NETHERRACK);
        helper.setBlock(1, 3, 1, Blocks.NETHERRACK);
        helper.setBlock(origin, Blocks.AIR);
        helper.setBlock(next, Blocks.AIR);
        place(helper, name, origin);
        BlockPos tip = helper.getBlockState(origin).is(head) ? origin : next;
        if (!tip.equals(origin)) {
            helper.assertBlockPresent(plant, origin);
        }
        helper.assertBlockPresent(head, tip);
        int age = helper.getBlockState(tip).getValue(BlockStateProperties.AGE_25);
        helper.assertTrue(age >= 23 && age <= 25, name + " tip age must remain between 23 and 25");
    }

    private static void place(GameTestHelper helper, String name, BlockPos relativePos) {
        var level = helper.getLevel();
        var feature = level.registryAccess().lookupOrThrow(Registries.FEATURE)
                .getOrThrow(ResourceKey.create(Registries.FEATURE, KaleidoscopeNether.id(name))).value();
        helper.assertTrue(feature.place(level, level.getChunkSource().getGenerator(),
                RandomSource.create(42L), helper.absolutePos(relativePos)), name + " must place successfully");
    }
}
