package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;


public class ItemExcalibur extends ItemSword {

    public static final Item.ToolMaterial SUPERMaterial = EnumHelper.addToolMaterial("SUPERMaterial", 3, 4096, 16.0F, 5.0F, 30);

    public ItemExcalibur() {
        super(SUPERMaterial);
        this.setMaxDamage(-1);
        this.setHarvestLevel("axe", 3);
        this.setHarvestLevel("shovel", 3);
        this.setHarvestLevel("pickaxe", 3);
        this.setUnlocalizedName("excalibur");
        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }

}
