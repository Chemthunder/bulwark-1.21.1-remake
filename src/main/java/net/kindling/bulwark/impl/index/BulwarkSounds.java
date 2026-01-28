package net.kindling.bulwark.impl.index;

import net.kindling.bulwark.impl.Bulwark;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.Map;

public interface BulwarkSounds {
    Map<SoundEvent, Identifier> SOUNDS = new LinkedHashMap<>();

    SoundEvent PLUSH_EXPLODE = create("block.plush_explode");

    private static SoundEvent create(String name) {
        SoundEvent soundEvent = SoundEvent.of(Bulwark.id(name));
        SOUNDS.put(soundEvent, Bulwark.id(name));
        return soundEvent;
    }

    static void index() {
        SOUNDS.keySet().forEach(soundEvent -> {
            Registry.register(Registries.SOUND_EVENT, SOUNDS.get(soundEvent), soundEvent);
        });
    }
}
