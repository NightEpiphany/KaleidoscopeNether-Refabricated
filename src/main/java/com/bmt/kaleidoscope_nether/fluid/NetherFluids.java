package com.bmt.kaleidoscope_nether.fluid;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.WaterFluid;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public abstract class NetherFluids extends WaterFluid {
    private final Supplier<Fluid> still;
    private final Supplier<Fluid> flowing;

    public NetherFluids(Supplier<Fluid> still, Supplier<Fluid> flowing) {
        this.still = still;
        this.flowing = flowing;
    }

    @Override
    public @NotNull Fluid getFlowing() {
        return this.flowing.get();
    }

    @Override
    public @NotNull Fluid getSource() {
        return this.still.get();
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    public int getTickDelay(LevelReader level) {
        return 20;
    }

    @Override
    public boolean isSource(FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(FluidState fluidState) {
        return 0;
    }

    public static final class Source extends NetherFluids {
        public Source(Supplier<Fluid> still, Supplier<Fluid> flowing) {
            super(still, flowing);
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }
    }

    public static final class Flowing extends NetherFluids {
        public Flowing(Supplier<Fluid> still, Supplier<Fluid> flowing) {
            super(still, flowing);
            this.registerDefaultState(this.stateDefinition.any().setValue(FlowingFluid.LEVEL, 7));
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(FlowingFluid.LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(FlowingFluid.LEVEL);
        }
    }
}
