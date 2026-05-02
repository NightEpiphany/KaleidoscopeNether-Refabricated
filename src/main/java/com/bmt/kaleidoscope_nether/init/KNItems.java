package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.config.MainConfig;
import com.bmt.kaleidoscope_nether.item.*;
import com.bmt.kaleidoscope_nether.item.SpecialFruitBlockItem;
import com.bmt.kaleidoscope_nether.item.StickReturnFoodItem;
import com.bmt.kaleidoscope_nether.util.PrimitiveMacheteTier;
import com.github.ysbbbbbb.kaleidoscopecookery.item.BowlFoodOnlyItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.ChiliItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import com.github.ysbbbbbb.kaleidoscopecookery.item.KitchenKnifeItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import java.util.function.Supplier;

public final class KNItems {
    // 巨型野兽可颂
    public static final Supplier<Item> GIANT_BEAST_CROISSANT = register("giant_beast_croissant",
            () -> new Item(new Item.Properties()
                    .fireResistant().food(KNFoods.GIANT_BEAST_CROISSANT)));

    // 熔岩咕咾肉
    public static final Supplier<Item> MAGMA_SWEET_AND_SOUR_PORK = register("magma_sweet_and_sour_pork",
            () -> new Item(new Item.Properties()
                    .fireResistant().food(KNFoods.MAGMA_SWEET_AND_SOUR_PORK)));

    // 恶魂皮
    public static final Supplier<Item> GHAST_HIDE = register("ghast_hide",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    // 疣猪兽獠牙
    public static final Supplier<Item> HOGLIN_TUSK = register("hoglin_tusk",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    // 炽足兽岩壳
    public static final Supplier<Item> STRIDER_ROCK_SHELL = register("strider_rock_shell",
            () -> new Item(new Item.Properties()
                    .fireResistant()));

    // 镀金碎片
    public static final Supplier<Item> GILDED_FRAGMENT = register("gilded_fragment",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    // 凋零骨头
    public static final Supplier<Item> WITHER_RIB = register("wither_rib",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON)));

    // 下界炉灶
    public static final Supplier<Item> NETHER_STOVE = register("nether_stove",
            () -> new BlockItem(KNBlocks.NETHER_STOVE.get(), new Item.Properties()));

    // 星之尘
    public static final Supplier<Item> STAR_DUST = register("star_dust",
            () -> new StarDustItem(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // 烈焰珍珠
    public static final Supplier<Item> BLAZE_HEART = register("blaze_heart",
            () -> new ThrowableFuelItem(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .stacksTo(16),
                    3000));

    // 疣猪兽皮
    public static final Supplier<Item> HOGLIN_HIDE = register("hoglin_hide",
            () -> new Item(new Item.Properties()));

    // 吹箭筒
    public static final Supplier<Item> BLOWGUN = register("blowgun",
            () -> new BlowgunItem(new Item.Properties()
                    .durability(384)
                    .rarity(Rarity.UNCOMMON)));

    // 原始砍刀
    public static final Supplier<Item> PRIMITIVE_MACHETE = register("primitive_machete",
            () -> new KitchenKnifeItem(new PrimitiveMacheteTier(),new Item.Properties().durability(2031)));

    // 恶魂挂坠
    public static final Supplier<Item> GHAST_PENDANT = register("ghast_pendant",
            GhastPendantItem::new);

    // 烈焰永恒牛排
    public static final Supplier<Item> EVERLASTING_FLAME_STEAK = register("everlasting_flame_steak",
            () -> new EverlastingFoodItem(KNFoods.EVERLASTING_FLAME_STEAK, MainConfig.EVERLASTING_FLAME_STEAK_COOLDOWN, MainConfig.EVERLASTING_FLAME_STEAK_ENABLED,Rarity.EPIC));

    // 绯红果
    public static final Supplier<Item> CRIMSON_FRUIT = register("crimson_fruit",
            () -> new SpecialFruitBlockItem(KNBlocks.WEEPING_CAVE_VINES.get(), KNFoods.CRIMSON_FRUIT, Rarity.COMMON));

    // 诡异果
    public static final Supplier<Item> WARPED_FRUIT = register("warped_fruit",
            () -> new SpecialFruitBlockItem(KNBlocks.TWISTING_CAVE_VINES.get(), KNFoods.WARPED_FRUIT, Rarity.COMMON));

    // 下界猪儿虫
    public static final Supplier<Item> NETHER_CATERPILLAR = register("nether_caterpillar",
            () -> new NetherCaterpillarItem(KNFoods.NETHER_CATERPILLAR));

    // 回魂饭
    public static final Supplier<Item> SOUL_RETURN_RICE = register("soul_return_rice",
            () -> new SoulReturnRiceItem(KNFoods.SOUL_RETURN_RICE));

    // 熔岩烤鸡
    public static final Supplier<Item> LAVA_ROASTED_CHICKEN = register("lava_roasted_chicken",
            () -> new LavaRoastedChickenItem(KNFoods.LAVA_ROASTED_CHICKEN));

    // 星之炖菜
    public static final Supplier<Item> STAR_STEW = register("star_stew",
            () -> new BowlFoodOnlyItem(KNFoods.STAR_STEW));

    // 灵魂椒
    public static final Supplier<Item> SOUL_PEPPER = register("soul_pepper",
            () -> new ChiliItem(4));

    // 灵魂浓汤
    public static final Supplier<Item> SOUL_SOUP = register("soul_soup",
            () -> new BowlFoodOnlyItem(KNFoods.SOUL_SOUP));

    // 生炽足兽肉
    public static final Supplier<Item> RAW_STRIDER_MEAT = register("raw_strider_meat",
            () -> new Item(new Item.Properties().food(KNFoods.RAW_STRIDER_MEAT)));

    // 熟炽足兽肉
    public static final Supplier<Item> COOKED_STRIDER_MEAT = register("cooked_strider_meat",
            () -> new Item(new Item.Properties().food(KNFoods.COOKED_STRIDER_MEAT)));

    // 疣猪火腿
    public static final Supplier<Item> HAM = register("ham",
            () -> new Item(new Item.Properties().food(KNFoods.HAM)));

    // 火腿片
    public static final Supplier<Item> HAM_SLICE = register("ham_slice",
            () -> new Item(new Item.Properties().food(KNFoods.HAM_SLICE)));

    // 烤疣猪火腿
    public static final Supplier<Item> ROASTED_HAM = register("roasted_ham",
            () -> new Item(new Item.Properties().food(KNFoods.ROASTED_HAM)));

    // 肉夹馍
    public static final Supplier<Item> ROUJIAMO = register("roujiamo",
            () -> new FoodWithEffectsItem(KNFoods.ROUJIAMO));

    // 红烧炽足兽
    public static final Supplier<Item> BRAISED_STRIDER = register("braised_strider",
            () -> new BowlFoodOnlyItem(KNFoods.BRAISED_STRIDER));

    // 凋零大骨汤
    public static final Supplier<Item> WITHER_BONE_SOUP = register("wither_bone_soup",
            () -> new BowlFoodOnlyItem(KNFoods.WITHER_BONE_SOUP));

    // 炽足兽炖下界疣
    public static final Supplier<Item> STRIDER_NETHER_WART_STEW = register("strider_nether_wart_stew",
            () -> new BowlFoodOnlyItem(KNFoods.STRIDER_NETHER_WART_STEW));

    // 恶魂烤串
    public static final Supplier<Item> GHAST_KABOB = register("ghast_kabob",
            () -> new StickReturnFoodItem(KNFoods.GHAST_KABOB));

    // 恶魂触手
    public static final Supplier<Item> GHAST_TENTACLE = register("ghast_tentacle",
            () -> new Item(new Item.Properties().food(KNFoods.GHAST_TENTACLE)));

    // 烤恶魂触手
    public static final Supplier<Item> ROASTED_GHAST_TENTACLE = register("roasted_ghast_tentacle",
            () -> new Item(new Item.Properties().food(KNFoods.ROASTED_GHAST_TENTACLE)));

    // 恶魂意面
    public static final Supplier<Item> GHAST_PASTA = register("ghast_pasta",
            () -> new BowlFoodOnlyItem(KNFoods.GHAST_PASTA));

    // 岩浆膏浓汤
    public static final Supplier<Item> MAGMA_CREAM_SOUP = register("magma_cream_soup",
            () -> new BowlFoodOnlyItem(KNFoods.MAGMA_CREAM_SOUP));

    // 岩浆膏布丁
    public static final Supplier<Item> MAGMA_CREAM_PUDDING = register("magma_cream_pudding",
            () -> new BowlFoodOnlyItem(KNFoods.MAGMA_CREAM_PUDDING));

    // 剧毒果
    public static final Supplier<Item> POISONOUS_FRUIT = register("poisonous_fruit",
            () -> new MysteriousPoisonFoodBlockItem(KNBlocks.POISONOUS_FRUIT.get(), KNFoods.POISONOUS_FRUIT, Rarity.COMMON));

    // 剧毒浓汤
    public static final Supplier<Item> POISONOUS_SOUP = register("poisonous_soup",
            () -> new BowlFoodOnlyItem(KNFoods.POISONOUS_SOUP));

    // 灵魂浇汁烤肉
    public static final Supplier<Item> SOUL_GLAZED_ROAST = register("soul_glazed_roast",
            () -> new BowlFoodOnlyItem(KNFoods.SOUL_GLAZED_ROAST));

    // 恶魂布丁
    public static final Supplier<Item> GHAST_PUDDING = register("ghast_pudding",
            () -> new BowlFoodOnlyItem(KNFoods.GHAST_PUDDING));

    // 野蛮烤肉
    public static final Supplier<Item> GILDED_BARBARIC_ROAST = register("gilded_barbaric_roast",
            () -> new BowlFoodOnlyItem(KNFoods.GILDED_BARBARIC_ROAST));

    // 下界猪儿虫刺身
    public static final Supplier<Item> NETHER_CATERPILLAR_SASHIMI = register("nether_caterpillar_sashimi",
            () -> new BowlFoodOnlyItem(KNFoods.NETHER_CATERPILLAR_SASHIMI));

    // 黄金烤肉
    public static final Supplier<Item> GOLDEN_ROAST = register("golden_roast",
            () -> new BowlFoodOnlyItem(KNFoods.GOLDEN_ROAST));

    // 下界薯条拼盘
    public static final Supplier<Item> NETHER_FRIES_PLATTER = register("nether_fries_platter",
            () -> new BowlFoodOnlyItem(KNFoods.NETHER_FRIES_PLATTER));

    // 疣猪兽獠牙焖肉
    public static final Supplier<Item> HOGLIN_TUSK_BRAISED_MEAT = register("hoglin_tusk_braised_meat",
            () -> new FoodWithEffectsItem(KNFoods.HOGLIN_TUSK_BRAISED_MEAT));

    // 剧毒恶魂烤肉
    public static final Supplier<Item> POISONOUS_GHAST_ROAST = register("poisonous_ghast_roast",
            () -> new BowlFoodOnlyItem(KNFoods.POISONOUS_GHAST_ROAST));

    // 灵魂椒炒肉
    public static final Supplier<Item> SOUL_PEPPER_STIR_FRY = register("soul_pepper_stir_fry",
            () -> new BowlFoodOnlyItem(KNFoods.SOUL_PEPPER_STIR_FRY));

    // 炽足兽岩壳炒肉
    public static final Supplier<Item> STRIDER_SHELL_STIR_FRY = register("strider_shell_stir_fry",
            () -> new BowlFoodOnlyItem(KNFoods.STRIDER_SHELL_STIR_FRY));

    // 下界果切拼盘
    public static final Supplier<Item> FRUIT_PLATTER = register("fruit_platter",
            () -> new BowlFoodOnlyItem(KNFoods.FRUIT_PLATTER));

    // 火腿酸酪
    public static final Supplier<Item> HAM_YOGURT = register("ham_yogurt",
            () -> new BowlFoodOnlyItem(KNFoods.HAM_YOGURT));

    // 酸菜鱼
    public static final Supplier<Item> SAUERKRAUT_FISH = register("sauerkraut_fish",
            () -> new BowlFoodOnlyItem(KNFoods.SAUERKRAUT_FISH));

    // 烈焰浓汤
    public static final Supplier<Item> BLAZE_SOUP = register("blaze_soup",
            () -> new BowlFoodOnlyItem(KNFoods.BLAZE_SOUP));

    // 熔岩果冻
    public static final Supplier<Item> LAVA_JELLY = register("lava_jelly",
            () -> new BowlFoodOnlyItem(KNFoods.LAVA_JELLY));

    // 绯红沙拉
    public static final Supplier<Item> CRIMSON_SALAD = register("crimson_salad",
            () -> new BowlFoodOnlyItem(KNFoods.CRIMSON_SALAD));

    // 绯红菌岩浆膏炖肉
    public static final Supplier<Item> CRIMSON_MAGMA_STEW = register("crimson_magma_stew",
            () -> new BowlFoodOnlyItem(KNFoods.CRIMSON_MAGMA_STEW));

    // 诡异沙拉
    public static final Supplier<Item> WARPED_SALAD = register("warped_salad",
            () -> new BowlFoodOnlyItem(KNFoods.WARPED_SALAD));

    // 灵魂炽足兽烤串
    public static final Supplier<Item> SOUL_STRIDER_KABOB = register("soul_strider_kabob",
            () -> new StickReturnFoodItem(KNFoods.SOUL_STRIDER_KABOB));

    // 黄金烤串
    public static final Supplier<Item> GOLDEN_KABOB = register("golden_kabob",
            () -> new StickReturnFoodItem(KNFoods.GOLDEN_KABOB));

    // 烈焰烤串
    public static final Supplier<Item> BLAZING_KABOB = register("blazing_kabob",
            () -> new StickReturnFoodItem(KNFoods.BLAZING_KABOB));

    // 绯红烤串
    public static final Supplier<Item> CRIMSON_KABOB = register("crimson_kabob",
            () -> new StickReturnFoodItem(KNFoods.CRIMSON_KABOB));

    // 诡异烤串
    public static final Supplier<Item> WARPED_KABOB = register("warped_kabob",
            () -> new StickReturnFoodItem(KNFoods.WARPED_KABOB));

    // 星之恶魂意面
    public static final Supplier<Item> STAR_GHAST_PASTA = register("star_ghast_pasta",
            () -> new BowlFoodOnlyItem(KNFoods.STAR_GHAST_PASTA));

    // 星之炖肉
    public static final Supplier<Item> STAR_STEW_MEAT = register("star_stew_meat",
            () -> new BowlFoodOnlyItem(KNFoods.STAR_STEW_MEAT));

    // 荧光浓汤
    public static final Supplier<Item> GLOWING_SOUP = register("glowing_soup",
            () -> new BowlFoodOnlyItem(KNFoods.GLOWING_SOUP));

    // 荧光布丁
    public static final Supplier<Item> GLOWING_PUDDING = register("glowing_pudding",
            () -> new BowlFoodOnlyItem(KNFoods.GLOWING_PUDDING));

    // 荧光烤串
    public static final Supplier<Item> GLOWING_KABOB = register("glowing_kabob",
            () -> new StickReturnFoodItem(KNFoods.GLOWING_KABOB));

    // 荧光沙拉
    public static final Supplier<Item> GLOWING_SALAD = register("glowing_salad",
            () -> new BowlFoodOnlyItem(KNFoods.GLOWING_SALAD));

    // 黑苹果沙拉
    public static final Supplier<Item> BLACK_APPLE_SALAD = register("black_apple_salad",
            () -> new BowlFoodOnlyItem(KNFoods.BLACK_APPLE_SALAD));

    // 红宝石牛排
    public static final Supplier<Item> RUBY_STEAK = register("ruby_steak",
            () -> new BowlFoodOnlyItem(KNFoods.RUBY_STEAK));

    // 下界芦苇炖菜
    public static final Supplier<Item> NETHER_REED_STEW = register("nether_reed_stew",
            () -> new BowlFoodOnlyItem(KNFoods.NETHER_REED_STEW));

    // 岩浆膏炒肉
    public static final Supplier<Item> MAGMA_CREAM_STIR_FRY = register("magma_cream_stir_fry",
            () -> new BowlFoodOnlyItem(KNFoods.MAGMA_CREAM_STIR_FRY));

    // 岩浆膏炒肉盖饭
    public static final Supplier<Item> MAGMA_CREAM_STIR_FRY_RICE = register("magma_cream_stir_fry_rice",
            () -> new BowlFoodOnlyItem(KNFoods.MAGMA_CREAM_STIR_FRY_RICE));

    // 麻婆豆腐
    public static final Supplier<Item> MAPO_TOFU = register("mapo_tofu",
            () -> new BowlFoodOnlyItem(KNFoods.MAPO_TOFU));

    // 麻婆豆腐盖饭
    public static final Supplier<Item> MAPO_TOFU_RICE = register("mapo_tofu_rice",
            () -> new BowlFoodOnlyItem(KNFoods.MAPO_TOFU_RICE));

    // 诡异蛋糕
    public static final Supplier<Item> WARPED_CAKE = register("warped_cake",
            () -> new FoodWithEffectsItem(KNFoods.WARPED_CAKE));

    // 重庆小面
    public static final Supplier<Item> CHONGQING_NOODLES = register("chongqing_noodles",
            () -> new BowlFoodOnlyItem(KNFoods.CHONGQING_NOODLES));

    // 螺蛳粉
    public static final Supplier<Item> LUOSIFEN = register("luosifen",
            () -> new BowlFoodOnlyItem(KNFoods.LUOSIFEN));

    // 灵魂炒肉
    public static final Supplier<Item> SOUL_STIR_FRY_MEAT = register("soul_stir_fry_meat",
            () -> new BowlFoodOnlyItem(KNFoods.SOUL_STIR_FRY_MEAT));

    // 灵魂炒肉盖饭
    public static final Supplier<Item> SOUL_STIR_FRY_MEAT_RICE = register("soul_stir_fry_meat_rice",
            () -> new BowlFoodOnlyItem(KNFoods.SOUL_STIR_FRY_MEAT_RICE));

    // 焦糖下界猪儿虫
    public static final Supplier<Item> CARAMEL_NETHER_CATERPILLAR = register("caramel_nether_caterpillar",
            () -> new BowlFoodOnlyItem(KNFoods.CARAMEL_NETHER_CATERPILLAR));

    // 焦糖下界猪儿虫盖饭
    public static final Supplier<Item> CARAMEL_NETHER_CATERPILLAR_RICE = register("caramel_nether_caterpillar_rice",
            () -> new BowlFoodOnlyItem(KNFoods.CARAMEL_NETHER_CATERPILLAR_RICE));

    // 生猪灵肉
    public static final Supplier<Item> RAW_PIGLIN_MEAT = register("raw_piglin_meat",
            () -> new Item(new Item.Properties().food(KNFoods.RAW_PIGLIN_MEAT)));

    // 熟猪灵肉
    public static final Supplier<Item> COOKED_PIGLIN_MEAT = register("cooked_piglin_meat",
            () -> new Item(new Item.Properties().food(KNFoods.COOKED_PIGLIN_MEAT)));

    // 诡异霉烂肉
    public static final Supplier<Item> WARPED_HOGLIN_TENDERLOIN_STEW = register("warped_hoglin_tenderloin_stew",
            () -> new BowlFoodOnlyItem(KNFoods.WARPED_HOGLIN_TENDERLOIN_STEW));

    // 麻辣疣猪兽拉面
    public static final Supplier<Item> SPICY_HOGLIN_RAMEN = register("spicy_hoglin_ramen",
            () -> new BowlFoodOnlyItem(KNFoods.SPICY_HOGLIN_RAMEN));

    // 麻辣香锅
    public static final Supplier<Item> SPICY_POT = register("spicy_pot",
            () -> new BowlFoodOnlyItem(KNFoods.SPICY_POT));

    // 麻辣香锅盖饭
    public static final Supplier<Item> SPICY_POT_RICE = register("spicy_pot_rice",
            () -> new BowlFoodOnlyItem(KNFoods.SPICY_POT_RICE));

    // 孟婆汤
    public static final Supplier<Item> FORGETFULNESS_SOUP = register("forgetfulness_soup",
            () -> new ForgetfulnessSoupItem(KNFoods.FORGETFULNESS_SOUP));

    // 蒜蓉生蚝
    public static final Supplier<Item> GARLIC_OYSTERS = register("garlic_oysters",
            () -> new BowlFoodOnlyItem(KNFoods.GARLIC_OYSTERS));

    // 夫妻肺片
    public static final Supplier<Item> COUPLES_LUNG_SLICE = register("couples_lung_slice",
            () -> new BowlFoodOnlyItem(KNFoods.COUPLES_LUNG_SLICE));

    // 胡椒猪肚鸡汤
    public static final Supplier<Item> PEPPER_PORK_BELLY_CHICKEN_SOUP = register("pepper_pork_belly_chicken_soup",
            () -> new BowlFoodOnlyItem(KNFoods.PEPPER_PORK_BELLY_CHICKEN_SOUP));

    private static <T extends Item> Supplier<T> register(String name, Supplier<T> factory) {
        T item = Registry.register(BuiltInRegistries.ITEM, KaleidoscopeNether.id(name), factory.get());
        return () -> item;
    }

    public static void registerItems() {
    }
}