package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.robbyunderdog.robbysmaterialmod.util.ModTags;

public class ModToolTiers {
    public static final Tier TITANIUM = new ForgeTier(1875, 8.5f, 3.5f, 14,
            ModTags.Blocks.NEEDS_TITANIUM_TOOL, () -> Ingredient.of(ModItems.TITANIUM_INGOT.get()), ModTags.Blocks.INCORRECT_FOR_TITANIUM_TOOL);

}
