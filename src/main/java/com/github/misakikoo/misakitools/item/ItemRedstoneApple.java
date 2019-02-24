package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class ItemRedstoneApple extends ItemFood {
    public ItemRedstoneApple() {
        super(5, 0.6F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("redstoneApple");
        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(3),30 * 20, 1));//haste
            player.addPotionEffect(new PotionEffect(Potion.getPotionById(26),30 * 20, 1));//luck
            player.addExperience(10);
        }
        super.onFoodEaten(stack, worldIn, player);
    }
}
