package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface KNConsumables {

    // 巨型野兽可颂
    Consumable GIANT_BEAST_CROISSANT = buildConsumable();



    // 熔岩咕咾肉
    Consumable MAGMA_SWEET_AND_SOUR_PORK = buildConsumable();



    // 灵魂羊排
    Consumable SOUL_LAMB_CHOP_ITEM = buildConsumable(createNetherEffect("ghost", 180 * 20));

    Consumable SOUL_LAMB_CHOP_BLOCK = buildConsumable(createNetherEffect("ghost", 240 * 20));



    // 烈焰永恒牛排
    Consumable EVERLASTING_FLAME_STEAK = buildConsumable(createCookeryEffect("satiated_shield", 300), createCookeryEffect("warmth", 600));



    // 绯红果
    Consumable CRIMSON_FRUIT = buildConsumable();



    // 诡异果
    Consumable WARPED_FRUIT = buildConsumable();



    // 下界猪儿虫
    Consumable NETHER_CATERPILLAR = buildConsumable(createVanillaEffect("nausea", 200));



    // 回魂饭
    Consumable SOUL_RETURN_RICE = buildConsumable(createNetherEffect("ghost", 90 * 20));



    // 熔岩烤鸡
    Consumable LAVA_ROASTED_CHICKEN = buildConsumable();



    // 星之炖菜
    Consumable STAR_STEW = buildConsumable(createNetherEffect("star_blessing", 600));



    // 灵魂浓汤
    Consumable SOUL_SOUP = buildConsumable(createNetherEffect("ghost", 90 * 20));



    // 生炽足兽肉
    Consumable RAW_STRIDER_MEAT = buildConsumable();



    // 熟炽足兽肉
    Consumable COOKED_STRIDER_MEAT = buildConsumable();



    // 疣猪火腿
    Consumable HAM = buildConsumable();



    // 火腿片
    Consumable HAM_SLICE = buildConsumable();



    // 烤疣猪火腿
    Consumable ROASTED_HAM = buildConsumable();



    // 肉夹馍
    Consumable ROUJIAMO = buildConsumable(createVanillaEffect("absorption", 80 * 20));



    // 红烧炽足兽
    Consumable BRAISED_STRIDER = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 凋零大骨汤
    Consumable WITHER_BONE_SOUP = buildConsumable(createCookeryEffect("vigor", 300 * 20));



    // 炽足兽炖下界疣
    Consumable STRIDER_NETHER_WART_STEW = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 恶魂烤串
    Consumable GHAST_KABOB = buildConsumable();



    // 恶魂触手
    Consumable GHAST_TENTACLE = buildConsumable();



    // 烤恶魂触手
    Consumable ROASTED_GHAST_TENTACLE = buildConsumable();



    // 恶魂意面
    Consumable GHAST_PASTA = buildConsumable(createCookeryEffect("sulfur", 90 * 20));



    // 岩浆膏浓汤
    Consumable MAGMA_CREAM_SOUP = buildConsumable(createCookeryEffect("warmth", 480 * 20));



    // 岩浆膏布丁
    Consumable MAGMA_CREAM_PUDDING = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 剧毒果
    Consumable POISONOUS_FRUIT = buildConsumable();



    // 剧毒浓汤
    Consumable POISONOUS_SOUP = buildConsumable(createNetherEffect("mysterious_poison", 80 * 20));



    // 灵魂浇汁烤肉
    Consumable SOUL_GLAZED_ROAST = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 恶魂布丁
    Consumable GHAST_PUDDING = buildConsumable(createCookeryEffect("vigor", 180 * 20));



    // 野蛮烤肉
    Consumable GILDED_BARBARIC_ROAST = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 下界猪儿虫刺身
    Consumable NETHER_CATERPILLAR_SASHIMI = buildConsumable(createCookeryEffect("mustard", 300 * 20));



    // 黄金烤肉
    Consumable GOLDEN_ROAST = buildConsumable(createCookeryEffect("vigor", 120 * 20));



    // 下界薯条拼盘
    Consumable NETHER_FRIES_PLATTER = buildConsumable(createNetherEffect("tropical_strider", 300 * 20));



    // 疣猪兽獠牙焖肉
    Consumable HOGLIN_TUSK_BRAISED_MEAT = buildConsumable(createCookeryEffect("satiated_shield", 80 * 20));



    // 剧毒恶魂烤肉
    Consumable POISONOUS_GHAST_ROAST = buildConsumable(createNetherEffect("mysterious_poison", 60 * 20));



    // 灵魂椒炒肉
    Consumable SOUL_PEPPER_STIR_FRY = buildConsumable(createNetherEffect("ghost", 60 * 20));



    // 炽足兽岩壳炒肉
    Consumable STRIDER_SHELL_STIR_FRY = buildConsumable(createNetherEffect("tropical_strider", 300 * 20));



    // 下界果切拼盘
    Consumable FRUIT_PLATTER = buildConsumable(createCookeryEffect("preservation", 90 * 20));



    // 火腿酸酪
    Consumable HAM_YOGURT = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 酸菜鱼
    Consumable SAUERKRAUT_FISH = buildConsumable(createCookeryEffect("vigor", 240 * 20));



    // 烈焰浓汤
    Consumable BLAZE_SOUP = buildConsumable(createNetherEffect("tropical_strider", 180 * 20));



    // 熔岩果冻
    Consumable LAVA_JELLY = buildConsumable(createNetherEffect("tropical_strider", 120 * 20));



    // 绯红沙拉
    Consumable CRIMSON_SALAD = buildConsumable(createNetherEffect("crimson", 90 * 20));



    // 绯红菌岩浆膏炖肉
    Consumable CRIMSON_MAGMA_STEW = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 诡异沙拉
    Consumable WARPED_SALAD = buildConsumable(createNetherEffect("warped", 90 * 20));



    // 灵魂炽足兽烤串
    Consumable SOUL_STRIDER_KABOB = buildConsumable(createNetherEffect("warped", 30 * 20));



    // 黄金烤串
    Consumable GOLDEN_KABOB = buildConsumable(createCookeryEffect("vigor", 60 * 20));



    // 烈焰烤串
    Consumable BLAZING_KABOB = buildConsumable(createNetherEffect("tropical_strider", 30 * 20));



    // 绯红烤串
    Consumable CRIMSON_KABOB = buildConsumable(createNetherEffect("crimson", 45 * 20));



    // 诡异烤串
    Consumable WARPED_KABOB = buildConsumable(createNetherEffect("warped", 45 * 20));



    // 星之恶魂意面
    Consumable STAR_GHAST_PASTA = buildConsumable(createNetherEffect("star_blessing", 600));



    // 星之炖肉
    Consumable STAR_STEW_MEAT = buildConsumable(createNetherEffect("star_blessing", 600));



    // 荧光浓汤
    Consumable GLOWING_SOUP = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 荧光布丁
    Consumable GLOWING_PUDDING = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 荧光烤串
    Consumable GLOWING_KABOB = buildConsumable(createCookeryEffect("satiated_shield", 45 * 20));



    // 荧光沙拉
    Consumable GLOWING_SALAD = buildConsumable(createCookeryEffect("satiated_shield", 90 * 20));



    // 黑苹果沙拉
    Consumable BLACK_APPLE_SALAD = buildConsumable(createCookeryEffect("preservation", 90 * 20));



    // 红宝石牛排
    Consumable RUBY_STEAK = buildConsumable(createCookeryEffect("satiated_shield", 240 * 20));



    // 下界芦苇炖菜
    Consumable NETHER_REED_STEW = buildConsumable(createCookeryEffect("warmth", 480 * 20));



    // 岩浆膏炒肉
    Consumable MAGMA_CREAM_STIR_FRY = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 岩浆膏炒肉盖饭
    Consumable MAGMA_CREAM_STIR_FRY_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 麻婆豆腐
    Consumable MAPO_TOFU = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 麻婆豆腐盖饭
    Consumable MAPO_TOFU_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 诡异蛋糕
    Consumable WARPED_CAKE = buildConsumable(createNetherEffect("warped", 60 * 20));



    // 重庆小面
    Consumable CHONGQING_NOODLES = buildConsumable(createCookeryEffect("warmth", 3600));



    // 螺蛳粉
    Consumable LUOSIFEN = buildConsumable(createCookeryEffect("warmth", 3600));



    // 灵魂炒肉
    Consumable SOUL_STIR_FRY_MEAT = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 灵魂炒肉盖饭
    Consumable SOUL_STIR_FRY_MEAT_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 焦糖下界猪儿虫
    Consumable CARAMEL_NETHER_CATERPILLAR = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 焦糖下界猪儿虫盖饭
    Consumable CARAMEL_NETHER_CATERPILLAR_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 生猪灵肉
    Consumable RAW_PIGLIN_MEAT = buildConsumable();



    // 熟猪灵肉
    Consumable COOKED_PIGLIN_MEAT = buildConsumable();



    // 诡异霉烂肉
    Consumable WARPED_HOGLIN_TENDERLOIN_STEW = buildConsumable(createCookeryEffect("flatulence", 35 * 20));



    // 麻辣疣猪兽拉面
    Consumable SPICY_HOGLIN_RAMEN = buildConsumable(createCookeryEffect("warmth", 180 * 20));



    // 麻辣香锅
    Consumable SPICY_POT = buildConsumable(createCookeryEffect("vigor", 90 * 20));



    // 麻辣香锅盖饭
    Consumable SPICY_POT_RICE = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 孟婆汤
    Consumable FORGETFULNESS_SOUP = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 红烧狮子头
    Consumable BRAISED_LION_HEAD_ITEM = buildConsumable(createCookeryEffect("warmth", 80 * 20));

    Consumable BRAISED_LION_HEAD_BLOCK = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 蒜蓉生蚝
    Consumable GARLIC_OYSTERS = buildConsumable(createVanillaEffect("water_breathing", 180 * 20));



    // 夫妻肺片
    Consumable COUPLES_LUNG_SLICE = buildConsumable(createCookeryEffect("warmth", 80 * 20));



    // 卤肉饭
    Consumable BRAISED_PORK_RICE_ITEM = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

    Consumable BRAISED_PORK_RICE_BLOCK = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 胡椒猪肚鸡汤
    Consumable PEPPER_PORK_BELLY_CHICKEN_SOUP = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));



    // 玉米胡萝卜排骨汤
    Consumable CORN_CARROT_PORK_RIB_SOUP_ITEM = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

    Consumable CORN_CARROT_PORK_RIB_SOUP_BLOCK = buildConsumable(createCookeryEffect("satiated_shield", 180 * 20));

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
        Holder<MobEffect> effect = switch (path) {
            case "vigor" -> ModEffects.VIGOR;
            case "vitality" -> ModEffects.VITALITY;
            case "hinder" -> ModEffects.HINDER;
            case "instant_smelting" -> ModEffects.INSTANT_SMELTING;
            case "warmth" -> ModEffects.WARMTH;
            case "mustard" -> ModEffects.MUSTARD;
            case "flatulence" -> ModEffects.FLATULENCE;
            case "satiated_shield" -> ModEffects.SATIATED_SHIELD;
            case "sulfur" -> ModEffects.SULFUR;
            case "tundra_strider" -> ModEffects.TUNDRA_STRIDER;
            case "preservation" -> ModEffects.PRESERVATION;
            case "projectile_dodge" -> ModEffects.PROJECTILE_DODGE;
            default -> null;
        };
        return createEffect("kaleidoscope_cookery", path, effect, duration, 1);
    }

    @Nullable
    private static MobEffectInstance createNetherEffect(String path, int duration) {
        Holder<MobEffect> effect = switch (path) {
            case "ghost" -> KNEffects.GHOST;
            case "crimson" -> KNEffects.CRIMSON;
            case "mysterious_poison" -> KNEffects.MYSTERIOUS_POISON;
            case "star_blessing" -> KNEffects.STAR_BLESSING;
            case "tropical_strider" -> KNEffects.TROPICAL_STRIDER;
            case "warped" -> KNEffects.WARPED;
            default -> null;
        };
        return createEffect("kaleidoscope_end", path, effect, duration, 1);
    }

    @Nullable
    private static MobEffectInstance createVanillaEffect(String path, int duration) {
        Holder<MobEffect> effect = switch (path) {
            case "absorption" -> MobEffects.ABSORPTION;
            case "nausea" -> MobEffects.NAUSEA;
            case "water_breathing" -> MobEffects.WATER_BREATHING;
            default -> null;
        };
        return createEffect("minecraft", path, effect, duration, 2);
    }

    @Nullable
    private static MobEffectInstance createEffect(String namespace, String path, @Nullable Holder<MobEffect> effect,
                                                  int duration, int amplifier) {
        if (effect == null) {
            Identifier id = Identifier.fromNamespaceAndPath(namespace, path);
            KaleidoscopeNether.LOGGER.warn("Food effect {} is not registered; this consumable will have no effect", id);
            return null;
        }
        return new MobEffectInstance(effect, duration, amplifier);
    }

    static void init() {
    }
}
