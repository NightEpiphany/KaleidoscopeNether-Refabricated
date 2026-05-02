package com.bmt.kaleidoscope_nether.client;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.client.renderer.entity.BlazeHeartProjectileRenderer;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import com.bmt.kaleidoscope_nether.init.KNEntities;
import com.bmt.kaleidoscope_nether.init.KNFluids;
import com.bmt.kaleidoscope_nether.init.KNFoodBiteRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;

@Environment(EnvType.CLIENT)
public class ClientEvents {

    public static void register() {
        EntityRendererRegistry.register(KNEntities.BLAZE_HEART_PROJECTILE.get(), BlazeHeartProjectileRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.cutout(),
                KNBlocks.POISONOUS_FRUIT.get(),
                KNBlocks.SOUL_PEPPER.get(),
                KNBlocks.TWISTING_CAVE_VINES.get(),
                KNBlocks.TWISTING_CAVE_VINES_PLANT.get(),
                KNBlocks.WEEPING_CAVE_VINES.get(),
                KNBlocks.WEEPING_CAVE_VINES_PLANT.get()
        );

        KNFoodBiteRegistry.forEach((id, data) -> {
            var block = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(id);
            if (block != Blocks.AIR) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
            }
        });

        registerCrimsonJuiceRender(KNFluids.CRIMSON_JUICE, KNFluids.FLOWING_CRIMSON_JUICE);
        registerWarpedJuiceRender(KNFluids.WARPED_JUICE, KNFluids.FLOWING_WARPED_JUICE);
    }

    private static void registerCrimsonJuiceRender(Fluid still, Fluid flowing) {
        ResourceLocation stillTexture = ResourceLocation.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/crimson_juice_still");
        ResourceLocation flowTexture = ResourceLocation.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/crimson_juice_flow");
        FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(stillTexture, flowTexture, stillTexture, -1));
        registration(still, stillTexture, flowTexture);
        registration(flowing, stillTexture, flowTexture);
    }

    private static void registerWarpedJuiceRender(Fluid still, Fluid flowing) {
        ResourceLocation stillTexture = ResourceLocation.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/warped_juice_still");
        ResourceLocation flowTexture = ResourceLocation.fromNamespaceAndPath(KaleidoscopeNether.MOD_ID, "block/warped_juice_flow");
        FluidRenderHandlerRegistry.INSTANCE.register(still, flowing, new SimpleFluidRenderHandler(stillTexture, flowTexture, stillTexture, -1));
        registration(still, stillTexture, flowTexture);
        registration(flowing, stillTexture, flowTexture);
    }

    private static void registration(Fluid fluid, final ResourceLocation stillId, final ResourceLocation flowId) {
        FluidVariantRendering.register(fluid, new FluidVariantRenderHandler() {
            public TextureAtlasSprite[] getSprites(FluidVariant fluidVariant) {
                TextureAtlasSprite stillSprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(stillId);
                TextureAtlasSprite flowSprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(flowId);
                return new TextureAtlasSprite[]{stillSprite, flowSprite};
            }

            public int getColor(FluidVariant fluidVariant, BlockAndTintGetter view, BlockPos pos) {
                return -1;
            }
        });
    }
}
