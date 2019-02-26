package com.github.misakikoo.misakitools.client.key;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyLoader {

    public static KeyBinding showTime = new KeyShowTime(Keyboard.KEY_H);

    public KeyLoader() {
        register(showTime);
    }

    public void register(KeyBinding key){
        ClientRegistry.registerKeyBinding(key);
    }
}
