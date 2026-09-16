package com.bmt.kaleidoscope_nether.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class KNAdvancementTrigger extends SimpleCriterionTrigger<KNAdvancementTrigger.Instance> {
    public void trigger(ServerPlayer serverPlayer, String id) {
        this.trigger(serverPlayer, (instance) -> instance.triggerId().equals(id));
    }

    @Override
    public @NotNull Codec<Instance> codec() {
        return Instance.CODEC;
    }

    public record Instance(Optional<Holder<LootItemCondition>> player, String triggerId)
        implements SimpleCriterionTrigger.SimpleInstance {

        public static final Codec<Instance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                LootItemCondition.CODEC.optionalFieldOf("player").forGetter(c -> c.player),
            Codec.STRING.fieldOf("triggerId").forGetter(Instance::triggerId)
        ).apply(instance, Instance::new));

        public static Instance id(String triggerId) {
            return new Instance(Optional.empty(), triggerId);
        }
    }
}
