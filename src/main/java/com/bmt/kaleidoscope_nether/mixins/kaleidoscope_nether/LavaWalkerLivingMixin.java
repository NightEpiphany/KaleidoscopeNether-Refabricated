package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static com.bmt.kaleidoscope_nether.init.KNEnchantments.LAVA_WALKER;

@Mixin(Entity.class)
public class LavaWalkerLivingMixin {

    @ModifyVariable(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;collide(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"), argsOnly = true)
    public Vec3 lavaWalker$enableLavaWalking(Vec3 original) {
        if (!((Entity) (Object) this instanceof LivingEntity entity))
            return original;

        if (original.y > 0)
            return original;

        ItemStack boots = entity.getItemBySlot(EquipmentSlot.FEET);
        if (boots.isEmpty())
            return original;

        int enchantmentLevel;

        enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(
                entity.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LAVA_WALKER),
                boots
        );

        if (enchantmentLevel <= 0)
            return original;

        if (entity.isShiftKeyDown())
            return original;

        Level level = entity.level();

        int[][] offsets = {
                { 1, 0, 1 }, { 1, 0, 0 }, { 1, -1, 0 }, { 1, 0, -1 },
                { 0, 0, 1 }, { 0, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 },
                { -1, 0, 1 }, { -1, 0, 0 }, { -1, -1, 0 }, { -1, 0, -1 }
        };

        double highestLavaY = original.y;
        boolean foundLava = false;

        for (int[] offset : offsets) {
            BlockPos sourcePos = entity.blockPosition();
            BlockPos pos = new BlockPos(
                    sourcePos.getX() + offset[0],
                    sourcePos.getY() + offset[1],
                    sourcePos.getZ() + offset[2]);

            FluidState fluidState = level.getFluidState(pos);

            if (fluidState.isEmpty() || !fluidState.is(FluidTags.LAVA))
                continue;

            VoxelShape shape = Shapes.block().move(
                    pos.getX(),
                    pos.getY() + fluidState.getOwnHeight(),
                    pos.getZ());

            if (Shapes.joinIsNotEmpty(
                    shape,
                    Shapes.create(entity.getBoundingBox().inflate(0.5)),
                    BooleanOp.AND)) {
                double height = shape.max(Direction.Axis.Y) - entity.getY() - 1;

                if (highestLavaY < height) {
                    highestLavaY = height;
                    foundLava = true;
                }
            }
        }

        if (foundLava) {
            entity.fallDistance = 0F;
            entity.setOnGround(true);

            return new Vec3(original.x, highestLavaY, original.z);
        }
        return original;
    }
}
