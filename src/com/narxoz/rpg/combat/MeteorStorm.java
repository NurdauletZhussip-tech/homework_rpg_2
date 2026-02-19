package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    @Override
    public String getName() {
        return "Meteor Storm";
    }

    @Override
    public int getDamage() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Ultimate, high AoE damage";
    }

    @Override
    public Ability clone() {
        return new MeteorStorm();
    }
}