package com.github.misakikoo.misakitools.common;

import com.github.misakikoo.misakitools.block.BlockLoader;
import com.github.misakikoo.misakitools.common.event.EventHandler;
import com.github.misakikoo.misakitools.common.network.NetworkHandler;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;
import com.github.misakikoo.misakitools.crafting.CraftingLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    	new ConfigLoader(event);
    	new NetworkHandler();
    	new CreativeTabsLoader(event);
		new ItemLoader(event);
		new BlockLoader(event);
	}

    public void init(FMLInitializationEvent event) {
		new CraftingLoader();
		new EventHandler();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}