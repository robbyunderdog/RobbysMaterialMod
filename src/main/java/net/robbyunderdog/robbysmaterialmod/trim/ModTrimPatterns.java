package net.robbyunderdog.robbysmaterialmod.trim;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.item.ModItems;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> LIGHTWEIGHT = ResourceKey.create(Registries.TRIM_PATTERN, ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "lightweight"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.LIGHTWEIGHT_SMITHING_TEMPLATE.get(), LIGHTWEIGHT);
    }

    private static void register(BootstrapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(), Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
