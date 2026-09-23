package com.bmt.kaleidoscope_nether.loot;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LootTableDataTest {
    @ParameterizedTest
    @ValueSource(strings = {"kaleidoscope_nether", "minecraft"})
    void lootTablesUseCurrentFields(String namespace) throws Exception {
        var directory = getClass().getResource("/data/" + namespace + "/loot_table");
        assertNotNull(directory);
        try (var paths = Files.walk(Path.of(directory.toURI()))) {
            var tables = paths.filter(path -> path.toString().endsWith(".json")).toList();
            assertFalse(tables.isEmpty());
            for (var path : tables) {
                try (var reader = Files.newBufferedReader(path)) {
                    assertCurrentFields(JsonParser.parseReader(reader), path.toString());
                }
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    void dollLoadConditionsKeepFabricFormat(int index) throws Exception {
        var table = resource("kaleidoscope_nether/loot_table/blocks/doll_" + index);
        var loadCondition = table.getAsJsonArray("fabric:load_conditions").get(0).getAsJsonObject();
        assertEquals("fabric:registry_contains", loadCondition.get("condition").getAsString());
        assertEquals("minecraft:item", loadCondition.get("registry").getAsString());
        assertEquals("kaleidoscope_nether:doll_" + index,
                loadCondition.getAsJsonArray("values").get(0).getAsString());
        assertFalse(loadCondition.has("type"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"blaze", "hoglin"})
    void lootingBonusStillRequiresChanceAndEnchantment(String entity) throws Exception {
        var pools = resource("minecraft/loot_table/entities/" + entity).getAsJsonArray("pools");
        for (int level = 1; level <= 3; level++) {
            var condition = pools.get(pools.size() - 4 + level).getAsJsonObject().getAsJsonObject("condition");
            assertEquals("minecraft:all_of", condition.get("type").getAsString());
            var terms = condition.getAsJsonArray("terms");
            assertEquals(2, terms.size());
            assertEquals("minecraft:random_chance", terms.get(0).getAsJsonObject().get("type").getAsString());
            assertEquals(0.2, terms.get(0).getAsJsonObject().get("chance").getAsDouble());
            var attacker = terms.get(1).getAsJsonObject();
            assertEquals("minecraft:entity_properties", attacker.get("type").getAsString());
            assertEquals("attacker", attacker.get("entity").getAsString());
            var enchantment = attacker.getAsJsonObject("predicate")
                    .getAsJsonObject("minecraft:equipment").getAsJsonObject("mainhand")
                    .getAsJsonObject("predicates").getAsJsonArray("minecraft:enchantments")
                    .get(0).getAsJsonObject();
            assertEquals("minecraft:looting", enchantment.get("enchantments").getAsString());
            assertEquals(level, enchantment.getAsJsonObject("levels").get("min").getAsInt());
        }
    }

    private static void assertCurrentFields(JsonElement element, String location) {
        if (element.isJsonArray()) {
            for (var child : element.getAsJsonArray()) {
                assertCurrentFields(child, location);
            }
        } else if (element.isJsonObject()) {
            var object = element.getAsJsonObject();
            for (String legacy : new String[]{"conditions", "functions", "function"}) {
                assertFalse(object.has(legacy), location + ": legacy field " + legacy);
            }
            if (object.has("condition")) {
                assertTrue(object.get("condition").isJsonObject(), location + ": condition must be an object");
                assertTrue(object.getAsJsonObject("condition").has("type"), location + ": missing condition type");
            }
            if (object.has("modifier")) {
                for (var modifier : object.getAsJsonArray("modifier")) {
                    assertTrue(modifier.getAsJsonObject().has("type"), location + ": missing modifier type");
                }
            }
            if (object.has("type")) {
                String type = object.get("type").getAsString();
                assertNotEquals("minecraft:block_state_property", type, location);
                if (type.equals("minecraft:match_block")) {
                    assertTrue(object.has("blocks"), location);
                    assertFalse(object.has("block") || object.has("properties"), location);
                } else if (type.equals("minecraft:entity_properties") && object.has("predicate")) {
                    var predicate = object.getAsJsonObject("predicate");
                    assertFalse(predicate.has("flags") || predicate.has("equipment"), location);
                } else if (type.equals("minecraft:match_tool") && object.has("predicate")) {
                    assertFalse(object.getAsJsonObject("predicate").has("enchantments"), location);
                } else if (type.equals("minecraft:set_damage") && object.get("damage").isJsonObject()) {
                    assertTrue(object.getAsJsonObject("damage").has("type"), location + ": missing number provider type");
                }
            }
            for (var entry : object.entrySet()) {
                if (!entry.getKey().equals("fabric:load_conditions")) {
                    assertCurrentFields(entry.getValue(), location + "/" + entry.getKey());
                }
            }
        }
    }

    private static JsonObject resource(String name) throws Exception {
        var url = LootTableDataTest.class.getResource("/data/" + name + ".json");
        assertNotNull(url);
        try (var reader = Files.newBufferedReader(Path.of(url.toURI()))) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        }
    }
}
