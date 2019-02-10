package com.github.misakikoo.misakitools.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockLoader {

    public static Block chromiteOre = new BlockChromiteOre();

    public BlockLoader(FMLPreInitializationEvent event) {
        register(chromiteOre, "chromite_ore");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerRender(chromiteOre);
    }

    private static void register(Block block, String name) {
        ForgeRegistries.BLOCKS.register(block.setRegistryName(name));
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block) {
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }

}
