package com.bmt.kaleidoscope_nether.init;

import net.minecraft.world.food.FoodProperties;

public interface KNFoods {

    // 巨型野兽可颂
    FoodProperties GIANT_BEAST_CROISSANT = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 熔岩咕咾肉
    FoodProperties MAGMA_SWEET_AND_SOUR_PORK = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 灵魂羊排
    FoodProperties SOUL_LAMB_CHOP_ITEM = (new FoodProperties.Builder()).nutrition(13).saturationModifier(0.611F).build();

    FoodProperties SOUL_LAMB_CHOP_BLOCK = (new FoodProperties.Builder()).nutrition(3).saturationModifier(0.611F).build();

    // 烈焰永恒牛排
    FoodProperties EVERLASTING_FLAME_STEAK = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1.2f)
            .alwaysEdible()
            .build();

    // 绯红果
    FoodProperties CRIMSON_FRUIT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 诡异果
    FoodProperties WARPED_FRUIT = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 下界猪儿虫
    FoodProperties NETHER_CATERPILLAR = new FoodProperties.Builder()
            .nutrition(18).saturationModifier(0.2f)
            .alwaysEdible()
            .build();

    // 回魂饭
    FoodProperties SOUL_RETURN_RICE = new FoodProperties.Builder()
            .nutrition(16).saturationModifier(1.8f)
            .alwaysEdible()
            .build();

    // 熔岩烤鸡
    FoodProperties LAVA_ROASTED_CHICKEN = new FoodProperties.Builder()
            .nutrition(13)
            .saturationModifier(0.615f)
            .alwaysEdible()
            .build();

    // 星之炖菜
    FoodProperties STAR_STEW = new FoodProperties.Builder()
            .nutrition(16).saturationModifier(1.8f)
            .alwaysEdible()
            .build();

    // 灵魂浓汤
    FoodProperties SOUL_SOUP = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 生炽足兽肉
    FoodProperties RAW_STRIDER_MEAT = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 熟炽足兽肉
    FoodProperties COOKED_STRIDER_MEAT = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 疣猪火腿
    FoodProperties HAM = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f)
            .alwaysEdible()
            .build();

    // 火腿片
    FoodProperties HAM_SLICE = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.2f)
            .alwaysEdible()
            .build();

    // 烤疣猪火腿
    FoodProperties ROASTED_HAM = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 肉夹馍
    FoodProperties ROUJIAMO = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(1.0f)
            .alwaysEdible()
            .build();

    // 红烧炽足兽
    FoodProperties BRAISED_STRIDER = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 凋零大骨汤
    FoodProperties WITHER_BONE_SOUP = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 炽足兽炖下界疣
    FoodProperties STRIDER_NETHER_WART_STEW = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.615f)
            .alwaysEdible()
            .build();

    // 恶魂烤串
    FoodProperties GHAST_KABOB = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f)
            .alwaysEdible()
            .build();

    // 恶魂触手
    FoodProperties GHAST_TENTACLE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 烤恶魂触手
    FoodProperties ROASTED_GHAST_TENTACLE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .alwaysEdible()
            .build();

    // 恶魂意面
    FoodProperties GHAST_PASTA = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 岩浆膏浓汤
    FoodProperties MAGMA_CREAM_SOUP = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 岩浆膏布丁
    FoodProperties MAGMA_CREAM_PUDDING = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.0f)
            .alwaysEdible()
            .build();

    // 剧毒果
    FoodProperties POISONOUS_FRUIT = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.1f)
            .alwaysEdible()
            .build();

    // 剧毒浓汤
    FoodProperties POISONOUS_SOUP = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 灵魂浇汁烤肉
    FoodProperties SOUL_GLAZED_ROAST = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.615f)
            .alwaysEdible()
            .build();

    // 恶魂布丁
    FoodProperties GHAST_PUDDING = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 野蛮烤肉
    FoodProperties GILDED_BARBARIC_ROAST = new FoodProperties.Builder()
            .nutrition(24).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 下界猪儿虫刺身
    FoodProperties NETHER_CATERPILLAR_SASHIMI = new FoodProperties.Builder()
            .nutrition(19).saturationModifier(0.65f)
            .alwaysEdible()
            .build();

    // 黄金烤肉
    FoodProperties GOLDEN_ROAST = new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 下界薯条拼盘
    FoodProperties NETHER_FRIES_PLATTER = new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 疣猪兽獠牙焖肉
    FoodProperties HOGLIN_TUSK_BRAISED_MEAT = new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 剧毒恶魂烤肉
    FoodProperties POISONOUS_GHAST_ROAST = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 灵魂椒炒肉
    FoodProperties SOUL_PEPPER_STIR_FRY = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 炽足兽岩壳炒肉
    FoodProperties STRIDER_SHELL_STIR_FRY = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.615f)
            .alwaysEdible()
            .build();

    // 下界果切拼盘
    FoodProperties FRUIT_PLATTER = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 火腿酸酪
    FoodProperties HAM_YOGURT = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.615f)
            .alwaysEdible()
            .build();

    // 酸菜鱼
    FoodProperties SAUERKRAUT_FISH = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 烈焰浓汤
    FoodProperties BLAZE_SOUP = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 熔岩果冻
    FoodProperties LAVA_JELLY = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.0f)
            .alwaysEdible()
            .build();

    // 绯红沙拉
    FoodProperties CRIMSON_SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 绯红菌岩浆膏炖肉
    FoodProperties CRIMSON_MAGMA_STEW = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 诡异沙拉
    FoodProperties WARPED_SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 灵魂炽足兽烤串
    FoodProperties SOUL_STRIDER_KABOB = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f)
            .alwaysEdible()
            .build();

    // 黄金烤串
    FoodProperties GOLDEN_KABOB = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 烈焰烤串
    FoodProperties BLAZING_KABOB = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f)
            .alwaysEdible()
            .build();

    // 绯红烤串
    FoodProperties CRIMSON_KABOB = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 诡异烤串
    FoodProperties WARPED_KABOB = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 星之恶魂意面
    FoodProperties STAR_GHAST_PASTA = new FoodProperties.Builder()
            .nutrition(16).saturationModifier(1.8f)
            .alwaysEdible()
            .build();

    // 星之炖肉
    FoodProperties STAR_STEW_MEAT = new FoodProperties.Builder()
            .nutrition(16).saturationModifier(1.8f)
            .alwaysEdible()
            .build();

    // 荧光浓汤
    FoodProperties GLOWING_SOUP = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 荧光布丁
    FoodProperties GLOWING_PUDDING = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.0f)
            .alwaysEdible()
            .build();

    // 荧光烤串
    FoodProperties GLOWING_KABOB = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 荧光沙拉
    FoodProperties GLOWING_SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 黑苹果沙拉
    FoodProperties BLACK_APPLE_SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 红宝石牛排
    FoodProperties RUBY_STEAK = new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 下界芦苇炖菜
    FoodProperties NETHER_REED_STEW = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 岩浆膏炒肉
    FoodProperties MAGMA_CREAM_STIR_FRY = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 岩浆膏炒肉盖饭
    FoodProperties MAGMA_CREAM_STIR_FRY_RICE = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 麻婆豆腐
    FoodProperties MAPO_TOFU = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 麻婆豆腐盖饭
    FoodProperties MAPO_TOFU_RICE = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 诡异蛋糕
    FoodProperties WARPED_CAKE = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.4f)
            .alwaysEdible()
            .build();

    // 重庆小面
    FoodProperties CHONGQING_NOODLES = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 螺蛳粉
    FoodProperties LUOSIFEN = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 灵魂炒肉
    FoodProperties SOUL_STIR_FRY_MEAT = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 灵魂炒肉盖饭
    FoodProperties SOUL_STIR_FRY_MEAT_RICE = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 焦糖下界猪儿虫
    FoodProperties CARAMEL_NETHER_CATERPILLAR = new FoodProperties.Builder()
            .nutrition(18).saturationModifier(0.36f)
            .alwaysEdible()
            .build();

    // 焦糖下界猪儿虫盖饭
    FoodProperties CARAMEL_NETHER_CATERPILLAR_RICE = new FoodProperties.Builder()
            .nutrition(19).saturationModifier(0.7f)
            .alwaysEdible()
            .build();

    // 生猪灵肉
    FoodProperties RAW_PIGLIN_MEAT = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    // 熟猪灵肉
    FoodProperties COOKED_PIGLIN_MEAT = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.8f)
            .alwaysEdible()
            .build();

    // 诡异霉烂肉
    FoodProperties WARPED_HOGLIN_TENDERLOIN_STEW = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.667f)
            .alwaysEdible()
            .build();

    // 麻辣疣猪兽拉面
    FoodProperties SPICY_HOGLIN_RAMEN = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 麻辣香锅
    FoodProperties SPICY_POT = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 麻辣香锅盖饭
    FoodProperties SPICY_POT_RICE = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.643f)
            .alwaysEdible()
            .build();

    // 孟婆汤
    FoodProperties FORGETFULNESS_SOUP = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(1.0f)
            .alwaysEdible()
            .build();

    // 红烧狮子头
    FoodProperties BRAISED_LION_HEAD_ITEM = new FoodProperties.Builder()
            .nutrition(16)
            .saturationModifier(0.8F)
            .alwaysEdible()
            .build();

    FoodProperties BRAISED_LION_HEAD_BLOCK = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.8F)
            .alwaysEdible()
            .build();

    // 蒜蓉生蚝
    FoodProperties GARLIC_OYSTERS = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 夫妻肺片
    FoodProperties COUPLES_LUNG_SLICE = new FoodProperties.Builder()
            .nutrition(13).saturationModifier(0.611f)
            .alwaysEdible()
            .build();

    // 卤肉饭
    FoodProperties BRAISED_PORK_RICE_ITEM = new FoodProperties.Builder()
            .nutrition(13)
            .saturationModifier(0.611F)
            .alwaysEdible()
            .build();

    FoodProperties BRAISED_PORK_RICE_BLOCK = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.611F)
            .alwaysEdible()
            .build();

    // 胡椒猪肚鸡汤
    FoodProperties PEPPER_PORK_BELLY_CHICKEN_SOUP = new FoodProperties.Builder()
            .nutrition(20).saturationModifier(0.55f)
            .alwaysEdible()
            .build();

    // 玉米胡萝卜排骨汤
    FoodProperties CORN_CARROT_PORK_RIB_SOUP_ITEM = new FoodProperties.Builder()
            .nutrition(20)
            .saturationModifier(0.55F)
            .alwaysEdible()
            .build();

    FoodProperties CORN_CARROT_PORK_RIB_SOUP_BLOCK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.55F)
            .alwaysEdible()
            .build();

    public static void init() {
    }
}
