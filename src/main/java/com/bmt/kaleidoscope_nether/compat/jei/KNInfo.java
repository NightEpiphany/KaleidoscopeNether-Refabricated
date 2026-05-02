package com.bmt.kaleidoscope_nether.compat.jei;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.init.KNItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class KNInfo implements IModPlugin {

    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        addAllMaterialInfo(registration);
    }

    private void addAllMaterialInfo(IRecipeRegistration registration) {
        registration.addIngredientInfo(
                new ItemStack(KNItems.GHAST_HIDE.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.ghast_hide.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.HOGLIN_TUSK.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.hoglin_tusk.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.STRIDER_ROCK_SHELL.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.strider_rock_shell.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.GILDED_FRAGMENT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.gilded_fragment.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.WITHER_RIB.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.wither_rib.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.STAR_DUST.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.star_dust.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.BLAZE_HEART.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.blaze_heart.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.HOGLIN_HIDE.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.hoglin_hide.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.RAW_STRIDER_MEAT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.raw_strider_meat.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.HAM.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.ham.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.GHAST_TENTACLE.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.ghast_tentacle.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.RAW_PIGLIN_MEAT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.raw_piglin_meat.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.CRIMSON_FRUIT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.crimson_fruit.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.WARPED_FRUIT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.warped_fruit.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.POISONOUS_FRUIT.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.poisonous_fruit.description")
        );
        registration.addIngredientInfo(
                new ItemStack(KNItems.SOUL_PEPPER.get()),
                VanillaTypes.ITEM_STACK,
                Component.translatable("item.kaleidoscope_nether.soul_pepper.description")
        );
    }
}