package com.github.misakikoo.misakitools.item;

import com.github.misakikoo.misakitools.MisakiToolsMod;
import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;


public class ItemRedstoneArmor extends ItemArmor {

    public static final ItemArmor.ArmorMaterial REDSTONE_ARMOR = EnumHelper.addArmorMaterial("REDSTONE",
            MisakiToolsMod.MODID + ":" + "redstone", 10, new int[]
                    { 2, 6, 4, 2 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F );

    public ItemRedstoneArmor(EntityEquipmentSlot equipmentSlot) {
        super(REDSTONE_ARMOR, REDSTONE_ARMOR.ordinal(), equipmentSlot);
    }

    public static class Helmet extends ItemRedstoneArmor {
        public Helmet() {
            super(EntityEquipmentSlot.HEAD);
            this.setUnlocalizedName("redstoneHelmet");
            this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
        }
    }

    public static class Chestplate extends ItemRedstoneArmor {
        public Chestplate() {
            super(EntityEquipmentSlot.CHEST);
            this.setUnlocalizedName("redstoneChestplate");
            this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
        }
    }

    public static class Leggings extends ItemRedstoneArmor {
        public Leggings() {
            super(EntityEquipmentSlot.LEGS);
            this.setUnlocalizedName("redstoneLeggings");
            this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
        }
    }

    public static class Boots extends ItemRedstoneArmor {
        public Boots() {
            super(EntityEquipmentSlot.FEET);
            this.setUnlocalizedName("redstoneBoots");
            this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
        }
    }
}
