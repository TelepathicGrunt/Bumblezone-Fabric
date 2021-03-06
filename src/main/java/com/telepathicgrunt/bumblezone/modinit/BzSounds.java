package com.telepathicgrunt.bumblezone.modinit;

import com.telepathicgrunt.bumblezone.Bumblezone;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BzSounds {
    public final static SoundEvent ANGERED_BEES = new SoundEvent(new Identifier(Bumblezone.MODID, "angered_bees"));
    public final static SoundEvent MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY = new SoundEvent(new Identifier(Bumblezone.MODID, "music_disc.honey_bee_rat_faced_boy"));
    public final static SoundEvent MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV = new SoundEvent(new Identifier(Bumblezone.MODID, "music_disc.flight_of_the_bumblebee_rimsky_korsakov"));

    public static void registerSounds() {
        Registry.register(Registry.SOUND_EVENT, new Identifier(Bumblezone.MODID, "angered_bees"), ANGERED_BEES);
        Registry.register(Registry.SOUND_EVENT, new Identifier(Bumblezone.MODID, "music_disc_honey_bee_rat_faced_boy"), MUSIC_DISC_HONEY_BEE_RAT_FACED_BOY);
        Registry.register(Registry.SOUND_EVENT, new Identifier(Bumblezone.MODID, "music_disc_flight_of_the_bumblebee_rimsky_korsakov"), MUSIC_DISC_FLIGHT_OF_THE_BUMBLEBEE_RIMSKY_KORSAKOV);
    }
}
