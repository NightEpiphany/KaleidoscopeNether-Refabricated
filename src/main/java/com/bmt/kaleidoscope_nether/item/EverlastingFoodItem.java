package com.bmt.kaleidoscope_nether.item;

import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class EverlastingFoodItem extends FoodWithEffectsItem {
    private final Supplier<Integer> eatingCooldown;
    private final Supplier<Boolean> isEnabled;

    public EverlastingFoodItem(Item.Properties properties, FoodProperties food, Consumable consumable, Supplier<Integer> eatingCooldown, Supplier<Boolean> isEnabled, Rarity rarity) {
        super(properties.rarity(rarity), food, consumable);
        this.eatingCooldown = eatingCooldown;
        this.isEnabled = isEnabled;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NonNull ItemStack stack, Item.@NonNull TooltipContext context, @NonNull TooltipDisplay tooltipDisplay, @NonNull Consumer<Component> consumer, @NonNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, consumer, flag);
        consumer.accept(Component.translatable("item.kaleidoscope_nether.everlasting_flame_steak.tooltip.line1")
                .withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack stack, @NotNull Level world, @NotNull LivingEntity entity) {
        if (stack.has(DataComponents.FOOD)) {
            super.finishUsingItem(stack.copy(), world, entity);
            addCooldown(stack, entity, eatingCooldown.get());
        }
        return stack;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!isEnabled.get()) {
            return InteractionResult.PASS;
        }
        return super.use(level, player, hand);
    }

    private void addCooldown(ItemStack stack, LivingEntity entity, int cooldown) {
        if (entity instanceof Player player) {
            player.getCooldowns().addCooldown(stack, cooldown);
        }
    }
}
