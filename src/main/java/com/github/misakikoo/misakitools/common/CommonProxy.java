package com.github.misakikoo.misakitools.common;

import com.github.misakikoo.misakitools.block.BlockLoader;
import  com.github.misakikoo.misakitools.item.*;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
		ItemLoader.init();
		BlockLoader.init();
	}

    public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {

	}
}