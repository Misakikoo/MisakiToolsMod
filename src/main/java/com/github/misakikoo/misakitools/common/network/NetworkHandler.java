package com.github.misakikoo.misakitools.common.network;

import com.github.misakikoo.misakitools.MisakiToolsMod;
import com.github.misakikoo.misakitools.common.network.message.MessageSkill;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class NetworkHandler {

    private static SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MisakiToolsMod.MODID);

    public NetworkHandler() {
        networkWrapper.registerMessage(MessageSkill::onMessage, MessageSkill.class, 0, Side.SERVER);
    }

    @SideOnly(Side.CLIENT)
    public static void useSkill() {
        networkWrapper.sendToServer(new MessageSkill());
    }

}
