package com.narxoz.rpg.combat;

public class Blizzard implements Ability {
    @Override public String getName() { return "Blizzard"; }
    @Override public int getDamage() { return 100; }
    @Override public String getDescription() { return "Massive ice storm, high freeze chance"; }
    @Override public Ability clone() { return new Blizzard(); }
}
