package com.bmt.kaleidoscope_nether.block;

import java.util.Set;

import com.bmt.kaleidoscope_nether.api.KNTags;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SoulPepper extends KNCropBlockBase {
    public SoulPepper(Properties properties) {
        super(properties);
    }


    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(KNTags.Blocks.SOUL_SOIL_SAND);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 7 && randomSource.nextInt(10) == 0) {
            blockState = blockState.setValue(AGE, i + 1);
            serverLevel.setBlock(blockPos, blockState, 2);
        }
    }

    @Override
    public Set<Item> getHandHarvestExclude() {
        return Set.of(ModItems.CHILI_SEED);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(5) == 0) {
            spawnSoulParticles(level, blockPos);
        }
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        super.entityInside(blockState, level, blockPos, entity);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.CHILI_SEED;
    }


    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos blockpos = blockPos.below();
        return this.mayPlaceOn(levelReader.getBlockState(blockpos), levelReader, blockpos);
    }

    private static void spawnSoulParticles(Level level, BlockPos pos) {
        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;

        int particleCount = 1;

        for (int i = 0; i < particleCount; i++) {
            double offsetX = (level.random.nextDouble() - 0.5) * 0.8;
            double offsetY = level.random.nextDouble() * 0.5;
            double offsetZ = (level.random.nextDouble() - 0.5) * 0.8;

            double speedX = (level.random.nextDouble() - 0.5) * 0.02;
            double speedY = level.random.nextDouble() * 0.03 + 0.01;
            double speedZ = (level.random.nextDouble() - 0.5) * 0.02;

            level.addParticle(
                    ParticleTypes.SOUL,
                    x + offsetX,
                    y + offsetY,
                    z + offsetZ,
                    speedX, speedY, speedZ
            );
        }
    }
}
