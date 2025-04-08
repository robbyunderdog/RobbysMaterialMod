package net.robbyunderdog.robbysmaterialmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.custom.BellpepperCropBlock;
import net.robbyunderdog.robbysmaterialmod.block.custom.LampBlock;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RobbysMaterialMod.MOD_ID);

// TITANIUM BLOCKS
    // TITANIUM ORE
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore", () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops()));
    // TITANIUM DEEPSLATE ORE
    public static final RegistryObject<Block> TITANIUM_DEEPSLATE_ORE = registerBlock("titanium_deepslate_ore", () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    // RAW TITANIUM BLOCK
    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    // TITANIUM BLOCK
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    // TITANIUM STAIRS
    public static final RegistryObject<StairBlock> TITANIUM_STAIRS = registerBlock("titanium_stairs", () -> new StairBlock(ModBlocks.TITANIUM_BLOCK.get().defaultBlockState(),
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM SLAB
    public static final RegistryObject<SlabBlock> TITANIUM_SLAB = registerBlock("titanium_slab", () -> new SlabBlock(
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM PRESSURE PLATE
    public static final RegistryObject<PressurePlateBlock> TITANIUM_PRESSURE_PLATE = registerBlock("titanium_pressure_plate", () -> new PressurePlateBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM BUTTON
    public static final RegistryObject<ButtonBlock> TITANIUM_BUTTON = registerBlock("titanium_button", () -> new ButtonBlock(BlockSetType.IRON, 20,
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noCollission()));
    // TITANIUM FENCE
    public static final RegistryObject<FenceBlock> TITANIUM_FENCE = registerBlock("titanium_fence", () -> new FenceBlock(
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM FENCE GATE
    public static final RegistryObject<FenceGateBlock> TITANIUM_FENCE_GATE = registerBlock("titanium_fence_gate", () -> new FenceGateBlock(WoodType.ACACIA,
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM WALL
    public static final RegistryObject<WallBlock> TITANIUM_WALL = registerBlock("titanium_wall", () -> new WallBlock(
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    // TITANIUM DOOR
    public static final RegistryObject<DoorBlock> TITANIUM_DOOR = registerBlock("titanium_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    // TITANIUM TRAPDOOR
    public static final RegistryObject<TrapDoorBlock> TITANIUM_TRAPDOOR = registerBlock("titanium_trapdoor", () -> new TrapDoorBlock(BlockSetType.IRON,
            BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    // TITANIUM LAMP
    public static final RegistryObject<Block> TITANIUM_LAMP = registerBlock("titanium_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.of().strength(3f).lightLevel(state -> state.getValue(LampBlock.CLICKED) ? 15 : 0)));


// LEAD BLOCKS
    // LEAD ORE
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
        .strength(3f).requiresCorrectToolForDrops()));
    // LEAD DEEPSLATE ORE
    public static final RegistryObject<Block> LEAD_DEEPSLATE_ORE = registerBlock("lead_deepslate_ore", () -> new DropExperienceBlock(UniformInt.of(3,5), BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    // RAW LEAD BLOCK
    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    // LEAD BLOCK
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

// CROPS
    // BELLPEPPER CROPS
    public static final RegistryObject<Block> BELLPEPPER_CROP = BLOCKS.register("bellpepper_crop",
            () -> new BellpepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
