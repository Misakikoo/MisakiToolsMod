package com.github.misakikoo.misakitools.client.event;

import com.github.misakikoo.misakitools.MisakiToolsMod;

import com.github.misakikoo.misakitools.common.network.NetworkHandler;
import com.google.common.graph.Network;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;


import org.lwjgl.input.Keyboard;


@Mod.EventBusSubscriber(modid = MisakiToolsMod.MODID, value = Side.CLIENT)
public class EventHandler {

    private static KeyBinding keyUseSkill = new KeyBinding("misakitools.useskill", Keyboard.KEY_M ,"misakitools.key");

    public EventHandler() {
        ClientRegistry.registerKeyBinding(keyUseSkill);
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if(keyUseSkill.isPressed()){
            NetworkHandler.useSkill();
        }
    }

}
