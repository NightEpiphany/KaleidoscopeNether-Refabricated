package com.bmt.kaleidoscope_nether.client;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import com.bmt.kaleidoscope_nether.init.KNEntities;
import com.bmt.kaleidoscope_nether.init.KNFluids;
import com.bmt.kaleidoscope_nether.init.KNFoodBiteRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import org.jspecify.annotations.NonNull;

@Environment(EnvType.CLIENT)
public class ClientEvents {

    public static void register() {
        EntityRenderers.register(KNEntities.BLAZE_HEART_PROJECTILE.get(), ThrownItemRenderer::new);

        BlockRenderLayerMap.putBlocks(
                ChunkSectionLayer.CUTOUT,
                KNBlocks.POISONOUS_FRUIT.get(),
                KNBlocks.SOUL_PEPPER.get(),
                KNBlocks.TWISTING_CAVE_VINES.get(),
                KNBlocks.TWISTING_CAVE_VINES_PLANT.get(),
                KNBlocks.WEEPING_CAVE_VINES.get(),
                KNBlocks.WEEPING_CAVE_VINES_PLANT.get()
        );

        KNFoodBiteRegistry.forEach((id, data) -> {
            var block = BuiltInRegistries.BLOCK.getValue(id);
            if (block != Blocks.AIR) {
                BlockRenderLayerMap.putBlock(block, ChunkSectionLayer.CUTOUT);
            }
        });

        registerCrimsonJuiceRender(KNFluids.CRIMSON_JUICE, KNFluids.FLOWING_CRIMSON_JUICE);
        registerWarpedJuiceRender(KNFluids.WARPED_JUICE, KNFluids.FLOWING_WARPED_JUICE);
    }

    private static void registerCrimsonJuiceRender(Fluid still, Fluid flowing) {
        Identifier stillTexture = Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/crimson_juice_still");
        Identifier flowTexture = Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/crimson_juice_flow");
        FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(stillTexture, flowTexture, stillTexture, -1));
        registration(still, stillTexture, flowTexture);
        registration(flowing, stillTexture, flowTexture);
    }

    private static void registerWarpedJuiceRender(Fluid still, Fluid flowing) {
        Identifier stillTexture = Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/warped_juice_still");
        Identifier flowTexture = Identifier.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/warped_juice_flow");
        FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(stillTexture, flowTexture, stillTexture, -1));
        registration(still, stillTexture, flowTexture);
        registration(flowing, stillTexture, flowTexture);
    }

    @SuppressWarnings("deprecation")
    private static void registration(Fluid fluid, final Identifier stillId, final Identifier flowId) {
        FluidVariantRendering.register(fluid, new FluidVariantRenderHandler() {
            public TextureAtlasSprite @NonNull [] getSprites(@NonNull FluidVariant fluidVariant) {
                TextureAtlas atlas = (TextureAtlas) Minecraft.getInstance().getTextureManager().getTexture(TextureAtlas.LOCATION_BLOCKS);
                TextureAtlasSprite stillSprite = atlas.getSprite(stillId);
                TextureAtlasSprite flowSprite = atlas.getSprite(flowId);
                return new TextureAtlasSprite[]{stillSprite, flowSprite};
            }

            public int getColor(@NonNull FluidVariant fluidVariant, BlockAndTintGetter view, BlockPos pos) {
                return -1;
            }
        });
    }
}
