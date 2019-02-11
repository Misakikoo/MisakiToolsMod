package com.github.misakikoo.misakitools.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader {

    public static CreativeTabs tabMisakiTools;

    public CreativeTabsLoader(FMLPreInitializationEvent event) {
        tabMisakiTools = new CreativeTabsMisakiTools();
    }
}
