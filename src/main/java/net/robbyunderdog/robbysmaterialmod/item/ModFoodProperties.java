package net.robbyunderdog.robbysmaterialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties PHILLY_CHEESESTEAK = new FoodProperties.Builder().nutrition(10).saturationModifier(0.9f)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 600), 1.00f).build();
}
