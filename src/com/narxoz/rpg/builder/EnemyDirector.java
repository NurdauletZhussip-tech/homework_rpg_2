package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private EnemyBuilder builder;
    public void setBuilder(EnemyBuilder builder) {
        this.builder = builder;
    }
    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Minion")
                .setHealth(100)
                .setDamage(10)
                .setDefense(5)
                .setSpeed(20)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }
    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Elite Warrior")
                .setHealth(300)
                .setDamage(35)
                .setDefense(20)
                .setSpeed(30)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }
    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Ancient Dragon Boss")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .addPhase(1, 50000)
                .addPhase(2, 25000)
                .addPhase(3, 10000)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }
}