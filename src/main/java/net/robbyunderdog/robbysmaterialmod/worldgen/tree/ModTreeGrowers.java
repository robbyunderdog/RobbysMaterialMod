package net.robbyunderdog.robbysmaterialmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower WALNUT = new TreeGrower(RobbysMaterialMod.MOD_ID + ":walnut", Optional.empty(), Optional.of(ModConfiguredFeatures.WALNUT_KEY), Optional.empty());
}
