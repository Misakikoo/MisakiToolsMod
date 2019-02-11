package com.github.misakikoo.misakitools.creativetab;

import com.github.misakikoo.misakitools.item.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabsMisakiTools extends CreativeTabs {

    public CreativeTabsMisakiTools() {
        super("misakitools");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemLoader.goldenEgg);
    }
}
