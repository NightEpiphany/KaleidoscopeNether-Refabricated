package com.bmt.kaleidoscope_nether.client;

import com.bmt.kaleidoscope_nether.init.KNEntities;
import com.bmt.kaleidoscope_nether.init.KNFluids;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderingRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRenderHandler;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.material.Fluid;
import org.jspecify.annotations.NonNull;

import static com.bmt.kaleidoscope_nether.KaleidoscopeNether.id;

@Environment(EnvType.CLIENT)
public class ClientEvents {

    public static void register() {
        EntityRenderers.register(KNEntities.BLAZE_HEART_PROJECTILE.get(), ThrownItemRenderer::new);

        registerCrimsonJuiceRender(KNFluids.CRIMSON_JUICE, KNFluids.FLOWING_CRIMSON_JUICE);
        registerWarpedJuiceRender(KNFluids.WARPED_JUICE, KNFluids.FLOWING_WARPED_JUICE);
    }

    private static void registerCrimsonJuiceRender(Fluid still, Fluid flowing) {
        registerRender(still, flowing, "block/crimson_juice_still", "block/crimson_juice_flow", 0xFFEB5E5E);
    }

    private static void registerWarpedJuiceRender(Fluid still, Fluid flowing) {
        registerRender(still, flowing, "block/warped_juice_still", "block/warped_juice_flow", 0xFFEB5E5E);
    }

    @Environment(EnvType.CLIENT)
    private static void registerRender(Fluid still, Fluid flowing, String stillTexture, String flowTexture, int color) {
        Identifier stillId = id(stillTexture);
        Identifier flowId = id(flowTexture);
        Material stillMaterial = new Material(stillId);
        Material flowMaterial = new Material(flowId);
        FluidRenderingRegistry.register(still, flowing, new FluidModel.Unbaked(stillMaterial, flowMaterial, null, null), FluidRenderingRegistry.get(still));
        registration(still, color);
        registration(flowing, color);
    }

    @Environment(EnvType.CLIENT)
    private static void registration(Fluid fluid, int color) {
        FluidVariantRendering.register(fluid, new FluidVariantRenderHandler() {
            @Override
            public int getColor(@NonNull FluidVariant fluidVariant, BlockAndTintGetter view, BlockPos pos) {
                return color;
            }
        });
    }
}
