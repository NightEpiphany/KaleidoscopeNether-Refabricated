package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.init.KNItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class ItemTabEventHandler {
    public static void register() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries ->
                entries.addAfter(Items.CROSSBOW, KNItems.BLOWGUN.get())
        );
    }
}
