package com.bmt.kaleidoscope_nether.datagen;

import com.bmt.kaleidoscope_nether.api.KNTags;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture1, CompletableFuture<TagLookup<Block>> completableFuture2) {
        super(packOutput, completableFuture1, completableFuture2);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(KNTags.Items.BLAZE_FOODS)
                .add(
                        KNItems.EVERLASTING_FLAME_STEAK.get(),
                        KNItems.BLAZE_SOUP.get()
                );
        tag(KNTags.Items.MAGMA_CREAM_FOODS)
                .add(
                        KNItems.MAGMA_CREAM_SOUP.get(),
                        KNItems.MAGMA_CREAM_PUDDING.get()
                );

        tag(KNTags.Items.SOUL_PEPPER_TRANSFORMABLE)
                .add(
                        ModItems.RED_CHILI,
                        ModItems.GREEN_CHILI
                );

        tag(KNTags.Items.STAR_BLESSING_FOODS)
                .add(
                        KNItems.STAR_STEW.get(),
                        KNItems.STAR_GHAST_PASTA.get(),
                        KNItems.STAR_STEW_MEAT.get(),
                        KNItems.SOUL_RETURN_RICE.get()
                );

        tag(KNTags.Items.WARPED_FOOD)
                .add(
                        KNItems.WARPED_FRUIT.get()
                );
    }
}
