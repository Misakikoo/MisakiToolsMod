package com.github.misakikoo.misakitools;

import com.github.misakikoo.misakitools.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = MisakiToolsMod.MODID, name = MisakiToolsMod.NAME, version = MisakiToolsMod.VERSION, acceptedMinecraftVersions = "1.8.9")
public class MisakiToolsMod{
    public static final String MODID = "misakitools";   //Mod的唯一标识符
    public static final String NAME = "MisakiToolsMod"; //Mod名字
    public static final String VERSION = "0.1.0";       //Mod版本

    //代理
    @SidedProxy(clientSide = "com.github.ustc_zzzz.fmltutor.client.ClientProxy", serverSide = "com.github.ustc_zzzz.fmltutor.common.CommonProxy")
    public static CommonProxy proxy;

    //将生成的Mod的实例，注册到对应的Mod的id
    @Instance(MisakiToolsMod.MODID)
    public static MisakiToolsMod instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        // 加载配置文件，实例化物品和方块，并注册它们
        // TODO

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        //为Mod进行设置，如注册合成表和烧炼系统，并且向其他Mod发送交互信息
        // TODO

        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        //接收其他Mod发送的交互信息，并完成对Mod的设置
        // TODO

        proxy.postInit(event);
    }
}