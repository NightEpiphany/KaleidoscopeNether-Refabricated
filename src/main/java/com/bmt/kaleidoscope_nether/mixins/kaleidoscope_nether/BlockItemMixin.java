package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.api.KNTags;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {
    @Inject(method = "getPlacementState", at = @At("RETURN"), cancellable = true)
    private void replaceState(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        if (context.getItemInHand().getItem() == ModItems.CHILI_SEED && context.getLevel().getBlockState(context.getClickedPos().below(1)).is(KNTags.Blocks.SOUL_SOIL_SAND)) {
            cir.setReturnValue(KNBlocks.SOUL_PEPPER.get().defaultBlockState());
        }
        if (context.getItemInHand().getItem() == KNItems.POISONOUS_FRUIT.get() && context.getLevel().getBlockState(context.getClickedPos().below(1)).is(KNTags.Blocks.SOUL_SOIL_SAND)) {
            cir.setReturnValue(KNBlocks.POISONOUS_FRUIT.get().defaultBlockState());
        }
    }
}
