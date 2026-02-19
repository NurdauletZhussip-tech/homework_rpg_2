package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    @Override public String getName() { return "Shadow Strike"; }
    @Override public int getDamage() { return 60; }
    @Override public String getDescription() { return "High critical damage from shadows"; }
    @Override public Ability clone() { return new ShadowStrike(); }
}