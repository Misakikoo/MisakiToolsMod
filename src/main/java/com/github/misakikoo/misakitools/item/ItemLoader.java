package com.github.misakikoo.misakitools.item;

import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemRedstone;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemLoader {
    //item
    public static Item goldenEgg = new ItemGoldenEgg();
    public static Item chromeIngot = new ItemChromeIngot();
    //food
    public static Item redstoneApple = new ItemRedstoneApple();
    //sword
    public static Item excalibur = new ItemExcalibur();
    //tool
    //armor
    public static Item redstoneHelmet = new ItemRedstoneArmor.Helmet();
    public static Item redstoneChestplate = new ItemRedstoneArmor.Chestplate();
    public static Item redstoneLeggings = new ItemRedstoneArmor.Leggings();
    public static Item redstoneBoots = new ItemRedstoneArmor.Boots();


    public ItemLoader(FMLPreInitializationEvent event) {
        //item
        register(goldenEgg,"golden_egg");
        register(chromeIngot, "chrome_ingot");
        //food
        register(redstoneApple, "redstone_apple");
        //sword
        register(excalibur, "excalibur");
        //tool
        //armor
        register(redstoneHelmet, "redstone_helmet");
        register(redstoneChestplate, "redstone_chestplate");
        register(redstoneLeggings, "redstone_leggings");
        register(redstoneBoots, "redstone_boots");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        //item
        registerRender(goldenEgg);
        registerRender(chromeIngot);
        //food
        registerRender(redstoneApple);
        //sword
        registerRender(excalibur);
        //tool
        //armor
        registerRender(redstoneHelmet);
        registerRender(redstoneChestplate);
        registerRender(redstoneLeggings);
        registerRender(redstoneBoots);
    }

    private static void register(Item item, String name) {
        ForgeRegistries.ITEMS.register(item.setRegistryName(name));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item) {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);

    }
}