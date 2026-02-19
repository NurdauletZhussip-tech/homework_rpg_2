package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Enemy {
        private String name;
        private int health;
        private int damage;
        private int defense;
        private int speed;
        private String element = "NORMAL";

        private List<Ability> abilities = new ArrayList<>();
        private LootTable lootTable;
        private String aiBehavior = "PASSIVE";

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getHealth() { return health; }
        public void setHealth(int health) { this.health = health; }

        public int getDamage() { return damage; }
        public void setDamage(int damage) { this.damage = damage; }

        public int getDefense() { return defense; }
        public void setDefense(int defense) { this.defense = defense; }

        public int getSpeed() { return speed; }
        public void setSpeed(int speed) { this.speed = speed; }

        public String getElement() { return element; }
        public void setElement(String element) { this.element = element; }

        public List<Ability> getAbilities() { return abilities; }
        public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }

        public LootTable getLootTable() { return lootTable; }
        public void setLootTable(LootTable lootTable) { this.lootTable = lootTable; }

        public String getAiBehavior() { return aiBehavior; }
        public void setAiBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; }

        public Enemy clone() {
            Enemy copy = new Enemy();
            copy.setName(this.name);
            copy.setHealth(this.health);
            copy.setDamage(this.damage);
            copy.setDefense(this.defense);
            copy.setSpeed(this.speed);
            copy.setElement(this.element);
            copy.setAiBehavior(this.aiBehavior);

            List<Ability> copiedAbilities = new ArrayList<>();
            if (this.abilities != null) {
                for (Ability ability : this.abilities) {
                    copiedAbilities.add(ability.clone());
                }
            }
            copy.setAbilities(copiedAbilities);

            if (this.lootTable != null) {
                copy.setLootTable(this.lootTable.clone());
            }

            return copy;
        }
        public void displayInfo() {
            System.out.println("=== " + name + " [" + element + "] ===");
            System.out.println("HP: " + health + " | DMG: " + damage + " | DEF: " + defense + " | SPD: " + speed);
            System.out.println("AI Behavior: " + aiBehavior);
            System.out.print("Abilities: ");
            for (Ability a : abilities) {
                System.out.print(a.getName() + " ");
            }
            System.out.println();
            if (lootTable != null) {
                System.out.println("Loot Drops: " + lootTable.getItems() + " (" + lootTable.getGoldDrop() + " Gold)");
            }
            System.out.println("===============================\n");
        }
    }

