package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.block.*;
import com.github.ysbbbbbb.kaleidoscopecookery.block.kitchen.StoveBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;
import java.util.function.Supplier;

public final class KNBlocks {

    public static final Supplier<PoisonousFruit> POISONOUS_FRUIT = register("poisonous_fruit",
            PoisonousFruit::new, cropProperties());

    public static final Supplier<SoulPepper> SOUL_PEPPER = register("soul_pepper",
            SoulPepper::new, cropProperties());

    public static final Supplier<TwistingCaveVinesPlant> TWISTING_CAVE_VINES_PLANT = register("twisting_cave_vines_plant",
            TwistingCaveVinesPlant::new, caveVinesProperties());

    public static final Supplier<TwistingCaveVinesHead> TWISTING_CAVE_VINES = register("twisting_cave_vines",
            TwistingCaveVinesHead::new, caveVinesProperties());

    public static final Supplier<WeepingCaveVinesPlant> WEEPING_CAVE_VINES_PLANT = register("weeping_cave_vines_plant",
            WeepingCaveVinesPlant::new, caveVinesProperties());

    public static final Supplier<WeepingCaveVinesHead> WEEPING_CAVE_VINES = register("weeping_cave_vines",
            WeepingCaveVinesHead::new, caveVinesProperties());

    // 下界炉灶
    public static final Supplier<StoveBlock> NETHER_STOVE = register("nether_stove",
            StoveBlock::new, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)
                    .randomTicks()
                    .strength(1.5F, 6.0F));

    private static <T extends Block> Supplier<T> register(String name, Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> resourceKey = ResourceKey.create(net.minecraft.core.registries.Registries.BLOCK, KaleidoscopeNether.id(name));
        T block = factory.apply(properties.setId(resourceKey));
        Registry.register(BuiltInRegistries.BLOCK, resourceKey, block);
        return () -> block;
    }

    private static BlockBehaviour.Properties cropProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollision()
                .randomTicks()
                .instabreak()
                .sound(SoundType.CROP)
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties caveVinesProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_CYAN)
                .randomTicks()
                .noCollision()
                .instabreak()
                .sound(SoundType.WEEPING_VINES)
                .pushReaction(PushReaction.DESTROY);
    }

    public static void registerBlocks() {
        // 由静态字段完成注册，保留空方法作为统一入口。
    }
}
