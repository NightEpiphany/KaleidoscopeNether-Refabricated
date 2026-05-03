package com.bmt.kaleidoscope_nether.block;

import com.bmt.kaleidoscope_nether.init.KNBlocks;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class TwistingCaveVinesHead extends GrowingPlantHeadBlock implements BonemealableBlock {

    public static final MapCodec<TwistingCaveVinesHead> CODEC = simpleCodec(TwistingCaveVinesHead::new);

    public static final BooleanProperty BERRIES = BlockStateProperties.BERRIES;

    @Override
    protected @NotNull MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public TwistingCaveVinesHead(Properties properties) {
        super(properties, Direction.UP, SHAPE, true, 0.1D);
        this.registerDefaultState(this.stateDefinition.any().setValue(BERRIES, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BERRIES);
    }

    @Override
    protected @NotNull GrowingPlantBodyBlock getBodyBlock() {
        return KNBlocks.TWISTING_CAVE_VINES_PLANT.get();
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(@NonNull RandomSource random) {
        return 0;
    }

    @Override
    protected boolean canGrowInto(BlockState state) {
        return state.isAir();
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState state, @NonNull Level level, @NonNull BlockPos pos, @NonNull Player player, @NonNull BlockHitResult hit) {
        if (state.getValue(BERRIES)) {
            Block.popResource(level, pos, new ItemStack(KNItems.WARPED_FRUIT.get(), 1));
            float f = Mth.randomBetween(level.getRandom(), 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState newState = state.setValue(BERRIES, Boolean.FALSE);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    }

    @Override
    public boolean isValidBonemealTarget(@NonNull LevelReader level, @NonNull BlockPos pos, @NonNull BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NonNull Level level, @NonNull RandomSource random, @NonNull BlockPos pos, @NonNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(@NonNull ServerLevel level, @NonNull RandomSource random, @NonNull BlockPos pos, BlockState state) {
        if (state.getValue(BERRIES)) {
            Block.popResource(level, pos, new ItemStack(KNItems.WARPED_FRUIT.get(), 1));
            float f = Mth.randomBetween(level.getRandom(), 0.8F, 1.2F);
            level.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, f);
            BlockState newState = state.setValue(BERRIES, Boolean.FALSE);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
        } else {
            level.setBlock(pos, state.setValue(BERRIES, Boolean.TRUE), 2);
        }
    }
}
