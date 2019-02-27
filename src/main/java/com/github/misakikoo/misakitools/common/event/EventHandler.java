package com.github.misakikoo.misakitools.common.event;

import com.github.misakikoo.misakitools.MisakiToolsMod;
import com.github.misakikoo.misakitools.client.key.KeyLoader;
import com.github.misakikoo.misakitools.common.ConfigLoader;
import com.github.misakikoo.misakitools.enchantment.EnchantmentLoader;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.block.BlockLoader;
import com.github.misakikoo.misakitools.potion.PotionLoader;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


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
                player.getEntityWorld().newExplosion(pig, pig.posX, pig.posY, pig.posZ, 2.0F, true, true);
                pig.setDead();
            }
        }
    }

    //fireBurn enchantment
    @SubscribeEvent
    public static void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
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

    //potion Explosion
    @SubscribeEvent
    public static void PotionExplosion(PotionEvent event) {
        //event.setCanceled(true);

        EntityLivingBase player = event.getEntityLiving();
        if(player instanceof EntityPlayer && player.isServerWorld()){
            if(player.getActivePotionEffect(PotionLoader.potionExplosion) != null) {
                /**
                 * i don't know why it will create Explosion Constantly then CRASH my game
                player.attackEntityFrom((new DamageSource("byPotionBoom")).setDifficultyScaled().setDamageBypassesArmor().setExplosion(), 8.0F);
                player.getEntityWorld().newExplosion(player, player.posX, player.posY, player.posZ, 2.0F, true, true);//isCreateFire(), isDamagesTerrain()
                player.clearActivePotions();
                */
            }
        }
    }

    //key show time
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyLoader.showTime.isPressed()) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            World world = Minecraft.getMinecraft().world;
            long time = world.getWorldTime();
            long day = time / 24000;
            long hour = (time - 24000 * day) * 24 / 24000;
            long minute = (time - 24000 * day - 24000 / 24 * hour) * 24 * 60 / 24000;
            //long second = (time - 24000 * day - 24000 / 24 * hour - 24000 / 24 / 60 * minute) * 24 * 60 * 60 / 24000;
            player.sendMessage(new TextComponentTranslation("chat.misakitools.time", day, hour, minute));
        }
    }

    //pick up item
    @SubscribeEvent
    public static void pickUpItem(EntityItemPickupEvent event) {
        MisakiToolsMod.instance.getLogger().info(event.getEntityPlayer().getName()+" pick up "+event.getItem().getItem().toString());
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString(event.getEntityPlayer().getName()+" pick up "+event.getItem().getItem().getUnlocalizedName()));
    }

    /**
     * i think it's BAD to cpu
    //create a Primed TNT on player jump
    @SubscribeEvent
    public static void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if(event.getEntityLiving() instanceof EntityPlayer) {
            BlockPos pos = event.getEntityLiving().getPosition();
            World world = event.getEntityLiving().world;

            //event.setCanceled(true);
            if(!event.isCanceled() && !world.isRemote) {
                Entity tnt = new EntityTNTPrimed(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, null);
                world.spawnEntity(tnt);
            }
        }
    }
     */

    /*
     * canceled interact
    //on player interact
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent event){
        if(event.getWorld().isRemote) return;

        event.setCanceled(true);//canceled interact
    }
     */



}
