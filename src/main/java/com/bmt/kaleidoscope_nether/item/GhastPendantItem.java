package com.bmt.kaleidoscope_nether.item;

import com.bmt.kaleidoscope_nether.integration.CuriosIntegration;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class GhastPendantItem extends ArmorItem {
    private static final Holder<ArmorMaterial> GHAST_PENDANT_MATERIAL = ArmorMaterials.LEATHER;

    public GhastPendantItem() {
        super(GHAST_PENDANT_MATERIAL, Type.CHESTPLATE, new Properties().rarity(Rarity.UNCOMMON).stacksTo(1));
    }

    public static boolean isWearingGhastPendant(Player player) {
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        if (chestplate.getItem() instanceof GhastPendantItem) {
            return true;
        }
        return CuriosIntegration.hasItemInCurios(player, GhastPendantItem.class);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }
}
