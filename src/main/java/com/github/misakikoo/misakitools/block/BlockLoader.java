package com.github.misakikoo.misakitools.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockLoader {

    public static Block blockChromite = new BlockChromite().setUnlocalizedName("chromite");
    public static void init() {
        ForgeRegistries.BLOCKS.register(blockChromite.setRegistryName("chromite"));
        ForgeRegistries.ITEMS.register(new ItemBlock(blockChromite).setRegistryName(blockChromite.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockChromite), 0, new ModelResourceLocation(blockChromite.getRegistryName(), "inventory"));

    }
}
