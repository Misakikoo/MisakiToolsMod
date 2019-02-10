package com.github.misakikoo.misakitools.block;

import com.github.misakikoo.misakitools.creativetab.CreativeTabsMisakiTools;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

//铬铁矿
public class BlockChromiteOre extends Block {
    public BlockChromiteOre() {
        super(Material.ROCK);//表示方块材质

        this.setLightLevel((float) 7.5);//表示方块光照：岩浆为15 红石火把为7.5
        //this.setBlockUnbreakable();//表示方块硬度为-1 即无法被破坏
        this.setHardness(50.0f);//表示方块硬度：黑曜石50，铁块5，金块3，圆石2，石头1.5，南瓜1，泥土0.5，甘蔗0，基岩-1
        this.setResistance(20);//表示方块爆炸抗性：木头的抗性为4，石头为10，黑曜石为2000，基岩为6000000。
        this.setSoundType(SoundType.STONE);//表示方块踩上去的声音
        this.setHarvestLevel("pickaxe", 2);//pickaxe表示镐子（axe表示斧子 shovel表示铲子） 2表示铁镐以上才能挖掘（3-钻石 1-石 0-木/金）
        //this.setTickRandomly(true);//用于设定方块是（否）会接受随机Tick（如农作物）

        this.setUnlocalizedName("chromiteOre");

        this.setCreativeTab(CreativeTabsMisakiTools.tabMisakiTools);
    }


}
