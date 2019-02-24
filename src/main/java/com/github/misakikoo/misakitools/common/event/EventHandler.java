package com.github.misakikoo.misakitools.common.event;

import com.github.misakikoo.misakitools.MisakiToolsMod;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.block.BlockLoader;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;


@Mod.EventBusSubscriber(modid = MisakiToolsMod.MODID)
public class EventHandler {

    private static final EventBus EVENT_BUS = new EventBus();

    public EventHandler() {
        EVENT_BUS.register(EventHandler.class);
    }

    //say hello
    @SubscribeEvent
    public static void sayHelloOnPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event){
        //event.setCanceled(true);
        if(event.isCanceled()) return;

        NBTTagCompound entityData = event.player.getEntityData();
        if(!entityData.getBoolean("firstLoggedIn")) {
            entityData.setBoolean("firstLoggedIn", true);
            event.player.sendMessage(new TextComponentString("Welcome join the new world"));
        } else {
            event.player.sendMessage(new TextComponentString("Welcome back"));
        }
    }

    //give initial tools
    @SubscribeEvent
    public static void giveGoldenEggOnPlayerLoggedInFrist(PlayerEvent.PlayerLoggedInEvent event) {
        //event.setCanceled(true);

        NBTTagCompound entityData = event.player.getEntityData();
        if(!event.isCanceled() && !entityData.getBoolean("firstJoin")) {
            entityData.setBoolean("firstJoin", true);
            event.player.inventory.addItemStackToInventory(new ItemStack(Items.WOODEN_AXE, 1));
            event.player.inventory.addItemStackToInventory(new ItemStack(Items.WOODEN_PICKAXE, 1));
        }
    }

    //pick up
    @SubscribeEvent
    public static void pickUpItem(EntityItemPickupEvent event) {
        MisakiToolsMod.instance.getLogger().info(event.getEntityPlayer().getName()+" pick up "+event.getItem().getItem().getUnlocalizedName());
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(event.getEntityPlayer().getName()+" pick up "+event.getItem().getItem().getUnlocalizedName()));
    }

    //on player jump
    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if(!(event.getEntityLiving() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
        BlockPos pos = event.getEntityLiving().getPosition();
        World world = event.getEntityLiving().world;
        PlayerJumpEvent event1 = new PlayerJumpEvent(player, pos, world);
        EVENT_BUS.post(event1);

        event1.setCanceled(true);

        event1.placeTNTPrimed();

    }

    //on player interact
    /*
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event){
        if(event.getWorld().isRemote) return;

        event.setCanceled(true);//canceled interact
    }
    */



}
