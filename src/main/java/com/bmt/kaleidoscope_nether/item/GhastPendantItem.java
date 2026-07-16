package com.bmt.kaleidoscope_nether.item;

import com.bmt.kaleidoscope_nether.integration.TrinketsIntegration;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

public class GhastPendantItem extends Item {
    public GhastPendantItem(Properties properties) {
        super(properties
                .rarity(Rarity.UNCOMMON)
                .stacksTo(1)
                .humanoidArmor(ArmorMaterials.LEATHER, ArmorType.CHESTPLATE));
    }

    public static boolean isWearingGhastPendant(Player player) {
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        if (chestplate.getItem() instanceof GhastPendantItem) {
            return true;
        }
        return TrinketsIntegration.hasItemInCurios(player, GhastPendantItem.class);
    }
}
