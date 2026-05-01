package com.bmt.kaleidoscope_nether.item;

import com.bmt.kaleidoscope_nether.init.KNSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class LavaRoastedChickenItem extends Item {
    public LavaRoastedChickenItem(FoodProperties food) {
        super(new Properties().food(food));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity entity) {
        if (!level.isClientSide() && entity instanceof Player player) {
            level.playSound(null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    KNSounds.LAVA_ROASTED_CHICKEN_EAT.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F);

            entity.igniteForSeconds(29.0F);
        }

        return super.finishUsingItem(stack, level, entity);
    }
}