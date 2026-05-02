package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.item.KNBowlFoodBlockItem;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteOneByTwoBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;

public final class KNFoodBiteRegistry {
    public static final Map<Identifier, FoodBiteRegistry.FoodData> FOOD_DATA_MAP = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<Identifier> FOOD_DATA_ORDER = new CopyOnWriteArrayList<>();

    public static Identifier SOUL_LAMB_CHOP;
    public static Identifier BRAISED_PORK_RICE;
    public static Identifier BRAISED_LION_HEAD;
    public static Identifier CORN_CARROT_PORK_RIB_SOUP;

    public static void init() {
        SOUL_LAMB_CHOP = registerFoodData(KaleidoscopeNether.id("soul_lamb_chop"), FoodBiteRegistry.FoodData
                .create(3, KNFoods.SOUL_LAMB_CHOP_BLOCK, KNFoods.SOUL_LAMB_CHOP_ITEM,
                        KNConsumables.SOUL_LAMB_CHOP_BLOCK, KNConsumables.SOUL_LAMB_CHOP_ITEM)
        );

        BRAISED_PORK_RICE = registerFoodData(KaleidoscopeNether.id("braised_pork_rice"), FoodBiteRegistry.FoodData
                .create(4, KNFoods.BRAISED_PORK_RICE_BLOCK, KNFoods.BRAISED_PORK_RICE_ITEM,
                        KNConsumables.BRAISED_PORK_RICE_BLOCK, KNConsumables.BRAISED_PORK_RICE_ITEM)
                .bowlAABB()
        );

        BRAISED_LION_HEAD = registerFoodData(KaleidoscopeNether.id("braised_lion_head"), FoodBiteRegistry.FoodData
                .create(5, KNFoods.BRAISED_LION_HEAD_BLOCK, KNFoods.BRAISED_LION_HEAD_ITEM,
                        KNConsumables.BRAISED_LION_HEAD_BLOCK, KNConsumables.BRAISED_LION_HEAD_ITEM)
        );

        CORN_CARROT_PORK_RIB_SOUP = registerFoodData(KaleidoscopeNether.id("corn_carrot_pork_rib_soup"), FoodBiteRegistry.FoodData
                .create(3, KNFoods.CORN_CARROT_PORK_RIB_SOUP_BLOCK, KNFoods.CORN_CARROT_PORK_RIB_SOUP_ITEM,
                        KNConsumables.CORN_CARROT_PORK_RIB_SOUP_BLOCK, KNConsumables.CORN_CARROT_PORK_RIB_SOUP_ITEM)
                .setLootItem(Items.FLOWER_POT)
                .soupPotAABB()
                .potSoupAnimateTick()
        );
    }

    public static void registerFoodBiteBlocks() {
        KNFoodBiteRegistry.init();

        FOOD_DATA_MAP.forEach((id, data) -> {
            FoodBiteBlock biteBlock = getFoodBiteBlock(data, id.getPath());
            Registry.register(BuiltInRegistries.BLOCK, id, biteBlock);

            Block block = BuiltInRegistries.BLOCK.getValue(id);
            // 选取第一个掉落物作为 usingConvertsTo
            ItemLike first = data.getLootItems().getFirst();
            Registry.register(BuiltInRegistries.ITEM, id,
                    new KNBowlFoodBlockItem(block, data.itemFood(), data.itemConsumable(), first, id.getPath()));
        });
    }

    private static @NotNull FoodBiteBlock getFoodBiteBlock(FoodBiteRegistry.FoodData data, String name) {
        FoodBiteBlock biteBlock;
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .forceSolidOn()
                .instabreak()
                .mapColor(MapColor.WOOD)
                .sound(SoundType.WOOD)
                .pushReaction(PushReaction.DESTROY)
                .noOcclusion();

        if (data.blockType() == FoodBiteRegistry.BlockType.ONE_BY_TWO) {
            biteBlock = new FoodBiteOneByTwoBlock(
                    properties.setId(ResourceKey.create(Registries.BLOCK, KaleidoscopeNether.id(name))),
                    data.blockFood(),
                    data.blockConsumable(),
                    data.maxBites(),
                    data.animateTick()
            );
        } else {
            biteBlock = new FoodBiteBlock(
                    properties.setId(ResourceKey.create(Registries.BLOCK, KaleidoscopeNether.id(name))),
                    data.blockFood(),
                    data.blockConsumable(),
                    data.maxBites(),
                    data.animateTick()
            );
        }

        VoxelShape aabb = data.getAABB();
        if (aabb != null) {
            biteBlock.setAABB(aabb);
        }
        return biteBlock;
    }

    private static Identifier registerFoodData(Identifier id, FoodBiteRegistry.FoodData data) {
        FOOD_DATA_MAP.put(id, data);
        FOOD_DATA_ORDER.addIfAbsent(id);
        return id;
    }

    public static void forEach(BiConsumer<Identifier, FoodBiteRegistry.FoodData> consumer) {
        for (Identifier id : FOOD_DATA_ORDER) {
            FoodBiteRegistry.FoodData data = FOOD_DATA_MAP.get(id);
            if (data != null) {
                consumer.accept(id, data);
            }
        }
    }
}
