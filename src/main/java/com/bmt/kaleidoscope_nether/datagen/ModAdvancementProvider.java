package com.bmt.kaleidoscope_nether.datagen;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import net.minecraft.data.advancements.AdvancementProvider;
import org.jetbrains.annotations.NotNull;

import com.google.gson.JsonObject;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

public class ModAdvancementProvider extends AdvancementProvider {
    private final PackOutput.PathProvider pathProvider;

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of());
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "advancements");
    }

    public static BiConsumer<JsonObject, ResourceLocation> BUILD_CONDITION;

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cachedOutput) {
        List<CompletableFuture<?>> list = new ArrayList<>();
        BUILD_CONDITION = (jsonObject, resourceLocation) -> {
            Path path = this.pathProvider.json(resourceLocation);
            list.add(DataProvider.saveStable(cachedOutput, jsonObject, path));
        };
        return CompletableFuture.allOf(super.run(cachedOutput), CompletableFuture.allOf(list.toArray(CompletableFuture[]::new)));
    }
}
