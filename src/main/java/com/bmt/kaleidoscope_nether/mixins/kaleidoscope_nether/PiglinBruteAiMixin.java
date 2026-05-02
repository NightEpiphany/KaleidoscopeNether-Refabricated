package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.effect.WarpedEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinBruteAi;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PiglinBruteAi.class)
public abstract class PiglinBruteAiMixin {
    @Inject(
            method = "findNearestValidAttackTarget",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void onFindNearestValidAttackTarget(ServerLevel serverLevel, AbstractPiglin abstractPiglin, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {
        Optional<? extends LivingEntity> targetOptional = cir.getReturnValue();

        if (targetOptional.isPresent()) {
            LivingEntity target = targetOptional.get();

            if (target instanceof Player player) {
                if (WarpedEffect.shouldAffectMob(abstractPiglin, player)) {
                    cir.setReturnValue(Optional.empty());
                }
            }
        }
    }
}