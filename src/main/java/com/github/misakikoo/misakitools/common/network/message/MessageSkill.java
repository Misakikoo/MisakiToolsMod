package com.github.misakikoo.misakitools.common.network.message;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageSkill implements IMessage {

    public static IMessage onMessage(MessageSkill message, MessageContext ctx) {
        return null;
    }

    public void toBytes(ByteBuf buf) {

    }

    public void fromBytes(ByteBuf buf) {

    }

}
