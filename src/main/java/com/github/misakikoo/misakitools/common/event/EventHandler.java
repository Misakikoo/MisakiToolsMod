package com.github.misakikoo.misakitools.common.event;

import com.github.misakikoo.misakitools.MisakiToolsMod;
import com.github.misakikoo.misakitools.enchantment.EnchantmentLoader;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.block.BlockLoader;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;


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

    //pig fed the WRONG food will BOOM!
    @SubscribeEvent
    public static void onEntityInteract(EntityInteract event) {
        //event.setCanceled(true);

        EntityPlayer player = event.getEntityPlayer();
        if(player.isServerWorld() && event.getTarget() instanceof EntityPig) {
            EntityPig pig = (EntityPig) event.getTarget();
            ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
            if(!stack.isEmpty() && (stack.getItem() == Items.WHEAT || stack.getItem() == Items.WHEAT_SEEDS)) {
                player.attackEntityFrom((new DamageSource("byPigBoom")).setDifficultyScaled().setDamageBypassesArmor().setExplosion(), 8.0F);
                player.getEntityWorld().createExplosion(pig, pig.posX, pig.posY, pig.posZ, 2.0F, false);
                pig.setDead();
            }
        }
    }

    //fireBurn enchantment
    @SubscribeEvent
    public  static  void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        //event.setCanceled(true);

        if(!event.getWorld().isRemote && event.getHarvester() != null) {
            ItemStack itemStack = event.getHarvester().getHeldItem(EnumHand.MAIN_HAND);
            int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentLoader.fireBurn, itemStack);
            if(enchantmentLevel > 0 && itemStack.getItem() instanceof ItemPickaxe) {
                for(int i = 0; i < event.getDrops().size(); i++){
                    ItemStack stack = event.getDrops().get(i);
                    ItemStack newStack = FurnaceRecipes.instance().getSmeltingResult(stack);
                    if(!newStack.isEmpty()) {
                        newStack = newStack.copy();
                        newStack.setCount(stack.getCount() * enchantmentLevel);
                        event.getDrops().set(i, newStack);
                    }
                }
            }
        }
    }



    //pick up
    @SubscribeEvent
    public static void pickUpItem(EntityItemPickupEvent event) {
        MisakiToolsMod.instance.getLogger().info(event.getEntityPlayer().getName()+" pick up "+event.getItem().getItem().toString());
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
