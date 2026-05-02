package com.bmt.kaleidoscope_nether.block;

import com.bmt.kaleidoscope_nether.api.KNTags;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.bmt.kaleidoscope_nether.init.KNEffects;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;


public class PoisonousFruit extends KNCropBlockBase {
    public PoisonousFruit(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, @NonNull BlockGetter blockGetter, @NonNull BlockPos blockPos) {
        return blockState.is(KNTags.Blocks.SOUL_SOIL_SAND);
    }

    public void randomTick(BlockState blockState, @NonNull ServerLevel serverLevel, @NonNull BlockPos blockPos, @NonNull RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 7 && randomSource.nextInt(10) == 0) {
            blockState = blockState.setValue(AGE, i + 1);
            serverLevel.setBlock(blockPos, blockState, 2);
        }

    }

    @Override
    protected void entityInside(@NonNull BlockState blockState, @NonNull Level level, @NonNull BlockPos blockPos, @NonNull Entity entity, @NonNull InsideBlockEffectApplier insideBlockEffectApplier, boolean bl) {
        if (entity instanceof Player living) {
            if (!(living.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.FARMER_BOOTS &&
                    living.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.FARMER_LEGGINGS &&
                    living.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.FARMER_CHEST_PLATE)) {
                MobEffectInstance effect = living.getEffect(KNEffects.MYSTERIOUS_POISON);
                if (effect != null) {
                    if (effect.getDuration() <= 7 * 20) {
                        living.addEffect(new MobEffectInstance(KNEffects.MYSTERIOUS_POISON, 9 * 20, effect.getAmplifier() + 1));
                    }
                } else {
                    living.addEffect(new MobEffectInstance(KNEffects.MYSTERIOUS_POISON, 9 * 20));
                }
            }
        }
        super.entityInside(blockState, level, blockPos, entity, insideBlockEffectApplier, bl);
    }

    @Override
    protected @NonNull ItemLike getBaseSeedId() {
        return KNItems.POISONOUS_FRUIT.get();
    }


    @Override
    public boolean canSurvive(@NonNull BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        BlockState belowState = levelReader.getBlockState(blockpos);
        return this.mayPlaceOn(belowState, levelReader, blockpos);
    }
}
