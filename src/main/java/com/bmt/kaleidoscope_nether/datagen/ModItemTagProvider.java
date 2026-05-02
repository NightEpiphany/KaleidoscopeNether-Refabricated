package com.bmt.kaleidoscope_nether.datagen;

import com.bmt.kaleidoscope_nether.api.KNTags;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        valueLookupBuilder(KNTags.Items.BLAZE_FOODS)
                .add(
                        KNItems.EVERLASTING_FLAME_STEAK.get(),
                        KNItems.BLAZE_SOUP.get()
                );
        valueLookupBuilder(KNTags.Items.MAGMA_CREAM_FOODS)
                .add(
                        KNItems.MAGMA_CREAM_SOUP.get(),
                        KNItems.MAGMA_CREAM_PUDDING.get()
                );

        valueLookupBuilder(KNTags.Items.SOUL_PEPPER_TRANSFORMABLE)
                .add(
                        ModItems.RED_CHILI,
                        ModItems.GREEN_CHILI
                );

        valueLookupBuilder(KNTags.Items.STAR_BLESSING_FOODS)
                .add(
                        KNItems.STAR_STEW.get(),
                        KNItems.STAR_GHAST_PASTA.get(),
                        KNItems.STAR_STEW_MEAT.get(),
                        KNItems.SOUL_RETURN_RICE.get()
                );

        valueLookupBuilder(KNTags.Items.WARPED_FOOD)
                .add(
                        KNItems.WARPED_FRUIT.get()
                );
    }
}
