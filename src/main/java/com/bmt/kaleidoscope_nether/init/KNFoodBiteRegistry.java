package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteOneByTwoBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;
import com.github.ysbbbbbb.kaleidoscopecookery.item.BowlFoodBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;

public final class KNFoodBiteRegistry {
    public static final Map<ResourceLocation, FoodBiteRegistry.FoodData> FOOD_DATA_MAP = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<ResourceLocation> FOOD_DATA_ORDER = new CopyOnWriteArrayList<>();

    public static ResourceLocation SOUL_LAMB_CHOP;
    public static ResourceLocation BRAISED_PORK_RICE;
    public static ResourceLocation BRAISED_LION_HEAD;
    public static ResourceLocation CORN_CARROT_PORK_RIB_SOUP;

    public static void init() {
        SOUL_LAMB_CHOP = registerFoodData(KaleidoscopeNether.id("soul_lamb_chop"), FoodBiteRegistry.FoodData
                .create(3, KNFoods.SOUL_LAMB_CHOP_BLOCK, KNFoods.SOUL_LAMB_CHOP_ITEM)
        );

        BRAISED_PORK_RICE = registerFoodData(KaleidoscopeNether.id("braised_pork_rice"), FoodBiteRegistry.FoodData
                .create(4, KNFoods.BRAISED_PORK_RICE_BLOCK, KNFoods.BRAISED_PORK_RICE_ITEM)
                .bowlAABB()
        );

        BRAISED_LION_HEAD = registerFoodData(KaleidoscopeNether.id("braised_lion_head"), FoodBiteRegistry.FoodData
                .create(5, KNFoods.BRAISED_LION_HEAD_BLOCK, KNFoods.BRAISED_LION_HEAD_ITEM)
        );

        CORN_CARROT_PORK_RIB_SOUP = registerFoodData(KaleidoscopeNether.id("corn_carrot_pork_rib_soup"), FoodBiteRegistry.FoodData
                .create(3, KNFoods.CORN_CARROT_PORK_RIB_SOUP_BLOCK, KNFoods.CORN_CARROT_PORK_RIB_SOUP_ITEM)
                .setLootItem(Items.FLOWER_POT)
                .soupPotAABB()
                .potSoupAnimateTick()
        );
    }

    public static void registerFoodBiteBlocks() {
        KNFoodBiteRegistry.init();

        FOOD_DATA_MAP.forEach((resourceLocation, data) -> {
            FoodBiteBlock biteBlock = getFoodBiteBlock(data);
            Registry.register(BuiltInRegistries.BLOCK, resourceLocation, biteBlock);

            Block block = BuiltInRegistries.BLOCK.get(resourceLocation);
            // 选取第一个掉落物作为 usingConvertsTo
            ItemLike first = data.getLootItems().getFirst();
            Registry.register(BuiltInRegistries.ITEM, resourceLocation, new BowlFoodBlockItem(block, data.itemFood(), first));
        });
    }

    private static @NotNull FoodBiteBlock getFoodBiteBlock(FoodBiteRegistry.FoodData data) {
        FoodBiteBlock biteBlock;
        if (data.blockType() == FoodBiteRegistry.BlockType.ONE_BY_TWO) {
            biteBlock = new FoodBiteOneByTwoBlock(data.blockFood(), data.maxBites(), data.animateTick());
        } else {
            biteBlock = new FoodBiteBlock(data.blockFood(), data.maxBites(), data.animateTick());
        }

        VoxelShape aabb = data.getAABB();
        if (aabb != null) {
            biteBlock.setAABB(aabb);
        }
        return biteBlock;
    }

    private static ResourceLocation registerFoodData(ResourceLocation id, FoodBiteRegistry.FoodData data) {
        FOOD_DATA_MAP.put(id, data);
        FOOD_DATA_ORDER.addIfAbsent(id);
        return id;
    }

    public static void forEach(BiConsumer<ResourceLocation, FoodBiteRegistry.FoodData> consumer) {
        for (ResourceLocation id : FOOD_DATA_ORDER) {
            FoodBiteRegistry.FoodData data = FOOD_DATA_MAP.get(id);
            if (data != null) {
                consumer.accept(id, data);
            }
        }
    }
}
