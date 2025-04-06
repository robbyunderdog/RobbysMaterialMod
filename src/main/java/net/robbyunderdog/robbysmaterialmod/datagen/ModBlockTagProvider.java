package net.robbyunderdog.robbysmaterialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RobbysMaterialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // PICKAXE MINEABLE
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.TITANIUM_ORE.get());

        // NEEDS IRON TOOL
        tag(BlockTags.NEEDS_IRON_TOOL);

        // NEEDS DIAMOND TOOL
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.TITANIUM_ORE.get());

        // FENCES
        tag(BlockTags.FENCES)
                .add(ModBlocks.TITANIUM_FENCE.get());

        // FENCE GATES
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.TITANIUM_FENCE_GATE.get());

        // WALLS
        tag(BlockTags.WALLS)
                .add(ModBlocks.TITANIUM_WALL.get());

    }
}
