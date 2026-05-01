package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PiglinAi.class)
public abstract class PiglinAiMixin {
    @Inject(
            method = "findNearestValidAttackTarget(Lnet/minecraft/world/entity/monster/piglin/Piglin;)Ljava/util/Optional;",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void onFindNearestValidAttackTarget(Piglin piglin, CallbackInfoReturnable<Optional<LivingEntity>> cir) {
        Optional<LivingEntity> targetOptional = cir.getReturnValue();

        if (targetOptional.isPresent()) {
            LivingEntity target = targetOptional.get();

            if (target instanceof Player player) {
                if (WarpedEffect.shouldAffectMob(piglin, player)) {
                    cir.setReturnValue(Optional.empty());
                }
            }
        }
    }
}