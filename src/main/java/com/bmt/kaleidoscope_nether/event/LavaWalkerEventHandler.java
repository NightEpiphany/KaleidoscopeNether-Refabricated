package com.bmt.kaleidoscope_nether.event;

import com.bmt.kaleidoscope_nether.api.event.EntityTickEvent;
import com.bmt.kaleidoscope_nether.init.KNEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

import static com.bmt.kaleidoscope_nether.init.KNEnchantments.LAVA_WALKER;

public class LavaWalkerEventHandler {
    public static void register() {
        KNEvents.ENTITY_POST.register(LavaWalkerEventHandler::onLivingTick);
    }

    public static void onLivingTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof LivingEntity entity))
            return;

        ItemStack boots = entity.getItemBySlot(EquipmentSlot.FEET);
        if (boots.isEmpty())
            return;

        int enchantmentLevel;
        try {
            enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(
                    entity.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LAVA_WALKER),
                    boots
            );
        } catch (Exception e) {
            return;
        }

        if (enchantmentLevel <= 0)
            return;

        if (entity.isShiftKeyDown())
            return;

        Vec3 pos = entity.position();
        Vec3 motion = entity.getDeltaMovement();
        boolean isMoving = motion.lengthSqr() > 0.0001;

        boolean inLava = entity.isInLava();
        boolean onLavaGround = entity.level().getBlockState(entity.getOnPos()).is(Blocks.LAVA) && entity.position().y - 0.9f <= entity.getOnPos().getY();
        if (onLavaGround || inLava) {
            entity.setNoGravity(true);
            entity.setPos(pos.x, pos.y + 0.15f, pos.z);
            if (motion.y < 0) {
                entity.setDeltaMovement(new Vec3(motion.x, 0, motion.z));
            }
        } else {
            entity.setNoGravity(false);
        }

        if ((inLava || onLavaGround) && isMoving && entity.level() instanceof ServerLevel level && entity.tickCount % 5 == 0) {
            level.sendParticles(
                    ParticleTypes.LAVA,
                    pos.x, pos.y + 0.1D, pos.z,
                    3,
                    0.2, 0.1, 0.2,
                    1.5
            );
        }
    }
}
