package com.bmt.kaleidoscope_nether.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class GhostEffect extends MobEffect {
    public GhostEffect(int color) {
        super(MobEffectCategory.BENEFICIAL, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            entity.fallDistance = 0.0F;

            final float velocity = 0.15F;

            Vec3 motion = entity.getDeltaMovement();

            double motionX = Mth.clamp(motion.x, -velocity, velocity);
            double motionY = 0.2;
            double motionZ = Mth.clamp(motion.z, -velocity, velocity);

            if (entity.isSuppressingSlidingDownLadder()) {
                motionY = 0.0;
            }

            entity.setDeltaMovement(motionX, motionY, motionZ);
        }

        spawnSoulParticles(entity, amplifier);
        return true;
    }

    private void spawnSoulParticles(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide() && entity.level() instanceof ServerLevel serverLevel) {
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
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}