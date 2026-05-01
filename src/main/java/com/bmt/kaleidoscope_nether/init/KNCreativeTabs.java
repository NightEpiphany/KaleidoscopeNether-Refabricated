package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class KNCreativeTabs {
    public static void registerTabs() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, KaleidoscopeNether.id("kaleidoscope_nether_tab"), FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.kaleidoscope_nether"))
                .icon(() -> new ItemStack(KNItems.BLOWGUN.get()))
.displayItems((parameters, output) -> {
                        output.accept(KNItems.PRIMITIVE_MACHETE.get());
                        output.accept(KNItems.GHAST_TENTACLE.get());
                        output.accept(KNItems.ROASTED_GHAST_TENTACLE.get());
                        output.accept(KNItems.HAM_SLICE.get());
                        output.accept(KNItems.HAM.get());
                        output.accept(KNItems.HOGLIN_HIDE.get());
                        output.accept(KNItems.NETHER_CATERPILLAR.get());
                        output.accept(KNItems.RAW_PIGLIN_MEAT.get());
                        output.accept(KNItems.COOKED_PIGLIN_MEAT.get());
                        output.accept(KNItems.RAW_STRIDER_MEAT.get());
                        output.accept(KNItems.COOKED_STRIDER_MEAT.get());
                        output.accept(KNItems.HOGLIN_TUSK.get());
                        output.accept(KNItems.STRIDER_ROCK_SHELL.get());
                        output.accept(KNItems.GILDED_FRAGMENT.get());
                        output.accept(KNItems.WITHER_RIB.get());
                        output.accept(KNItems.STAR_DUST.get());
                        output.accept(KNItems.BLAZE_HEART.get());
                        output.accept(KNItems.CRIMSON_FRUIT.get());
                        output.accept(KNItems.WARPED_FRUIT.get());
                        output.accept(KNItems.SOUL_PEPPER.get());
                        output.accept(KNItems.POISONOUS_FRUIT.get());
                        output.accept(KNItems.LAVA_ROASTED_CHICKEN.get());
                        output.accept(KNItems.ROUJIAMO.get());
                        output.accept(KNItems.SPICY_POT.get());
                        output.accept(KNItems.SPICY_POT_RICE.get());
                        output.accept(KNItems.MAPO_TOFU.get());
                        output.accept(KNItems.MAPO_TOFU_RICE.get());
                        output.accept(KNItems.MAGMA_CREAM_STIR_FRY.get());
                        output.accept(KNItems.MAGMA_CREAM_STIR_FRY_RICE.get());
                        output.accept(KNItems.SOUL_STIR_FRY_MEAT.get());
                        output.accept(KNItems.SOUL_STIR_FRY_MEAT_RICE.get());
                        output.accept(KNItems.CARAMEL_NETHER_CATERPILLAR.get());
                        output.accept(KNItems.CARAMEL_NETHER_CATERPILLAR_RICE.get());
                        output.accept(KNItems.STAR_STEW.get());
                        output.accept(KNItems.SOUL_SOUP.get());
                        output.accept(KNItems.BLAZE_SOUP.get());
                        output.accept(KNItems.MAGMA_CREAM_SOUP.get());
                        output.accept(KNItems.WITHER_BONE_SOUP.get());
                        output.accept(KNItems.POISONOUS_SOUP.get());
                        output.accept(KNItems.GLOWING_SOUP.get());
                        output.accept(KNItems.CHONGQING_NOODLES.get());
                        output.accept(KNItems.LUOSIFEN.get());
                        output.accept(KNItems.SPICY_HOGLIN_RAMEN.get());
                        output.accept(KNItems.SAUERKRAUT_FISH.get());
                        output.accept(KNItems.NETHER_REED_STEW.get());
                        output.accept(KNItems.SOUL_RETURN_RICE.get());
                        output.accept(KNItems.STRIDER_NETHER_WART_STEW.get());
                        output.accept(KNItems.WARPED_SALAD.get());
                        output.accept(KNItems.CRIMSON_SALAD.get());
                        output.accept(KNItems.BRAISED_STRIDER.get());
                        output.accept(KNItems.WARPED_HOGLIN_TENDERLOIN_STEW.get());
                        output.accept(KNItems.GHAST_PASTA.get());
                        output.accept(KNItems.STAR_GHAST_PASTA.get());
                        output.accept(KNItems.SOUL_GLAZED_ROAST.get());
                        output.accept(KNItems.MAGMA_CREAM_PUDDING.get());
                        output.accept(KNItems.GHAST_PUDDING.get());
                        output.accept(KNItems.GILDED_BARBARIC_ROAST.get());
                        output.accept(KNItems.CRIMSON_MAGMA_STEW.get());
                        output.accept(KNItems.STAR_STEW_MEAT.get());
                        output.accept(KNItems.WARPED_CAKE.get());
                        output.accept(KNItems.GOLDEN_ROAST.get());
                        output.accept(KNItems.GLOWING_PUDDING.get());
                        output.accept(KNItems.LAVA_JELLY.get());
                        output.accept(KNItems.NETHER_CATERPILLAR_SASHIMI.get());
                        output.accept(KNItems.NETHER_FRIES_PLATTER.get());
                        output.accept(KNItems.HOGLIN_TUSK_BRAISED_MEAT.get());
                        output.accept(KNItems.POISONOUS_GHAST_ROAST.get());
                        output.accept(KNItems.SOUL_PEPPER_STIR_FRY.get());
                        output.accept(KNItems.STRIDER_SHELL_STIR_FRY.get());
                        output.accept(KNItems.FRUIT_PLATTER.get());
                        output.accept(KNItems.HAM_YOGURT.get());
                        output.accept(KNItems.MAGMA_SWEET_AND_SOUR_PORK.get());
                        output.accept(KNItems.GIANT_BEAST_CROISSANT.get());

                        KNFoodBiteRegistry.forEach((resourceLocation, foodData) -> {
                            Item item = BuiltInRegistries.ITEM.get(resourceLocation);
                            if (item != Items.AIR) {
                                output.accept(item);
                            }
                        });

                        output.accept(KNItems.GLOWING_SALAD.get());
                        output.accept(KNItems.BLACK_APPLE_SALAD.get());
                        output.accept(KNItems.RUBY_STEAK.get());
                        output.accept(KNItems.GHAST_KABOB.get());
                        output.accept(KNItems.SOUL_STRIDER_KABOB.get());
                        output.accept(KNItems.GOLDEN_KABOB.get());
                        output.accept(KNItems.BLAZING_KABOB.get());
                        output.accept(KNItems.CRIMSON_KABOB.get());
                        output.accept(KNItems.WARPED_KABOB.get());
                        output.accept(KNItems.GLOWING_KABOB.get());
                        output.accept(KNItems.FORGETFULNESS_SOUP.get());
                        output.accept(KNItems.GARLIC_OYSTERS.get());
                        output.accept(KNItems.COUPLES_LUNG_SLICE.get());
                        output.accept(KNItems.PEPPER_PORK_BELLY_CHICKEN_SOUP.get());
                        output.accept(KNItems.NETHER_STOVE.get());
                    })

                    .build());
    }
}
