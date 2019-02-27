package com.github.misakikoo.misakitools.potion;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class PotionLoader {

    public static Potion potionExplosion = new PotionExplosion();

    public PotionLoader(FMLPreInitializationEvent event) {
        register(potionExplosion, "potion_explosion");
    }

    public static void register(Potion potion, String name) {
        ForgeRegistries.POTIONS.register(potion.setRegistryName(name));
    }
}
