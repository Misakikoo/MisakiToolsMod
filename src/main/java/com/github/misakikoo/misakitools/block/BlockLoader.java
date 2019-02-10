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

    public static Block blockChromiteOre = new BlockChromiteOre().setUnlocalizedName("chromiteOre");
    public static void init() {
        ForgeRegistries.BLOCKS.register(blockChromiteOre.setRegistryName("chromite_ore"));
        ForgeRegistries.ITEMS.register(new ItemBlock(blockChromiteOre).setRegistryName(blockChromiteOre.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockChromiteOre), 0, new ModelResourceLocation(blockChromiteOre.getRegistryName(), "inventory"));

    }
}
