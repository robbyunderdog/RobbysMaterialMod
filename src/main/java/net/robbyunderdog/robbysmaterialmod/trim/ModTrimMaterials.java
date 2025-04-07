package net.robbyunderdog.robbysmaterialmod.trim;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

import java.util.Map;

public class ModTrimMaterials {
    // TITANIUM TRIM
    public static final ResourceKey<TrimMaterial> TITANIUM = ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "titanium"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        // TITANIUM TRIM
        register(context, TITANIUM, ModItems.TITANIUM_INGOT.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.4f);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item, Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex, Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }

}
