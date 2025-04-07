package net.robbyunderdog.robbysmaterialmod.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.robbyunderdog.robbysmaterialmod.RobbysMaterialMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RobbysMaterialMod.MOD_ID);


    public static final RegistryObject<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");


    // DISCS
    public static final RegistryObject<SoundEvent> BAW_BRAWL = registerSoundEvent("bar_brawl");
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, "bar_brawl"));


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(RobbysMaterialMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
