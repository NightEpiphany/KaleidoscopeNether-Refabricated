package com.bmt.kaleidoscope_nether.integration;

import net.minecraft.world.entity.player.Player;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

class TrinketsIntegrationImpl {
    @SuppressWarnings("unchecked")
    static boolean hasItemInCurios(Player player, Class<?> itemClass) {
        try {
            Class<?> apiClass = Class.forName("dev.emi.trinkets.api.TrinketsApi");
            Method getComponent = apiClass.getMethod("getTrinketComponent", net.minecraft.world.entity.LivingEntity.class);
            Optional<?> componentOptional = (Optional<?>) getComponent.invoke(null, player);
            if (componentOptional.isEmpty()) {
                return false;
            }

            Object component = componentOptional.get();
            Method getInventory = component.getClass().getMethod("getInventory");
            Map<?, ?> inventory = (Map<?, ?>) getInventory.invoke(component);
            for (Object groupObj : inventory.values()) {
                if (!(groupObj instanceof Map<?, ?> group)) {
                    continue;
                }
                for (Object trinketInventory : group.values()) {
                    Method getContainerSize = trinketInventory.getClass().getMethod("getContainerSize");
                    Method getItem = trinketInventory.getClass().getMethod("getItem", int.class);
                    int size = (int) getContainerSize.invoke(trinketInventory);
                    for (int i = 0; i < size; i++) {
                        Object stackObj = getItem.invoke(trinketInventory, i);
                        if (stackObj instanceof net.minecraft.world.item.ItemStack stack && itemClass.isInstance(stack.getItem())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return false;
    }
}
