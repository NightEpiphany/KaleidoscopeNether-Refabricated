package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.api.event.AnvilUpdateEvent;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {

    @Shadow
    @Nullable
    private String itemName;

    public AnvilMenuMixin(@Nullable MenuType<?> menuType, int i, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(menuType, i, inventory, containerLevelAccess);
    }

    @Inject(method = "createResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 0, shift = At.Shift.BEFORE), cancellable = true)
    private void createResult(CallbackInfo ci, @Local ItemStack itemStack, @Local long j) {
        if (!itemStack.isEmpty()) {
            if (!onAnvilChange((AnvilMenu) (Object)this, itemStack, this.inputSlots.getItem(1), resultSlots, itemName, j, this.player)) {
                ci.cancel();
            }
        }
    }

    @Unique
    private static boolean onAnvilChange(AnvilMenu container, ItemStack left, ItemStack right, Container outputSlot, String name, long baseCost, Player player) {
        AnvilUpdateEvent e = new AnvilUpdateEvent(left, right, name, baseCost, player);
        KNEvents.UPDATE_ANVIL.invoker().onUpdate(e);
        if (e.isCanceled()) {
            outputSlot.setItem(0, ItemStack.EMPTY);
            container.cost.set((int) Mth.clamp(0L, 0L, 2147483647L));
            container.repairItemCountCost = 0;
            return false;
        } else if (e.getOutput().isEmpty()) {
            return true;
        } else {
            outputSlot.setItem(0, e.getOutput());
            container.cost.set((int) Mth.clamp(e.getCost(), 0L, 2147483647L));
            container.repairItemCountCost = e.getMaterialCost();
            return false;
        }
    }
}
