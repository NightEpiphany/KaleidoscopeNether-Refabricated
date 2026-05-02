package com.bmt.kaleidoscope_nether.item;

import com.github.ysbbbbbb.kaleidoscopecookery.item.FoodWithEffectsItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

public class SoulReturnRiceItem extends FoodWithEffectsItem {
    public SoulReturnRiceItem(Item.Properties properties, FoodProperties food, Consumable consumable) {
        super(properties, food, consumable);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(@NonNull ItemStack stack, Item.@NonNull TooltipContext context, @NonNull TooltipDisplay tooltipDisplay, @NonNull Consumer<Component> consumer, @NonNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, consumer, flag);
        consumer.accept(Component.translatable("item.kaleidoscope_nether.soul_return_rice.tooltip.line1")
                .withStyle(ChatFormatting.GRAY));
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, net.minecraft.world.entity.@NotNull LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide() && entity instanceof ServerPlayer player) {
            Optional<GlobalPos> deathLocation = player.getLastDeathLocation();
            if (deathLocation.isPresent()) {
                GlobalPos globalPos = deathLocation.get();
                ServerLevel targetLevel = level.getServer() == null ? null : level.getServer().getLevel(globalPos.dimension());

                if (targetLevel != null) {
                    BlockPos pos = globalPos.pos();

                    player.teleportTo(targetLevel,
                            pos.getX() + 0.5,
                            pos.getY(),
                            pos.getZ() + 0.5,
                            Set.of(),
                            player.getYRot(),
                            player.getXRot(),
                            true);

                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                }
            }
        }
        return result;
    }
}
