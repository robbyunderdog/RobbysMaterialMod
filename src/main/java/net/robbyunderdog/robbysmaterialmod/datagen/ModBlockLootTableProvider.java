package net.robbyunderdog.robbysmaterialmod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;
import net.robbyunderdog.robbysmaterialmod.block.custom.BellpepperCropBlock;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
    // ORES
        this.add(ModBlocks.TITANIUM_ORE.get(), block -> createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.TITANIUM_DEEPSLATE_ORE.get(), block -> createOreDrop(ModBlocks.TITANIUM_DEEPSLATE_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.LEAD_ORE.get(), block -> createOreDrop(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        this.add(ModBlocks.LEAD_DEEPSLATE_ORE.get(), block -> createOreDrop(ModBlocks.LEAD_DEEPSLATE_ORE.get(), ModItems.RAW_LEAD.get()));

    // TITANIUM BLOCKS
        dropSelf(ModBlocks.RAW_TITANIUM_BLOCK.get());
        dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        dropSelf(ModBlocks.TITANIUM_STAIRS.get());
        dropSelf(ModBlocks.TITANIUM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.TITANIUM_BUTTON.get());
        dropSelf(ModBlocks.TITANIUM_FENCE.get());
        dropSelf(ModBlocks.TITANIUM_FENCE_GATE.get());
        dropSelf(ModBlocks.TITANIUM_WALL.get());
        dropSelf(ModBlocks.TITANIUM_TRAPDOOR.get());
        dropSelf(ModBlocks.TITANIUM_LAMP.get());
        this.add(ModBlocks.TITANIUM_SLAB.get(), block -> createSlabItemTable(ModBlocks.TITANIUM_SLAB.get()));
        this.add(ModBlocks.TITANIUM_DOOR.get(), block -> createDoorTable(ModBlocks.TITANIUM_DOOR.get()));

    // LEAD BLOCKS
        dropSelf(ModBlocks.RAW_LEAD_BLOCK.get());
        dropSelf(ModBlocks.LEAD_BLOCK.get());

    // CROPS
        // BELLPEPPER CROP
        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BELLPEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BellpepperCropBlock.AGE, BellpepperCropBlock.MAX_AGE));
        this.add(ModBlocks.BELLPEPPER_CROP.get(), this.createCropDrops(ModBlocks.BELLPEPPER_CROP.get(),
                ModItems.BELLPEPPER.get(), ModItems.BELLPEPPER_SEEDS.get(), lootItemConditionBuilder));

        // BLUEBERRY BUSH
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(ModBlocks.BLUEBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                )));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops))).apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
