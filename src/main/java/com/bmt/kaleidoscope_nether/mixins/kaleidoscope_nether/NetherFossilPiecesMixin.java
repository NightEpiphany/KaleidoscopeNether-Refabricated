package com.bmt.kaleidoscope_nether.mixins.kaleidoscope_nether;

import com.bmt.kaleidoscope_nether.block.PoisonousFruit;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilPieces;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherFossilPieces.NetherFossilPiece.class)
public abstract class NetherFossilPiecesMixin extends TemplateStructurePiece {


    public NetherFossilPiecesMixin(StructurePieceType type, int genDepth, StructureTemplateManager structureTemplateManager, Identifier templateLocation, String templateName, StructurePlaceSettings placeSettings, BlockPos position) {
        super(type, genDepth, structureTemplateManager, templateLocation, templateName, placeSettings, position);
    }

    @Inject(method = "postProcess", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/levelgen/structure/structures/NetherFossilPieces$NetherFossilPiece;placeDriedGhast(Lnet/minecraft/world/level/WorldGenLevel;Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;Lnet/minecraft/world/level/levelgen/structure/BoundingBox;)V",
            shift = At.Shift.BEFORE
    ))
    private void postProcess(
            WorldGenLevel level,
            StructureManager structureManager,
            ChunkGenerator generator,
            RandomSource random,
            BoundingBox chunkBB,
            ChunkPos chunkPos,
            BlockPos referencePos,
            CallbackInfo ci
    ) {
        BoundingBox fossilBB = this.template.getBoundingBox(this.placeSettings, this.templatePosition);
        placePoisonousFruits(level, fossilBB, chunkBB);
    }

    @Unique
    private void placePoisonousFruits(final WorldGenLevel level, final BoundingBox fossilBB, final BoundingBox chunkBB) {
        RandomSource positionalRandom = RandomSource.createThreadLocalInstance(level.getSeed()).forkPositional().at(fossilBB.getCenter());
        if (positionalRandom.nextFloat() < 0.415F) {
            int x = fossilBB.minX() + positionalRandom.nextInt(fossilBB.getXSpan());
            int y = fossilBB.minY();
            int z = fossilBB.minZ() + positionalRandom.nextInt(fossilBB.getZSpan());
            BlockPos randomPos = new BlockPos(x, y, z);
            if (level.getBlockState(randomPos).isAir() && chunkBB.isInside(randomPos)) {
                level.setBlock(randomPos, KNBlocks.POISONOUS_FRUIT.get().defaultBlockState().setValue(PoisonousFruit.AGE, 7), 2);
            }
        }
    }
}
