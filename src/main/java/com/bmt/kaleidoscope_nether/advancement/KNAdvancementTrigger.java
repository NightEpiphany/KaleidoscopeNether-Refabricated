package com.bmt.kaleidoscope_nether.advancement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
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

    public record Instance(Optional<ContextAwarePredicate> player, String triggerId)
        implements SimpleCriterionTrigger.SimpleInstance {

        public static final Codec<Instance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ContextAwarePredicate.CODEC.optionalFieldOf("player").forGetter(Instance::player),
            Codec.STRING.fieldOf("triggerId").forGetter(Instance::triggerId)
        ).apply(instance, Instance::new));

        public static Instance id(String triggerId) {
            return new Instance(Optional.empty(), triggerId);
        }
    }
}
