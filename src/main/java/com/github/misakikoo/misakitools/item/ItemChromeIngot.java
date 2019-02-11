package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;

public class ItemChromeIngot extends Item {
    public ItemChromeIngot() {
        super();

        this.setUnlocalizedName("chromeIngot");

        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }
}
