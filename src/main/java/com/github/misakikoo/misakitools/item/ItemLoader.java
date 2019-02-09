package com.github.misakikoo.misakitools.item;

import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemLoader {
    public static void init() {
        ForgeRegistries.ITEMS.register(new ItemGoldenEgg().setRegistryName("golden_egg"));
    }
}