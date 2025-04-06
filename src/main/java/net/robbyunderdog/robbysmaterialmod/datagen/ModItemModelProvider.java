package net.robbyunderdog.robbysmaterialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RobbysMaterialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // BASIC ITEMS
        basicItem(ModItems.RAW_TITANIUM.get());
        basicItem(ModItems.TITANIUM_INGOT.get());

        // TOOLS
        basicItem(ModItems.TITANIUM_CHISEL.get());
        handheldItem(ModItems.TITANIUM_SWORD);
        handheldItem(ModItems.TITANIUM_PICKAXE);
        handheldItem(ModItems.TITANIUM_AXE);
        handheldItem(ModItems.TITANIUM_SHOVEL);
        handheldItem(ModItems.TITANIUM_HOE);
        handheldItem(ModItems.TITANIUM_HAMMER);

        // FOOD
        basicItem(ModItems.PHILLY_CHEESESTEAK.get());

        // FUEL
        basicItem(ModItems.ORGANIC_FUEL.get());

        // SPECIAL BLOCKS
        //TITANIUM
        buttonItem(ModBlocks.TITANIUM_BUTTON, ModBlocks.TITANIUM_BLOCK);
        fenceItem(ModBlocks.TITANIUM_FENCE, ModBlocks.TITANIUM_BLOCK);
        wallItem(ModBlocks.TITANIUM_WALL, ModBlocks.TITANIUM_BLOCK);
        simpleBlockItem(ModBlocks.TITANIUM_DOOR);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
