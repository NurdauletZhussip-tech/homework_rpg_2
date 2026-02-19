package com.narxoz.rpg.combat;

public class DarkNova implements Ability {
    @Override public String getName() { return "Dark Nova"; }
    @Override public int getDamage() { return 120; }
    @Override public String getDescription() { return "Explosion of void energy"; }
    @Override public Ability clone() { return new DarkNova(); }
}