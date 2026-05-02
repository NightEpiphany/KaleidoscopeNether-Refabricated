package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface KNConsumables {

    // 巨型野兽可颂
    public static final Consumable GIANT_BEAST_CROISSANT = buildConsumable();



    // 熔岩咕咾肉
    public static final Consumable MAGMA_SWEET_AND_SOUR_PORK = buildConsumable();



    // 灵魂羊排
    public static final Consumable SOUL_LAMB_CHOP_ITEM = buildConsumable(createNetherEffect("ghost", 180 * 20));

    public static final Consumable SOUL_LAMB_CHOP_BLOCK = buildConsumable(createNetherEffect("ghost", 240 * 20));



    // 烈焰永恒牛排
    public static final Consumable EVERLASTING_FLAME_STEAK = buildConsumable(createCookeryEffect("satiated_shield", 300), createCookeryEffect("warmth", 600));



    // 绯红果
    public static final Consumable CRIMSON_FRUIT = buildConsumable();



    // 诡异果
    public static final Consumable WARPED_FRUIT = buildConsumable();



    // 下界猪儿虫
    public static final Consumable NETHER_CATERPILLAR = buildConsumable(createDefaultEffect("nausea", 200));



    // 回魂饭
    public static final Consumable SOUL_RETURN_RICE = buildConsumable(createNetherEffect("ghost", 90 * 20));



    // 熔岩烤鸡
    public static final Consumable LAVA_ROASTED_CHICKEN = buildConsumable();



    // 星之炖菜
    public static final Consumable STAR_STEW = buildConsumable(createNetherEffect("star_blessing", 600));



    // 灵魂浓汤
    public static final Consumable SOUL_SOUP = buildConsumable(createNetherEffect("ghost", 90 * 20));



    // 生炽足兽肉
    public static final Consumable RAW_STRIDER_MEAT = buildConsumable();



    // 熟炽足兽肉
    public static final Consumable COOKED_STRIDER_MEAT = buildConsumable();



    // 疣猪火腿
    public static final Consumable HAM = buildConsumable();



    // 火腿片
    public static final Consumable HAM_SLICE = buildConsumable();



    // 烤疣猪火腿
    public static final Consumable ROASTED_HAM = buildConsumable();



    // 肉夹馍
    public static final Consumable ROUJIAMO = buildConsumable(createDefaultEffect("absorption", 80 * 20));



    // 红烧炽足兽
    public static final Consumable BRAISED_STRIDER = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 凋零大骨汤
    public static final Consumable WITHER_BONE_SOUP = buildConsumable(createCookeryEffect("vigor", 300 * 20));



    // 炽足兽炖下界疣
    public static final Consumable STRIDER_NETHER_WART_STEW = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 恶魂烤串
    public static final Consumable GHAST_KABOB = buildConsumable();



    // 恶魂触手
    public static final Consumable GHAST_TENTACLE = buildConsumable();



    // 烤恶魂触手
    public static final Consumable ROASTED_GHAST_TENTACLE = buildConsumable();



    // 恶魂意面
    public static final Consumable GHAST_PASTA = buildConsumable(createCookeryEffect("sulfur", 90 * 20));



    // 岩浆膏浓汤
    public static final Consumable MAGMA_CREAM_SOUP = buildConsumable(createCookeryEffect("warmth", 480 * 20));



    // 岩浆膏布丁
    public static final Consumable MAGMA_CREAM_PUDDING = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 剧毒果
    public static final Consumable POISONOUS_FRUIT = buildConsumable();



    // 剧毒浓汤
    public static final Consumable POISONOUS_SOUP = buildConsumable(createNetherEffect("mysterious_poison", 80 * 20));



    // 灵魂浇汁烤肉
    public static final Consumable SOUL_GLAZED_ROAST = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 恶魂布丁
    public static final Consumable GHAST_PUDDING = buildConsumable(createCookeryEffect("vigor", 180 * 20));



    // 野蛮烤肉
    public static final Consumable GILDED_BARBARIC_ROAST = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 下界猪儿虫刺身
    public static final Consumable NETHER_CATERPILLAR_SASHIMI = buildConsumable(createCookeryEffect("mustard", 300 * 20));



    // 黄金烤肉
    public static final Consumable GOLDEN_ROAST = buildConsumable(createCookeryEffect("vigor", 120 * 20));



    // 下界薯条拼盘
    public static final Consumable NETHER_FRIES_PLATTER = buildConsumable(createNetherEffect("tropical_strider", 300 * 20));



    // 疣猪兽獠牙焖肉
    public static final Consumable HOGLIN_TUSK_BRAISED_MEAT = buildConsumable(createCookeryEffect("satiated_shield", 80 * 20));



    // 剧毒恶魂烤肉
    public static final Consumable POISONOUS_GHAST_ROAST = buildConsumable(createNetherEffect("mysterious_poison", 60 * 20));



    // 灵魂椒炒肉
    public static final Consumable SOUL_PEPPER_STIR_FRY = buildConsumable(createNetherEffect("ghost", 60 * 20));



    // 炽足兽岩壳炒肉
    public static final Consumable STRIDER_SHELL_STIR_FRY = buildConsumable(createNetherEffect("tropical_strider", 300 * 20));



    // 下界果切拼盘
    public static final Consumable FRUIT_PLATTER = buildConsumable(createCookeryEffect("preservation", 90 * 20));



    // 火腿酸酪
    public static final Consumable HAM_YOGURT = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 酸菜鱼
    public static final Consumable SAUERKRAUT_FISH = buildConsumable(createCookeryEffect("vigor", 240 * 20));



    // 烈焰浓汤
    public static final Consumable BLAZE_SOUP = buildConsumable(createNetherEffect("tropical_strider", 180 * 20));



    // 熔岩果冻
    public static final Consumable LAVA_JELLY = buildConsumable(createNetherEffect("tropical_strider", 120 * 20));



    // 绯红沙拉
    public static final Consumable CRIMSON_SALAD = buildConsumable(createNetherEffect("crimson", 90 * 20));



    // 绯红菌岩浆膏炖肉
    public static final Consumable CRIMSON_MAGMA_STEW = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 诡异沙拉
    public static final Consumable WARPED_SALAD = buildConsumable(createNetherEffect("warped", 90 * 20));



    // 灵魂炽足兽烤串
    public static final Consumable SOUL_STRIDER_KABOB = buildConsumable(createNetherEffect("warped", 30 * 20));



    // 黄金烤串
    public static final Consumable GOLDEN_KABOB = buildConsumable(createCookeryEffect("vigor", 60 * 20));



    // 烈焰烤串
    public static final Consumable BLAZING_KABOB = buildConsumable(createNetherEffect("tropical_strider", 30 * 20));



    // 绯红烤串
    public static final Consumable CRIMSON_KABOB = buildConsumable(createNetherEffect("crimson", 45 * 20));



    // 诡异烤串
    public static final Consumable WARPED_KABOB = buildConsumable(createNetherEffect("warped", 45 * 20));



    // 星之恶魂意面
    public static final Consumable STAR_GHAST_PASTA = buildConsumable(createNetherEffect("star_blessing", 600));



    // 星之炖肉
    public static final Consumable STAR_STEW_MEAT = buildConsumable(createNetherEffect("star_blessing", 600));



    // 荧光浓汤
    public static final Consumable GLOWING_SOUP = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 荧光布丁
    public static final Consumable GLOWING_PUDDING = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 荧光烤串
    public static final Consumable GLOWING_KABOB = buildConsumable(createCookeryEffect("satiated_shield", 45 * 20));



    // 荧光沙拉
    public static final Consumable GLOWING_SALAD = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 黑苹果沙拉
    public static final Consumable BLACK_APPLE_SALAD = buildConsumable(createCookeryEffect("preservation", 90 * 20));



    // 红宝石牛排
    public static final Consumable RUBY_STEAK = buildConsumable(createCookeryEffect("satiated_shield", 240 * 20));



    // 下界芦苇炖菜
    public static final Consumable NETHER_REED_STEW = buildConsumable(createCookeryEffect("warmth", 480 * 20));



    // 岩浆膏炒肉
    public static final Consumable MAGMA_CREAM_STIR_FRY = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 岩浆膏炒肉盖饭
    public static final Consumable MAGMA_CREAM_STIR_FRY_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 麻婆豆腐
    public static final Consumable MAPO_TOFU = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 麻婆豆腐盖饭
    public static final Consumable MAPO_TOFU_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 诡异蛋糕
    public static final Consumable WARPED_CAKE = buildConsumable(createNetherEffect("warped", 60 * 20));



    // 重庆小面
    public static final Consumable CHONGQING_NOODLES = buildConsumable(createCookeryEffect("warmth", 3600));



    // 螺蛳粉
    public static final Consumable LUOSIFEN = buildConsumable(createCookeryEffect("warmth", 3600));



    // 灵魂炒肉
    public static final Consumable SOUL_STIR_FRY_MEAT = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 灵魂炒肉盖饭
    public static final Consumable SOUL_STIR_FRY_MEAT_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 焦糖下界猪儿虫
    public static final Consumable CARAMEL_NETHER_CATERPILLAR = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 焦糖下界猪儿虫盖饭
    public static final Consumable CARAMEL_NETHER_CATERPILLAR_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 生猪灵肉
    public static final Consumable RAW_PIGLIN_MEAT = buildConsumable();



    // 熟猪灵肉
    public static final Consumable COOKED_PIGLIN_MEAT = buildConsumable();



    // 诡异霉烂肉
    public static final Consumable WARPED_HOGLIN_TENDERLOIN_STEW = buildConsumable(createCookeryEffect("flatulence", 35 * 20));



    // 麻辣疣猪兽拉面
    public static final Consumable SPICY_HOGLIN_RAMEN = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 麻辣香锅
    public static final Consumable SPICY_POT = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 麻辣香锅盖饭
    public static final Consumable SPICY_POT_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 孟婆汤
    public static final Consumable FORGETFULNESS_SOUP = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 红烧狮子头
    public static final Consumable BRAISED_LION_HEAD_ITEM = buildConsumable(createCookeryEffect("warmth", 80 * 20));

    public static final Consumable BRAISED_LION_HEAD_BLOCK = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 蒜蓉生蚝
    public static final Consumable GARLIC_OYSTERS = buildConsumable(createDefaultEffect("water_breathing", 180 * 20));



    // 夫妻肺片
    public static final Consumable COUPLES_LUNG_SLICE = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 卤肉饭
    public static final Consumable BRAISED_PORK_RICE_ITEM = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

    public static final Consumable BRAISED_PORK_RICE_BLOCK = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 胡椒猪肚鸡汤
    public static final Consumable PEPPER_PORK_BELLY_CHICKEN_SOUP = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 玉米胡萝卜排骨汤
    public static final Consumable CORN_CARROT_PORK_RIB_SOUP_ITEM = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

    public static final Consumable CORN_CARROT_PORK_RIB_SOUP_BLOCK = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

    private static Consumable buildConsumable(MobEffectInstance... effects) {
        var builder = Consumables.defaultFood();
        List<MobEffectInstance> instances = Arrays.stream(effects)
                .filter(Objects::nonNull)
                .toList();
        if (!instances.isEmpty()) {
            builder.onConsume(new ApplyStatusEffectsConsumeEffect(instances, 1.0F));
        }
        return builder.build();
    }

    private static Consumable buildConsumable() {
        return Consumables.defaultFood().build();
    }

    @Nullable
    private static MobEffectInstance createCookeryEffect(String path, int duration) {
        return createEffect(KaleidoscopeNether.MOD_ID, path, duration);
    }

    @Nullable
    private static MobEffectInstance createNetherEffect(String path, int duration) {
        return createEffect(KaleidoscopeNether.MOD_ID, path, duration);
    }

    @Nullable
    private static MobEffectInstance createDefaultEffect(String path, int duration) {
        return createEffect("minecraft", path, duration);
    }

    @Nullable
    private static MobEffectInstance createEffect(String namespace, String path, int duration) {
        Identifier id = Identifier.fromNamespaceAndPath(namespace, path);
        return BuiltInRegistries.MOB_EFFECT.get(id)
                .map(effect -> new MobEffectInstance(effect, duration, 0))
                .orElse(null);
    }

    public static void init() {
    }
}
