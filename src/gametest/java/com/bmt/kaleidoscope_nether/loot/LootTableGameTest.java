package com.bmt.kaleidoscope_nether.loot;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;

import java.io.IOException;
import java.util.Set;

public final class LootTableGameTest {
    private static final Set<String> ENTITY_TABLES = Set.of(
            "blaze", "ghast", "hoglin", "magma_cube", "piglin", "piglin_brute",
            "strider", "wither", "wither_skeleton");

    @GameTest
    public void lootTablesDecodeAndLoad(GameTestHelper helper) throws IOException {
        var server = helper.getLevel().getServer();
        var registries = server.reloadableRegistries().lookup();
        var lootTables = registries.lookupOrThrow(Registries.LOOT_TABLE);
        var ops = RegistryOps.create(JsonOps.INSTANCE, registries);
        var resources = server.getResourceManager().listResources("loot_table", LootTableGameTest::isProjectTable);
        helper.assertTrue(resources.size() == 33, "Expected all 33 project loot table resources");
        for (var entry : resources.entrySet()) {
            var file = entry.getKey();
            String path = file.getPath().substring("loot_table/".length(), file.getPath().length() - ".json".length());
            var id = file.withPath(path);
            var key = ResourceKey.create(Registries.LOOT_TABLE, id);
            if (path.startsWith("blocks/doll_")
                    && !BuiltInRegistries.ITEM.containsKey(id.withPath(path.substring("blocks/".length())))) {
                helper.assertTrue(lootTables.get(key).isEmpty(), "Absent optional item must not load loot: " + id);
                continue;
            }
            try (var reader = entry.getValue().openAsReader()) {
                var decoded = LootTable.DIRECT_CODEC.parse(ops, JsonParser.parseReader(reader));
                helper.assertTrue(decoded.error().isEmpty(), "Cannot decode " + id + ": " + decoded.error());
                var table = decoded.getOrThrow();
                var problems = new ProblemReporter.Collector();
                table.validate(new ValidationContext(problems, table.getParamSet(), registries));
                helper.assertTrue(problems.isEmpty(), "Invalid loot table " + id + ": " + problems.getReport());
            }
            helper.assertTrue(lootTables.get(key).isPresent(), "Loot table was not loaded: " + id);
        }
        helper.succeed();
    }

    private static boolean isProjectTable(Identifier id) {
        String path = id.getPath();
        if (!path.endsWith(".json")) {
            return false;
        }
        if (id.getNamespace().equals(KaleidoscopeNether.MOD_ID)) {
            return true;
        }
        String prefix = "loot_table/entities/";
        return id.getNamespace().equals("minecraft") && path.startsWith(prefix)
                && ENTITY_TABLES.contains(path.substring(prefix.length(), path.length() - ".json".length()));
    }
}
