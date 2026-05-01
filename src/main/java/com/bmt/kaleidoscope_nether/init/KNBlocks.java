package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.block.*;
import com.github.ysbbbbbb.kaleidoscopecookery.block.kitchen.StoveBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class KNBlocks {
    public static final Supplier<BlockBehaviour.Properties> CROP_DEFAULT_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY);

    public static final Supplier<BlockBehaviour.Properties> CAVE_VINES_PROPERTIES =
            () -> BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY);

    public static final Supplier<PoisonousFruit> POISONOUS_FRUIT = register("poisonous_fruit",
            () -> new PoisonousFruit(CROP_DEFAULT_PROPERTIES.get()));

    public static final Supplier<SoulPepper> SOUL_PEPPER = register("soul_pepper",
            () -> new SoulPepper(CROP_DEFAULT_PROPERTIES.get()));

    public static final Supplier<TwistingCaveVinesPlant> TWISTING_CAVE_VINES_PLANT = register("twisting_cave_vines_plant",
            () -> new TwistingCaveVinesPlant(CAVE_VINES_PROPERTIES.get()));

    public static final Supplier<TwistingCaveVinesHead> TWISTING_CAVE_VINES = register("twisting_cave_vines",
            () -> new TwistingCaveVinesHead(CAVE_VINES_PROPERTIES.get()));

    public static final Supplier<WeepingCaveVinesPlant> WEEPING_CAVE_VINES_PLANT = register("weeping_cave_vines_plant",
            () -> new WeepingCaveVinesPlant(CAVE_VINES_PROPERTIES.get()));

    public static final Supplier<WeepingCaveVinesHead> WEEPING_CAVE_VINES = register("weeping_cave_vines",
            () -> new WeepingCaveVinesHead(CAVE_VINES_PROPERTIES.get()));

    // 下界炉灶
    public static final Supplier<StoveBlock> NETHER_STOVE = register("nether_stove", StoveBlock::new);

    private static <T extends Block> Supplier<T> register(String name, Supplier<T> factory) {
        T block = Registry.register(BuiltInRegistries.BLOCK, KaleidoscopeNether.id(name), factory.get());
        return () -> block;
    }

    public static void registerBlocks() {
        // 由静态字段完成注册，保留空方法作为统一入口。
    }
}
