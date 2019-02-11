package com.github.misakikoo.misakitools.crafting;

import com.github.misakikoo.misakitools.block.BlockLoader;
import com.github.misakikoo.misakitools.item.ItemLoader;
import com.github.misakikoo.misakitools.common.ConfigLoader;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader {
    public CraftingLoader() {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    //合成
    private static void registerRecipe() {
        //1.12开始用json比较方便，代码方式变得很麻烦
    }

    //烧制
    private static void registerSmelting() {
        GameRegistry.addSmelting(BlockLoader.chromiteOre, new ItemStack(ItemLoader.chromeIngot,2 ), 0.5F);//铬铁矿->2x铬锭
    }

    //燃料
    private static void registerFuel() {
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                return Items.DIAMOND != fuel.getItem() ? 0 : Math.max(0, ConfigLoader.diamondBurnTime)*20;
            }
        });//钻石
    }
}
