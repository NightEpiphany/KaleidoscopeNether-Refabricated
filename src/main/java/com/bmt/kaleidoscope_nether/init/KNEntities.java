package com.bmt.kaleidoscope_nether.init;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.entity.BlazeHeartProjectile;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public final class KNEntities {
    public static final Supplier<EntityType<BlazeHeartProjectile>> BLAZE_HEART_PROJECTILE = register(
            "blaze_heart_projectile",
            EntityType.Builder.<BlazeHeartProjectile>of(BlazeHeartProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, KaleidoscopeNether.id("blaze_heart_projectile")))
    );

    private static <T extends Entity> Supplier<EntityType<T>> register(String name, EntityType<T> entityType) {
        EntityType<T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, KaleidoscopeNether.id(name), entityType);
        return () -> registered;
    }

    public static void registerEntities() {

    }
}
