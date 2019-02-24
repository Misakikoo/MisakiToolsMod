package com.github.misakikoo.misakitools.common.skill;

import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;
import java.util.List;


public class Skill {

    private final String name;
    private List<IActionListener> pressListenerList = new ArrayList<>();
    private List<IActionListener> releaseListenerList = new ArrayList<>();

    public Skill(String name) {
        this.name = name;
    }

    public String getSkillName() {
        return name;
    }

    public Skill addKeyPressListener(IActionListener listener) {
        pressListenerList.add(listener);
        return this;
    }

    public Skill addReleaseListener(IActionListener listener) {
        releaseListenerList.add(listener);
        return this;
    }

    public void onKeyPress(EntityPlayer player) {
        for(IActionListener lis:pressListenerList) lis.onAction(player);
    }

    public void onKeyRelease(EntityPlayer player) {
        for(IActionListener lis:releaseListenerList) lis.onAction(player);
    }

    public static interface IActionListener {
        void onAction(EntityPlayer player);
    }
}
