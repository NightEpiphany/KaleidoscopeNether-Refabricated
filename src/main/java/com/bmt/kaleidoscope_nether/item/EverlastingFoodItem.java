package com.bmt.kaleidoscope_nether.item;

import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class EverlastingFoodItem extends FoodWithEffectsItem {
    private final Supplier<Integer> eatingCooldown;
    private final Supplier<Boolean> isEnabled;

    public EverlastingFoodItem(FoodProperties food, Supplier<Integer> eatingCooldown, Supplier<Boolean> isEnabled, Rarity rarity) {
        super(food);
        this.eatingCooldown = eatingCooldown;
        this.isEnabled = isEnabled;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.@NotNull TooltipContext context, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        tooltip.add(Component.translatable("item.kaleidoscope_nether.everlasting_flame_steak.tooltip.line1")
                .withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, @NotNull Level world, @NotNull LivingEntity entity) {
        if (stack.has(DataComponents.FOOD)) {
            entity.eat(world, stack.copy());
            addCooldown(entity, eatingCooldown.get());
        }
        return stack;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!isEnabled.get()) {
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        }
        return super.use(level, player, hand);
    }

    private void addCooldown(LivingEntity entity, int cooldown) {
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(this, cooldown);
        }
    }
}