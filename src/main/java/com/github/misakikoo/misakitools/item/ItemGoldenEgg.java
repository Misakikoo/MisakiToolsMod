package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;


public class ItemGoldenEgg extends Item {
    public ItemGoldenEgg() {
        super();

        this.setUnlocalizedName("goldenEgg");

        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }
}