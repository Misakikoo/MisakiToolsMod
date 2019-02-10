package com.github.misakikoo.misakitools.item;

import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemLoader {

    public static Item itemGoldenEgg = new ItemGoldenEgg().setUnlocalizedName("goldenEgg");
    public static void init() {
        ForgeRegistries.ITEMS.register(itemGoldenEgg.setRegistryName("golden_egg"));
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
        ModelLoader.setCustomModelResourceLocation(itemGoldenEgg, 0, new ModelResourceLocation(itemGoldenEgg.getRegistryName(), "inventory"));

    }
}