package com.github.misakikoo.misakitools;

import org.apache.logging.log4j.Logger;

import com.github.misakikoo.misakitools.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = MisakiToolsMod.MODID, name = MisakiToolsMod.NAME, version = MisakiToolsMod.VERSION)
public class MisakiToolsMod{
    public static final String MODID = "misakitools";   //Mod modid
    public static final String NAME = "MisakiToolsMod"; //Mod name
    public static final String VERSION = "0.1.0";       //Mod version

    @SidedProxy(clientSide = "com.github.misakikoo.misakitools.client.ClientProxy", serverSide = "com.github.misakikoo.misakitools.common.CommonProxy")
    public static CommonProxy proxy;

    //Register the generated instance to MODID
    @Instance(MisakiToolsMod.MODID)
    public static MisakiToolsMod instance;


    private Logger logger;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }



    public Logger getLogger() {
        return logger;
    }
}