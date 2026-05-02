package com.bmt.kaleidoscope_nether.entity;

import com.bmt.kaleidoscope_nether.init.KNItems;
import com.bmt.kaleidoscope_nether.init.KNEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class BlazeHeartProjectile extends ThrowableItemProjectile {

    public BlazeHeartProjectile(EntityType<? extends BlazeHeartProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public BlazeHeartProjectile(Level level, LivingEntity shooter) {
        super(KNEntities.BLAZE_HEART_PROJECTILE.get(), level);
    }

    public BlazeHeartProjectile(Level level, double x, double y, double z) {
        super(KNEntities.BLAZE_HEART_PROJECTILE.get(), level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return KNItems.BLAZE_HEART.get();
    }

    @Override
    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide()) {
            LivingEntity owner = this.getOwner() instanceof LivingEntity ? (LivingEntity) this.getOwner() : null;

            this.level().explode(
                    owner != null ? owner : this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    3.0F,
                    false,
                    Level.ExplosionInteraction.NONE
            );

            this.discard();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isNoGravity()) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, vec3.y - 0.03, vec3.z);
        }
    }
}