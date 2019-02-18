package com.github.misakikoo.misakitools.common.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public class PlayerJumpEvent extends PlayerEvent{
    public final BlockPos pos;
    public final World world;

    public PlayerJumpEvent(EntityPlayer player, BlockPos pos, World world){
        super(player);
        this.pos = pos;
        this.world = world;
    }

    //place a Primed TNT
    public void placeTNTPrimed() {
        if(!this.isCanceled() && !world.isRemote) {
            Entity tnt = new EntityTNTPrimed(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, null);
            world.spawnEntity(tnt);
        }
    }

}
