package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WitherBoss.class)
public abstract class WitherBossMixin {
    @Inject(
            method = "getAlternativeTarget(I)I",
            at = @At("RETURN"),
            cancellable = true
    )
    private void onGetAlternativeTarget(int head, CallbackInfoReturnable<Integer> cir) {
        int entityId = cir.getReturnValue();

        if (entityId > 0) {
            WitherBoss self = (WitherBoss) (Object) this;
            LivingEntity target = self.level().getEntity(entityId) instanceof LivingEntity living ? living : null;

            if (target instanceof Player player) {
                if (WarpedEffect.shouldAffectMob(self, player)) {
                    cir.setReturnValue(0);
                }
            }
        }
    }

    @Inject(
            method = "setAlternativeTarget(II)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onSetAlternativeTarget(int targetOffset, int newId, CallbackInfo ci) {
        if (newId > 0) {
            WitherBoss self = (WitherBoss) (Object) this;
            LivingEntity target = self.level().getEntity(newId) instanceof LivingEntity living ? living : null;

            if (target instanceof Player player) {
                if (WarpedEffect.shouldAffectMob(self, player)) {
                    ci.cancel();
                }
            }
        }
    }

    @Inject(
            method = "customServerAiStep()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/boss/wither/WitherBoss;getTarget()Lnet/minecraft/world/entity/LivingEntity;",
                    shift = At.Shift.AFTER
            )
    )
    private void onCustomServerAiStep(CallbackInfo ci) {
        WitherBoss self = (WitherBoss) (Object) this;
        LivingEntity mainTarget = self.getTarget();

        if (mainTarget instanceof Player player) {
            if (WarpedEffect.shouldAffectMob(self, player)) {
                self.setTarget(null);
            }
        }
    }
}