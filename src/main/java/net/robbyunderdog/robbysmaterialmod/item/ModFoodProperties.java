package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PHILLY_CHEESESTEAK = new FoodProperties.Builder().nutrition(10).saturationModifier(0.9f)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 600), 1.00f).build();
    public static final FoodProperties BELLPEPPER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.15f).fast().build();
}
