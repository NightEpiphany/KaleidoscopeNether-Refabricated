package com.bmt.kaleidoscope_nether.worldgen;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.serialization.JsonOps;
import net.minecraft.SharedConstants;
import net.minecraft.server.Bootstrap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.OffsetPlacement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class WorldGenerationDataTest {
    @BeforeAll
    static void bootstrap() {
        SharedConstants.tryDetectVersion();
        Bootstrap.bootStrap();
    }

    @ParameterizedTest
    @CsvSource({"poisonous_fruit, -3, 3, 0", "twisting_cave_vines, 0, 0, 1", "weeping_cave_vines, 0, 0, -1"})
    void offsetDecodesAndPreservesDistribution(String name, int min, int max, int y) throws IOException {
        JsonObject placed = resource("placed_feature/" + name);
        JsonObject offset = placed.getAsJsonArray("placement").asList().stream()
                .map(element -> element.getAsJsonObject())
                .filter(element -> element.get("type").getAsString().equals("minecraft:offset"))
                .findFirst().orElseThrow();
        var decoded = OffsetPlacement.CODEC.codec().parse(JsonOps.INSTANCE, offset).getOrThrow();
        assertEquals(min, decoded.x().minInclusive());
        assertEquals(max, decoded.x().maxInclusive());
        assertEquals(min, decoded.z().minInclusive());
        assertEquals(max, decoded.z().maxInclusive());
        assertEquals(y, decoded.y().minInclusive());
        assertEquals(y, decoded.y().maxInclusive());
        var random = RandomSource.create(42L);
        for (int i = 0; i < 128; i++) {
            int x = decoded.x().sample(random);
            int z = decoded.z().sample(random);
            assertTrue(x >= min && x <= max);
            assertTrue(z >= min && z <= max);
            assertEquals(y, decoded.y().sample(random));
        }
    }

    @ParameterizedTest
    @CsvSource({"poisonous_fruit, minecraft:simple_block", "twisting_cave_vines, minecraft:block_column",
            "weeping_cave_vines, minecraft:block_column"})
    void placedFeatureResolvesPackResource(String name, String type) throws IOException {
        JsonObject placed = resource("placed_feature/" + name);
        assertEquals("kaleidoscope_nether:" + name, placed.get("feature").getAsString());
        JsonObject feature = resource("feature/" + name);
        assertEquals(type, feature.get("type").getAsString());
        assertFalse(feature.has("config"), "26.3 feature fields must be at the root");
    }

    private static JsonObject resource(String name) throws IOException {
        String path = "/data/kaleidoscope_nether/worldgen/" + name + ".json";
        try (var stream = WorldGenerationDataTest.class.getResourceAsStream(path)) {
            assertNotNull(stream, "Missing worldgen resource: " + path);
            try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                return JsonParser.parseReader(reader).getAsJsonObject();
            }
        }
    }
}
