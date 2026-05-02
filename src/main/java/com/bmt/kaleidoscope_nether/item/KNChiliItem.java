package com.bmt.kaleidoscope_nether.item;

import com.github.ysbbbbbb.kaleidoscopecookery.init.ModFoods;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class KNChiliItem extends Item {
    private final int damage;

    public KNChiliItem(Item.Properties p, int damage) {
        super(p.food(ModFoods.CHILI));
        this.damage = damage;
    }

    public @NonNull ItemStack finishUsingItem(@NonNull ItemStack stack, Level level, LivingEntity entity) {
        entity.hurt(level.damageSources().magic(), (float)this.damage);
        return super.finishUsingItem(stack, level, entity);
    }
}
