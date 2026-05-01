package com.bmt.kaleidoscope_nether.client;

import com.bmt.kaleidoscope_nether.client.renderer.entity.BlazeHeartProjectileRenderer;
import com.bmt.kaleidoscope_nether.init.KNEntities;
import com.bmt.kaleidoscope_nether.init.KNFoodBiteRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;

@Environment(EnvType.CLIENT)
public class ClientEvents {

    public static void register() {
        EntityRendererRegistry.register(KNEntities.BLAZE_HEART_PROJECTILE.get(), BlazeHeartProjectileRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(
                RenderType.cutout(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.POISONOUS_FRUIT.get(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.SOUL_PEPPER.get(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.TWISTING_CAVE_VINES.get(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.TWISTING_CAVE_VINES_PLANT.get(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.WEEPING_CAVE_VINES.get(),
                com.bmt.kaleidoscope_nether.init.KNBlocks.WEEPING_CAVE_VINES_PLANT.get()
        );

        KNFoodBiteRegistry.forEach((id, data) -> {
            var block = net.minecraft.core.registries.BuiltInRegistries.BLOCK.get(id);
            if (block != Blocks.AIR) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
            }
        });
    }
}
