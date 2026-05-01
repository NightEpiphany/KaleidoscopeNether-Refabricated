package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = FoodProperties.Builder.class, priority = 100)
public class MobEffectInstanceMixin {
   @WrapMethod(method = "effect")
    public FoodProperties.Builder effect(MobEffectInstance mobEffectInstance, float f, Operation<FoodProperties.Builder> original) {
       if (mobEffectInstance == null) {
           return (FoodProperties.Builder) (Object) this;
       }
       if (mobEffectInstance.getEffect() == null) {
           return (FoodProperties.Builder) (Object) this;
       }
       return original.call(mobEffectInstance, f);
   }
}
