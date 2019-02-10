package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsMisakiTools;

import net.minecraft.item.Item;

//金蛋
public class ItemGoldenEgg extends Item {
    public ItemGoldenEgg() {
        super();

        this.setUnlocalizedName("goldenEgg");

        this.setCreativeTab(CreativeTabsMisakiTools.tabMisakiTools);
    }
}