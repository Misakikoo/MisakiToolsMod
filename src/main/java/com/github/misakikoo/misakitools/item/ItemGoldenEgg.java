package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.common.ConfigLoader;
import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ItemGoldenEgg extends Item {
    public ItemGoldenEgg() {
        super();

        this.setUnlocalizedName("goldenEgg");

        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }

    @Override
    public int getItemBurnTime(ItemStack item) {
        return ConfigLoader.goldenEggBurnTime;
    }
}