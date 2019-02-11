package com.github.misakikoo.misakitools.item;

import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemLoader {

    public static Item goldenEgg = new ItemGoldenEgg();
    public static Item chromeIngot = new ItemChromeIngot();

    public ItemLoader(FMLPreInitializationEvent event) {
        register(goldenEgg,"golden_egg");
        register(chromeIngot, "chrome_ingot");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(goldenEgg);
        registerRender(chromeIngot);
    }

    private static void register(Item item, String name) {
        ForgeRegistries.ITEMS.register(item.setRegistryName(name));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item) {
        ModelResourceLocation model = new ModelResourceLocation(goldenEgg.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);

    }
}