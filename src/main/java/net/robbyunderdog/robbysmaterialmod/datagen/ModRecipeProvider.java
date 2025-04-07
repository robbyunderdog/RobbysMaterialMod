package net.robbyunderdog.robbysmaterialmod.datagen;

import com.sun.jna.platform.win32.WinDef;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.common.Mod;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // LIST OF TITANIUM SMELTABLES
        List<ItemLike> TITANIUM_SMELTABLES = List.of(ModItems.RAW_TITANIUM.get(),
                ModBlocks.TITANIUM_ORE.get(), ModBlocks.TITANIUM_DEEPSLATE_ORE.get());

    // TITANIUM BLOCKS
            // TITANIUM BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // RAW TITANIUM BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_TITANIUM_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_TITANIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_TITANIUM.get()), has(ModItems.RAW_TITANIUM.get())).save(pRecipeOutput);
            // TITANIUM STAIR
        stairBuilder(ModBlocks.TITANIUM_STAIRS.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM SLAB
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_SLAB.get(), ModItems.TITANIUM_INGOT.get());
            // TITANIUM PRESSURE PLATE
        pressurePlate(pRecipeOutput, ModBlocks.TITANIUM_PRESSURE_PLATE.get(), ModItems.TITANIUM_INGOT.get());
            // TITANIUM BUTTON
        buttonBuilder(ModBlocks.TITANIUM_BUTTON.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                        .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM FENCE
        fenceBuilder(ModBlocks.TITANIUM_FENCE.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM FENCE GATE
        fenceGateBuilder(ModBlocks.TITANIUM_FENCE_GATE.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM WALL
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_WALL.get(), ModItems.TITANIUM_INGOT.get());
            // TITANIUM DOOR
        doorBuilder(ModBlocks.TITANIUM_DOOR.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM TRAPDOOR
        trapdoorBuilder(ModBlocks.TITANIUM_TRAPDOOR.get(), Ingredient.of(ModItems.TITANIUM_INGOT.get())).group("titanium")
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);

    // FUEL
            // ORGANIC FUEL
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ORGANIC_FUEL.get())
                .pattern(" A ")
                .pattern("AAA")
                .pattern(" A ")
                .define('A', Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT)).save(pRecipeOutput);

    // TOOLS
            // TITANIUM CHISEL
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_CHISEL.get())
                .pattern("A")
                .pattern("B")
                .define('A', ModBlocks.TITANIUM_BLOCK.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get())).save(pRecipeOutput);
            // TITANIUM SWORD
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItems.TITANIUM_INGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM PICKAXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.TITANIUM_INGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM AXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" B ")
                .define('A', ModItems.TITANIUM_INGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM SHOVEL
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItems.TITANIUM_INGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM HOE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.TITANIUM_INGOT.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM HAMMER
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.TITANIUM_HAMMER.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" B ")
                .define('A', ModBlocks.TITANIUM_BLOCK.get()).define('B', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get())).save(pRecipeOutput);
    // ARMOR
            // TITANIUM HELMET
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM CHESTPLATE
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM LEGGINGS
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM BOOTS
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);
            // TITANIUM HORSE ARMOR
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TITANIUM_HORSE_ARMOR.get())
                .pattern("A  ")
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get())).save(pRecipeOutput);

    // BASIC ITEMS
            // TITANIUM INGOT
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get())).save(pRecipeOutput);
            // RAW TITANIUM
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TITANIUM.get(), 9)
                .requires(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TITANIUM_BLOCK.get()), has(ModBlocks.RAW_TITANIUM_BLOCK.get())).save(pRecipeOutput);
            // TITANIUM INGOT SMELTING AND BLASTING (LIST AT TOP)
        oreSmelting(pRecipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium_ingot");
        oreBlasting(pRecipeOutput, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium_ingot");
    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, RobbysMaterialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}
