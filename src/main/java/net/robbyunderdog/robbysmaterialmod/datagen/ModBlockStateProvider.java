package net.robbyunderdog.robbysmaterialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;
import net.robbyunderdog.robbysmaterialmod.block.custom.LampBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RobbysMaterialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // ORES
        blockWithItem(ModBlocks.TITANIUM_ORE);
        blockWithItem(ModBlocks.TITANIUM_DEEPSLATE_ORE);

        // TITANIUM BLOCKS
        blockWithItem(ModBlocks.RAW_TITANIUM_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_BLOCK);

        stairsBlock(ModBlocks.TITANIUM_STAIRS.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        slabBlock(ModBlocks.TITANIUM_SLAB.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.TITANIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        buttonBlock(ModBlocks.TITANIUM_BUTTON.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        fenceBlock(ModBlocks.TITANIUM_FENCE.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.TITANIUM_FENCE_GATE.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        wallBlock(ModBlocks.TITANIUM_WALL.get(), blockTexture(ModBlocks.TITANIUM_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.TITANIUM_DOOR.get(), modLoc("block/titanium_door_bottom"), modLoc("block/titanium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.TITANIUM_TRAPDOOR.get(), modLoc("block/titanium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.TITANIUM_STAIRS);
        blockItem(ModBlocks.TITANIUM_SLAB);
        blockItem(ModBlocks.TITANIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.TITANIUM_FENCE_GATE);
        blockItem(ModBlocks.TITANIUM_TRAPDOOR, "_bottom");

        customLamp(ModBlocks.TITANIUM_LAMP);
    }

    private void customLamp(RegistryObject<? extends Block> blockRegistryObject) {
        getVariantBuilder(blockRegistryObject.get()).forAllStates(state -> {
            if(state.getValue(LampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(blockRegistryObject.getId().getPath() + "_on",
                        ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(blockRegistryObject.getId().getPath() + "_off",
                        ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_off")))};
            }
        });
        simpleBlockItem(blockRegistryObject.get(), models().cubeAll(blockRegistryObject.getId().getPath() + "_on",
                ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "block/" + blockRegistryObject.getId().getPath() + "_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("robbysmaterialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("robbysmaterialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
