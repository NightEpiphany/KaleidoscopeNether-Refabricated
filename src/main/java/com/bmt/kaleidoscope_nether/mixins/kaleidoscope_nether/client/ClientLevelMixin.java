package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether.client;

import com.bmt.kaleidoscope_nether.api.event.EntityTickEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientLevel.class)
public class ClientLevelMixin {
    @WrapOperation(method = "tickNonPassenger", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;tick()V"))
    private void tickNonPassenger(Entity instance, Operation<Void> original) {
        EntityTickEvent.Pre pre = EntityTickEvent.Pre.fireEntityTickPre(instance);
        if (!pre.isCanceled()) {
            original.call(instance);
            EntityTickEvent.Post.fireEntityTickPost(instance);
        }
    }
}
