package com.github.misakikoo.misakitools.potion;

import com.github.misakikoo.misakitools.MisakiToolsMod;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;


public class PotionExplosion extends Potion {
    public static final ResourceLocation res = new ResourceLocation(MisakiToolsMod.MODID + ":" + "textures/gui/potion.png");
    public PotionExplosion() {
        super(true, 0x000000);
        this.setPotionName("potion.explosion");
        this.setIconIndex(0, 0);
    }

}

