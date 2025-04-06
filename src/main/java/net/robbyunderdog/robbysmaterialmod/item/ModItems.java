package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.item.custom.ChiselItem;
import net.robbyunderdog.robbysmaterialmod.item.custom.FuelItem;
import net.robbyunderdog.robbysmaterialmod.item.custom.HammerItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RobbysMaterialMod.MOD_ID);

    // NON-UNIQUE ITEMS
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties()));

    // ADVANCED ITEMS
    public static final RegistryObject<Item> TITANIUM_CHISEL = ITEMS.register("titanium_chisel",
            () -> new ChiselItem(new Item.Properties().durability(128)));

    // FOOD
    public static final RegistryObject<Item> PHILLY_CHEESESTEAK = ITEMS.register("philly_cheesesteak",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PHILLY_CHEESESTEAK)));

    // FUEL
    public static final RegistryObject<Item> ORGANIC_FUEL = ITEMS.register("organic_fuel",
            () -> new FuelItem(new Item.Properties(), 1600));

    // TITANIUM TOOLS
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TITANIUM, 3, -2.4f))));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.TITANIUM, 1, -2.8f))));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.TITANIUM, 6, -3.2f))));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.TITANIUM, 1.5f, -3.0f))));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.TITANIUM, 0, -3.0f))));
    public static final RegistryObject<Item> TITANIUM_HAMMER = ITEMS.register("titanium_hammer",
            () -> new HammerItem(ModToolTiers.TITANIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.TITANIUM, 7, -3.6f))));

    // TITANIUM ARMOR
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(35))));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(35))));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(35))));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots",
            () -> new ArmorItem(ModArmorMaterials.TITANIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(35))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
