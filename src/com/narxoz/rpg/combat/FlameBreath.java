package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    @Override
    public String getName() {
        return "Flame Breath";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "AoE damage + burn";
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}