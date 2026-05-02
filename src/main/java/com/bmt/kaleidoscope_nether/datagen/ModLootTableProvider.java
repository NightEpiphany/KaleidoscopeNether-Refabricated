package com.bmt.kaleidoscope_nether.datagen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.bmt.kaleidoscope_nether.KaleidoscopeNether;
import com.bmt.kaleidoscope_nether.init.KNBlocks;
import com.bmt.kaleidoscope_nether.init.KNItems;
import com.github.ysbbbbbb.kaleidoscopecookery.block.food.FoodBiteBlock;
import com.github.ysbbbbbb.kaleidoscopecookery.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopecookery.init.registry.FoodBiteRegistry;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, Set.of(), List.of(
                new SubProviderEntry(BlockLoots::new, LootContextParamSets.BLOCK)
        ), registries);
    }

    public static class BlockLoots extends BlockLootSubProvider {
        private final Set<Block> getKnownBlocks = new HashSet<>();

        protected BlockLoots(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        }

        @Override
        public void generate() {
            simpleCropBlockLoot(KNBlocks.POISONOUS_FRUIT.get(), KNItems.POISONOUS_FRUIT.get(), KNItems.POISONOUS_FRUIT.get());
            simpleCropBlockLoot(KNBlocks.SOUL_PEPPER.get(), ModItems.CHILI_SEED, KNItems.SOUL_PEPPER.get());

            this.vines(KNBlocks.TWISTING_CAVE_VINES.get(), Items.TWISTING_VINES, KNItems.WARPED_FRUIT.get());
            this.vines(KNBlocks.TWISTING_CAVE_VINES_PLANT.get(), Items.TWISTING_VINES, KNItems.WARPED_FRUIT.get());

            this.vines(KNBlocks.WEEPING_CAVE_VINES.get(), Items.WEEPING_VINES, KNItems.CRIMSON_FRUIT.get());
            this.vines(KNBlocks.WEEPING_CAVE_VINES_PLANT.get(), Items.WEEPING_VINES, KNItems.CRIMSON_FRUIT.get());

            this.dropSelf(KNBlocks.NETHER_STOVE.get());
//            this.dropSelf(KNBlocks.WARPED_CONNY.get());

            FoodBiteRegistry.FOOD_DATA_MAP.forEach((resourceLocation, foodData) -> {
                if (resourceLocation.getNamespace().equals(KaleidoscopeNether.MOD_ID)) {
                    dropFoodBite(resourceLocation, foodData);
                }
            });
        }


        private void vines(Block block, Item normal, Item berries) {
            this.add(block, LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(berries)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CaveVines.BERRIES, true))))
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(normal)))
            );

        }

        private void simpleCropBlockLoot(Block cropBlock, Item seed, Item crop) {
            LootItemCondition.Builder ageCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 7));
            this.add(cropBlock, this.applyExplosionDecay(cropBlock, LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(LootItem.lootTableItem(seed)))
                    .withPool(LootPool.lootPool().when(ageCondition).add(LootItem.lootTableItem(crop).apply(ApplyBonusCount.addBonusBinomialDistributionCount(this.registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))))));
        }

        private void dropFoodBite(Identifier id, FoodBiteRegistry.FoodData data) {
            Block block = BuiltInRegistries.BLOCK.getValue(id);
            Item food = BuiltInRegistries.ITEM.getValue(id);
            if (block instanceof FoodBiteBlock foodBiteBlock) {
                ConstantValue exactly = ConstantValue.exactly(1.0F);
                StatePropertiesPredicate.Builder notBite = StatePropertiesPredicate.Builder.properties().hasProperty(foodBiteBlock.getBites(), 0);
                LootItemCondition.Builder builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(foodBiteBlock).setProperties(notBite);
                LootTable.Builder lootTable = LootTable.lootTable();

                for (int i = 0; i < data.getLootItems().size(); ++i) {
                    ItemLike itemLike = data.getLootItems().get(i);
                    LootPool.Builder rolls = LootPool.lootPool().setRolls(exactly).when(ExplosionCondition.survivesExplosion());
                    if (i == 0) {
                        rolls.add(LootItem.lootTableItem(food).when(builder).otherwise(LootItem.lootTableItem(itemLike)));
                    } else {
                        rolls.add(EmptyLootItem.emptyItem().when(builder).otherwise(LootItem.lootTableItem(itemLike)));
                    }

                    lootTable.withPool(rolls);
                }

                this.add(block, lootTable);
                getKnownBlocks.add(block);
            }
        }
    }

}
