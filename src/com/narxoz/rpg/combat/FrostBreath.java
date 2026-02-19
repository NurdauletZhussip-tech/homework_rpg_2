package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    @Override public String getName() { return "Frost Breath"; }
    @Override public int getDamage() { return 30; }
    @Override public String getDescription() { return "Ice damage + freeze effect"; }
    @Override public Ability clone() { return new FrostBreath(); }
}