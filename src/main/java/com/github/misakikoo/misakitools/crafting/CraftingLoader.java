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
        //registerRecipe();
        registerSmelting();
        registerFuel();
    }

    //private static void registerRecipe() {}
        //just use .json for mc1.12

    private static void registerSmelting() {
        GameRegistry.addSmelting(BlockLoader.chromiteOre, new ItemStack(ItemLoader.chromeIngot,2 ), 0.5F);
    }

    private static void registerFuel() {
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                return Items.DIAMOND != fuel.getItem() ? 0 : Math.max(0, ConfigLoader.diamondBurnTime)*20;
            }
        });
    }
}
