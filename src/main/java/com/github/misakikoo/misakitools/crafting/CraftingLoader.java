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
        //registerFuel();
    }

    //private static void registerRecipe() {}
        //use .json to register recipe ;l   for mc1.12

    private static void registerSmelting() {
        GameRegistry.addSmelting(BlockLoader.chromiteOre, new ItemStack(ItemLoader.chromeIngot,2 ), 0.5F);
    }

    private static void registerFuel() {
        /*
        use Item#getItemBurnTime to set their item's burn times.
        OR use FurnaceFuelBurnTimeEvent to change burn time
         */

    }
}
