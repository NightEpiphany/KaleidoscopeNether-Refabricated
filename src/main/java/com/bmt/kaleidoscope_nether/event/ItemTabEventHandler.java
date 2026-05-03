package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.init.KNItems;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class ItemTabEventHandler {
    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(entries ->
                entries.insertAfter(Items.CROSSBOW, KNItems.BLOWGUN.get())
        );
    }
}
