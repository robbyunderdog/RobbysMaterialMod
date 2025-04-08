package net.robbyunderdog.robbysmaterialmod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;
import net.robbyunderdog.robbysmaterialmod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, RobbysMaterialMod.MOD_ID);


    public static final RegistryObject<Potion> LIGHTWEIGHT_POTION = POTIONS.register("lightweight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.LIGHTWEIGHT_EFFECT.getHolder().get(), 1200, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
