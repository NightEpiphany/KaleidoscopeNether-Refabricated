package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import com.bmt.kaleidoscope_nether.item.GhastPendantItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import org.jetbrains.annotations.Nullable;

@Mixin(Mob.class)
public abstract class MobMixin {

    @Inject(
            method = "getTarget()Lnet/minecraft/world/entity/LivingEntity;",
            at = @At("RETURN"),
            cancellable = true
    )
    private void onGetTarget(CallbackInfoReturnable<LivingEntity> cir) {
        @Nullable LivingEntity target = cir.getReturnValue();

        if (target instanceof Player player) {
            Mob self = (Mob) (Object) this;

            if (self instanceof Ghast) {
                if (GhastPendantItem.isWearingGhastPendant(player)) {
                    cir.setReturnValue(null);
                    return;
                }
            }

            if (WarpedEffect.isAffectedMob(self)) {
                if (WarpedEffect.shouldAffectMob(self, player)) {
                    cir.setReturnValue(null);
                }
            }
        }
    }

    @Inject(
            method = "setTarget(Lnet/minecraft/world/entity/LivingEntity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onSetTarget(LivingEntity target, CallbackInfo ci) {
        if (target instanceof Player player) {
            Mob self = (Mob) (Object) this;

            if (self instanceof Ghast) {
                if (GhastPendantItem.isWearingGhastPendant(player)) {
                    ci.cancel();
                    return;
                }
            }

            if (WarpedEffect.isAffectedMob(self)) {
                if (WarpedEffect.shouldAffectMob(self, player)) {
                    ci.cancel();
                }
            }
        }
    }
}