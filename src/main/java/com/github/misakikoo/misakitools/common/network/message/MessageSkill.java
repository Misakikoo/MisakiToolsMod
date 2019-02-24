package com.github.misakikoo.misakitools.common.network.message;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageSkill implements IMessage {

    public static IMessage onMessage(MessageSkill message, MessageContext ctx) {
        if(ctx.side.isClient()) return null;
        ((WorldServer)ctx.getServerHandler().player.world).addScheduledTask(() ->
                ctx.getServerHandler().player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 10 * 20, 1)));
        return null;
    }

    public void toBytes(ByteBuf buf) {

    }

    public void fromBytes(ByteBuf buf) {

    }

}
