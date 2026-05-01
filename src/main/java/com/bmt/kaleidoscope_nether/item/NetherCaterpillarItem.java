package com.bmt.kaleidoscope_nether.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NetherCaterpillarItem extends Item {
    public NetherCaterpillarItem(FoodProperties food) {
        super(new Properties().food(food));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        tooltip.add(Component.translatable("item.kaleidoscope_nether.nether_caterpillar.tooltip.line1"));
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack stack, Player player, @NotNull LivingEntity target, @NotNull InteractionHand hand) {
        Level level = player.level();

        if (target instanceof Strider strider && strider.isBaby()) {
            if (!level.isClientSide()) {
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }

                strider.setAge(0);

                level.broadcastEntityEvent(strider, (byte) 18);

                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        return super.interactLivingEntity(stack, player, target, hand);
    }
}