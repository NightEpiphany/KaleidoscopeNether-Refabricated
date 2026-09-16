package com.bmt.kaleidoscope_nether.worldgen;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceKey;

public final class OptionalLootGameTest {
    @GameTest
    public void dollLootLoadsOnlyWhenItsItemExists(GameTestHelper helper) {
        var lootTables = helper.getLevel().getServer().reloadableRegistries().lookup()
                .lookupOrThrow(Registries.LOOT_TABLE);
        for (int index = 0; index < 9; index++) {
            boolean itemExists = BuiltInRegistries.ITEM.containsKey(KaleidoscopeNether.id("doll_" + index));
            var lootKey = ResourceKey.create(Registries.LOOT_TABLE,
                    KaleidoscopeNether.id("blocks/doll_" + index));
            helper.assertTrue(lootTables.get(lootKey).isPresent() == itemExists,
                    "Doll loot must load exactly when its item exists: " + lootKey.identifier());
        }
        helper.succeed();
    }
}
