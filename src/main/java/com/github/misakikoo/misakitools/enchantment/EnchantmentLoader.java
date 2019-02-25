package com.github.misakikoo.misakitools.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class EnchantmentLoader {

    public static Enchantment fireBurn = new EnchantmentFireBurn();

    public EnchantmentLoader() {
        register(fireBurn, "fire_burn");
    }

    private static void register(Enchantment enchantment, String name) {
        ForgeRegistries.ENCHANTMENTS.register(enchantment.setRegistryName(name));
    }
}
