package com.narxoz.rpg.enemy;

import java.util.Map;
import java.util.TreeMap;

public class DragonBoss extends Enemy {
    private Map<Integer, Integer> phases = new TreeMap<>();
    public void setPhases(Map<Integer, Integer> phases) {
        this.phases = phases;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Boss Phases Configuration:");
        phases.forEach((threshold, phase) ->
                System.out.println(" - Phase " + phase + " starts at " + threshold + " HP"));
        System.out.println("===============================\n");
    }
}