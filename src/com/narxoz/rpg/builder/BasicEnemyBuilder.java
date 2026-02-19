package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element = "NORMAL";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;
    private String aiBehavior = "PASSIVE";

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public Enemy build() {
        if (this.name == null || this.name.trim().isEmpty()) {
            throw new IllegalStateException("Enemy must have a valid name!");
        }
        if (this.health <= 0) {
            throw new IllegalStateException("Enemy health must be positive!");
        }
        Enemy enemy = new Enemy();
        enemy.setName(this.name);
        enemy.setHealth(this.health);
        enemy.setDamage(this.damage);
        enemy.setDefense(this.defense);
        enemy.setSpeed(this.speed);
        enemy.setElement(this.element);
        enemy.setAbilities(this.abilities);
        enemy.setLootTable(this.lootTable);
        enemy.setAiBehavior(this.aiBehavior);

        return enemy;
    }
}