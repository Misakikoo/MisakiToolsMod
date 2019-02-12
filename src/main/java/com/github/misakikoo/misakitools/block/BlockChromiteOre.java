package com.github.misakikoo.misakitools.block;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockChromiteOre extends Block {
    public BlockChromiteOre() {
        super(Material.ROCK);//Rock is stone

        this.setLightLevel((float) 7.5);//Light: magma 15, redstone_torch 7.5
        //this.setBlockUnbreakable();//Hardness == -1, it means Can't be Destroyed
        this.setHardness(50.0f);//Hardness: obsidian is 50, ironBlock 5, goldBlock 3, cobbleStone 2, stone 1.5, pumpkin 1, dirt 0.5, sugerCane 0, bedrock -1
        this.setResistance(20);//Explosion resistance: mood 4，stone 10, obsidian 2000, bedrock 6000000.
        this.setSoundType(SoundType.STONE);//The sound of stepping on it
        this.setHarvestLevel("pickaxe", 2);//[pickaxe,axe,shovel],[3-diamond,2-iron,1-stone,0-wood/gold]
        //this.setTickRandomly(true);//The block (don't)accept random Tick (such as crops)

        this.setUnlocalizedName("chromiteOre");

        this.setCreativeTab(CreativeTabsLoader.tabMisakiTools);
    }


}
