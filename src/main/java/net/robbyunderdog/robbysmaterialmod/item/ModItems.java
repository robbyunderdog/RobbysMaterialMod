package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.item.custom.ChiselItem;
import net.robbyunderdog.robbysmaterialmod.item.custom.FuelItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RobbysMaterialMod.MOD_ID);

    // NON-UNIQUE ITEMS
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));

    // ADVANCED ITEMS
    public static final RegistryObject<Item> TITANIUM_CHISEL = ITEMS.register("titanium_chisel", () -> new ChiselItem(new Item.Properties().durability(128)));

    // FOOD
    public static final RegistryObject<Item> PHILLY_CHEESESTEAK = ITEMS.register("philly_cheesesteak", () -> new Item(new Item.Properties().food(ModFoodProperties.PHILLY_CHEESESTEAK)));

    // FUEL
    public static final RegistryObject<Item> ORGANIC_FUEL = ITEMS.register("organic_fuel", () -> new FuelItem(new Item.Properties(), 1600));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
