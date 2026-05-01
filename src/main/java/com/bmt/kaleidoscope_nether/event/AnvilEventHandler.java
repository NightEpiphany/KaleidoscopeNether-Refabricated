package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.AnvilUpdateEvent;
import com.bmt.kaleidoscope_nether.init.KNEnchantments;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import com.bmt.kaleidoscope_nether.init.KNItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;

public class AnvilEventHandler {
    private static final String SHELL_COUNT_TAG = "StriderShellCount";
    private static final int REQUIRED_SHELLS = 1;
    public static void register() {
        KNEvents.UPDATE_ANVIL.register(AnvilEventHandler::onAnvilUpdate);
    }

    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (isBoots(left) && right.is(KNItems.STRIDER_ROCK_SHELL.get())) {
            ItemEnchantments enchantments = left.getEnchantments();
            if (enchantments.getLevel(event.getPlayer().level().registryAccess().lookupOrThrow(KNEnchantments.LAVA_WALKER.registryKey()).getOrThrow(KNEnchantments.LAVA_WALKER)) > 0) {
                return;
            }

            if (right.getCount() < REQUIRED_SHELLS) {
                return;
            }

            ItemStack result = left.copy();

            ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(result.getEnchantments());
            mutable.set(event.getPlayer().level().registryAccess().lookupOrThrow(KNEnchantments.LAVA_WALKER.registryKey()).getOrThrow(KNEnchantments.LAVA_WALKER), 1);
            result.set(DataComponents.ENCHANTMENTS, mutable.toImmutable());

            CompoundTag tag = left.getOrDefault(DataComponents.CUSTOM_DATA, net.minecraft.world.item.component.CustomData.EMPTY)
                    .copyTag();
            if (tag.contains(SHELL_COUNT_TAG)) {
                tag.remove(SHELL_COUNT_TAG);
            }

            if (!tag.isEmpty()) {
                result.set(DataComponents.CUSTOM_DATA, net.minecraft.world.item.component.CustomData.of(tag));
            }

            event.setOutput(result);
            event.setCost(REQUIRED_SHELLS);
            event.setMaterialCost(REQUIRED_SHELLS);
        }
    }

    private static boolean isBoots(ItemStack stack) {
        if (stack.isEmpty()) return false;

        if (stack.getItem() instanceof net.minecraft.world.item.ArmorItem armorItem) {
            return armorItem.getEquipmentSlot() == EquipmentSlot.FEET;
        }
        return false;
    }
}
