package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.api.event.EntityTickEvent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {
    @WrapOperation(method = "tickNonPassenger", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;tick()V"))
    private void tickNonPassenger(Entity instance, Operation<Void> original) {
        EntityTickEvent.Pre pre = EntityTickEvent.Pre.fireEntityTickPre(instance);
        if (!pre.isCanceled()) {
            original.call(instance);
            EntityTickEvent.Post.fireEntityTickPost(instance);
        }
    }
}
