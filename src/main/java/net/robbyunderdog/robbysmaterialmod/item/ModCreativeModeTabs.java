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
                        output.accept(ModItems.RAW_TITANIUM.get());
                        output.accept(ModItems.TITANIUM_INGOT.get());

                        output.accept(ModItems.TITANIUM_CHISEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ROBBYSMATERIAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("robbysmaterial_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TITANIUM_BLOCK.get()))
                    .withTabsBefore(ROBBYSMATERIAL_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.robbysmaterialmod.robbysmaterial_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.TITANIUM_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.RAW_TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
