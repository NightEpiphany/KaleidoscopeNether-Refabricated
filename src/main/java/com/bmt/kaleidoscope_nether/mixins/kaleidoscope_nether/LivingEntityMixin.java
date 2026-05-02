package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.api.event.LivingDamageModifyEvent;
import com.bmt.kaleidoscope_nether.api.event.LivingIncomingDamageEvent;
import com.bmt.kaleidoscope_nether.api.event.MobEffectAddedEvent;
import com.bmt.kaleidoscope_nether.effect.CrimsonEffect;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hurtServer", at = @At("HEAD"), cancellable = true)
    private void onIncomingDamage(ServerLevel serverLevel, DamageSource damageSource, float damage, CallbackInfoReturnable<Boolean> cir) {
        LivingIncomingDamageEvent event = new LivingIncomingDamageEvent((LivingEntity) (Object) this, damageSource, damage);
        KNEvents.LIVING_INCOMING_DAMAGE.invoker().onIncomingDamage(event);
        if (event.isCanceled()) {
            cir.setReturnValue(false);
        }
    }

    @ModifyVariable(method = "hurtServer", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private float modifyDamage(float damage, ServerLevel serverLevel, DamageSource damageSource) {
        LivingDamageModifyEvent event = new LivingDamageModifyEvent((LivingEntity) (Object) this, damageSource, damage);
        KNEvents.MODIFY_LIVING_DAMAGE.invoker().onModify(event);
        return event.getNewDamage();
    }

    @Inject(method = "addEffect(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;onEffectAdded(Lnet/minecraft/world/effect/MobEffectInstance;Lnet/minecraft/world/entity/Entity;)V", shift = At.Shift.AFTER))
    private void onEffectAdded(MobEffectInstance effectInstance, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        KNEvents.MOB_EFFECT_ADDED.invoker().onAdded(new MobEffectAddedEvent((LivingEntity) (Object) this, effectInstance, source));
    }


    @Inject(method = "getDamageAfterArmorAbsorb", at = @At("HEAD"), cancellable = true)
    private void onGetDamageAfterArmorAbsorb(DamageSource damageSource, float damage, CallbackInfoReturnable<Float> cir) {
        LivingEntity target = (LivingEntity) (Object) this;

        if (damageSource.getEntity() instanceof LivingEntity attacker && attacker.hasEffect(KNEffects.CRIMSON)) {
            float effectiveArmor = CrimsonEffect.calculateArmorPenetration(attacker, target);
            float armorDamageReduction = effectiveArmor * 0.04f;
            float totalDamageReduction = armorDamageReduction * damage;
            float finalDamage = damage - totalDamageReduction;
            cir.setReturnValue(finalDamage);
        }
    }
}
