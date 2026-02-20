/*package com.narxoz.rpg.enemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;

public class Goblin extends Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
    }

     public Enemy clone() {
         Goblin copy = new Goblin(this.name);
         copy.health = this.health;
         copy.damage = this.damage;
         copy.defense = this.defense;
         copy.speed = this.speed;
         copy.abilities = new ArrayList<>();
         for (Ability a : this.abilities) {
             copy.abilities.add(a.clone());
         }
         if (this.lootTable != null) {
             copy.lootTable = this.lootTable.clone();
         }
         return copy;
     }
    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * (1 + (multiplier - 1) * 0.5));
        this.name = "Elite " + this.name;
    }
    public void addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
    }
    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }


}*/
