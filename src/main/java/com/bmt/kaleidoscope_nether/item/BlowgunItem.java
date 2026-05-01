package com.bmt.kaleidoscope_nether.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class BlowgunItem extends ProjectileWeaponItem {
    public static final int MAX_DRAW_DURATION = 5;
    public static final float DEFAULT_POWER = 3.0F;

    public BlowgunItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    @Override
    protected void shootProjectile(
            @NotNull LivingEntity shooter,
            Projectile projectile,
            int index,
            float velocity,
            float inaccuracy,
            float angle,
            LivingEntity target
    ) {
        projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity shooter, int timeLeft) {
        if (shooter instanceof Player player) {
            ItemStack ammo = player.getProjectile(stack);
            if (!ammo.isEmpty()) {
                int used = this.getUseDuration(stack, shooter) - timeLeft;
                used = Math.min(used, MAX_DRAW_DURATION);

                float power = getPowerForTime(used);
                if (power >= 0.1F) {
                    if (level instanceof ServerLevel serverLevel) {
                        List<ItemStack> projectiles = draw(stack, ammo, player);
                        if (!projectiles.isEmpty()) {
                            this.shoot(serverLevel, player, player.getUsedItemHand(), stack, projectiles, power * DEFAULT_POWER, 1.0F, power == 1.0F, null);
                        }
                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS,
                            1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F);

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        boolean hasAmmo = !player.getProjectile(stack).isEmpty();

        if (!player.getAbilities().instabuild && !hasAmmo) {
            return InteractionResultHolder.fail(stack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(stack);
        }
    }

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 72000;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW;
    }

    private static float getPowerForTime(int useTime) {
        float power = (float)useTime / (float)MAX_DRAW_DURATION;
        if (power > 1.0F) {
            power = 1.0F;
        }
        return power;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return false;
    }
}