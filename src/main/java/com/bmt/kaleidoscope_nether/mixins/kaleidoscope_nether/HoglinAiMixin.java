package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.hoglin.HoglinAi;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(HoglinAi.class)
public abstract class HoglinAiMixin {

    @Inject(
            method = "findNearestValidAttackTarget(Lnet/minecraft/world/entity/monster/hoglin/Hoglin;)Ljava/util/Optional;",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void onFindNearestValidAttackTarget(Hoglin hoglin, CallbackInfoReturnable<Optional<LivingEntity>> cir) {
        Optional<LivingEntity> targetOptional = cir.getReturnValue();

        if (targetOptional.isPresent()) {
            LivingEntity target = targetOptional.get();

            if (target instanceof Player player) {
                if (WarpedEffect.shouldAffectMob(hoglin, player)) {
                    cir.setReturnValue(Optional.empty());
                }
            }
        }
    }

    @Inject(
            method = "wasHurtBy(Lnet/minecraft/world/entity/monster/hoglin/Hoglin;Lnet/minecraft/world/entity/LivingEntity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onWasHurtBy(Hoglin hoglin, LivingEntity attacker, CallbackInfo ci) {
        if (attacker instanceof Player player) {
            if (WarpedEffect.shouldAffectMob(hoglin, player)) {
                ci.cancel();
            }
        }
    }

    @Inject(
            method = "setAttackTarget(Lnet/minecraft/world/entity/monster/hoglin/Hoglin;Lnet/minecraft/world/entity/LivingEntity;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void onSetAttackTarget(Hoglin hoglin, LivingEntity target, CallbackInfo ci) {
        if (target instanceof Player player) {
            if (WarpedEffect.shouldAffectMob(hoglin, player)) {
                ci.cancel();
            }
        }
    }
}