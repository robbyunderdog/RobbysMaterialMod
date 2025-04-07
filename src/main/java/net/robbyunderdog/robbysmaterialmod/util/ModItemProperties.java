package net.robbyunderdog.robbysmaterialmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.component.ModDataComponentTypes;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.TITANIUM_CHISEL.get(), ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f: 0f);
    }
}
