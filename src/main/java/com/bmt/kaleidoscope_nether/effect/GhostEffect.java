package com.bmt.kaleidoscope_nether.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;

public class GhostEffect extends MobEffect {
    public GhostEffect(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean applyEffectTick(@NonNull ServerLevel serverLevel, @NonNull LivingEntity entity, int amplifier) {
        if (shouldWallClimb(entity)) {
            entity.fallDistance = 0.0F;

            Vec3 motion = entity.getDeltaMovement();
            final double horizontalLimit = 0.15D;
            final double climbSpeed = entity.isSuppressingSlidingDownLadder() ? 0.0D : 0.2D;

            entity.setDeltaMovement(
                    Mth.clamp(motion.x, -horizontalLimit, horizontalLimit),
                    Math.max(motion.y, climbSpeed),
                    Mth.clamp(motion.z, -horizontalLimit, horizontalLimit)
            );
            entity.hurtMarked = true;
            entity.setDiscardFriction(true);
        }

        spawnSoulParticles(serverLevel, entity, amplifier);
        return true;
    }

    private boolean shouldWallClimb(LivingEntity entity) {
        if (entity.onClimbable() || entity.isInWater() || entity.isInLava()) {
            return false;
        }
        return entity.horizontalCollision || entity.minorHorizontalCollision;
    }

    private void spawnSoulParticles(ServerLevel serverLevel, LivingEntity entity, int amplifier) {
        if (entity.tickCount % 10 == 0) {
            Vec3 pos = entity.position();
            int particleCount = 1 + amplifier;

            for (int i = 0; i < particleCount; i++) {
                double offsetX = (entity.getRandom().nextDouble() - 0.5) * entity.getBbWidth();
                double offsetY = entity.getRandom().nextDouble() * entity.getBbHeight();
                double offsetZ = (entity.getRandom().nextDouble() - 0.5) * entity.getBbWidth();

                double speedX = (entity.getRandom().nextDouble() - 0.5) * 0.01;
                double speedY = entity.getRandom().nextDouble() * 0.03 + 0.01;
                double speedZ = (entity.getRandom().nextDouble() - 0.5) * 0.01;

                serverLevel.sendParticles(
                        ParticleTypes.SOUL,
                        pos.x() + offsetX,
                        pos.y() + offsetY,
                        pos.z() + offsetZ,
                        1,
                        speedX, speedY, speedZ,
                        0.0
                );
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
