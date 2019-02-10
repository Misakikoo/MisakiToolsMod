package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsMisakiTools;

import net.minecraft.item.Item;

public class ItemChromeIngot extends Item {
    public ItemChromeIngot() {
        super();

        this.setUnlocalizedName("chromeIngot");

        this.setCreativeTab(CreativeTabsMisakiTools.tabMisakiTools);
    }
}
