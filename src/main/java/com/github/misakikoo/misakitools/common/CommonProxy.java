package com.github.misakikoo.misakitools.common;

import com.github.misakikoo.misakitools.block.BlockLoader;
import com.github.misakikoo.misakitools.common.event.EventHandler;
import com.github.misakikoo.misakitools.enchantment.EnchantmentLoader;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;
import com.github.misakikoo.misakitools.crafting.CraftingLoader;

import com.github.misakikoo.misakitools.potion.PotionLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    	new ConfigLoader(event);
    	new CreativeTabsLoader(event);
		new ItemLoader(event);
		new BlockLoader(event);
		new PotionLoader(event);
	}

    public void init(FMLInitializationEvent event) {
		new CraftingLoader();
		new EnchantmentLoader();
		new EventHandler();
	}

	public void postInit(FMLPostInitializationEvent event) {
	}
}