package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RobbysMaterialMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ROBBYSMATERIAL_ITEMS_TAB = CREATIVE_MODE_TABS.register("robbysmaterial_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TITANIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.robbysmaterialmod.robbysmaterial_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // BASIC ITEMS
                        output.accept(ModItems.RAW_TITANIUM.get());
                        output.accept(ModItems.TITANIUM_INGOT.get());

                        // TOOLS
                        output.accept(ModItems.TITANIUM_CHISEL.get());
                        output.accept(ModItems.TITANIUM_SWORD.get());
                        output.accept(ModItems.TITANIUM_PICKAXE.get());
                        output.accept(ModItems.TITANIUM_AXE.get());
                        output.accept(ModItems.TITANIUM_SHOVEL.get());
                        output.accept(ModItems.TITANIUM_HOE.get());
                        output.accept(ModItems.TITANIUM_HAMMER.get());

                        // ARMOR
                        output.accept(ModItems.TITANIUM_HELMET.get());
                        output.accept(ModItems.TITANIUM_CHESTPLATE.get());
                        output.accept(ModItems.TITANIUM_LEGGINGS.get());
                        output.accept(ModItems.TITANIUM_BOOTS.get());
                        output.accept(ModItems.TITANIUM_HORSE_ARMOR.get());

                        // FOOD
                        output.accept(ModItems.PHILLY_CHEESESTEAK.get());

                        // FUEL
                        output.accept(ModItems.ORGANIC_FUEL.get());

                        // SMITHING TEMPLATES
                        output.accept(ModItems.LIGHTWEIGHT_SMITHING_TEMPLATE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ROBBYSMATERIAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("robbysmaterial_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TITANIUM_BLOCK.get()))
                    .withTabsBefore(ROBBYSMATERIAL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.robbysmaterialmod.robbysmaterial_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //ORES AND RAW BLOCKS
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.TITANIUM_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.RAW_TITANIUM_BLOCK.get());

                        // TITANIUM BLOCK BLOCKS
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_STAIRS.get());
                        output.accept(ModBlocks.TITANIUM_SLAB.get());
                        output.accept(ModBlocks.TITANIUM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.TITANIUM_BUTTON.get());
                        output.accept(ModBlocks.TITANIUM_FENCE.get());
                        output.accept(ModBlocks.TITANIUM_FENCE_GATE.get());
                        output.accept(ModBlocks.TITANIUM_WALL.get());
                        output.accept(ModBlocks.TITANIUM_DOOR.get());
                        output.accept(ModBlocks.TITANIUM_TRAPDOOR.get());
                        output.accept(ModBlocks.TITANIUM_LAMP.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
