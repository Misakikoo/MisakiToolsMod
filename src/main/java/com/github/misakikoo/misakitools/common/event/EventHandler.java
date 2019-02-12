package com.github.misakikoo.misakitools.common.event;

import com.github.misakikoo.misakitools.MisakiToolsMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = MisakiToolsMod.MODID)
public class EventHandler {

    //pick up item
    @SubscribeEvent
    public static void pickUpItem(EntityItemPickupEvent event) {
        MisakiToolsMod.instance.getLogger().info(event.getEntityPlayer().getName()+" pick up "+event.getItem().getName());
    }

    //player jump
    @SubscribeEvent
    public static void onLivingJump(LivingEvent.LivingJumpEvent event) {
        if(!(event.getEntityLiving() instanceof EntityPlayer))
            return;

        MisakiToolsMod.instance.getLogger().info("Listening " + event.getEntityLiving().getName() + " jump");
    }

}
