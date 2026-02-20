package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.EnemyRegistry;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        createThemeDemo(fireFactory, "FIRE");
        createThemeDemo(iceFactory, "ICE");
        createThemeDemo(shadowFactory, "SHADOW");

        System.out.println("[Consistency Check]: Abstract Factory ensures that a Fire enemy cannot accidentally receive Ice loot.\n");


        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        System.out.println("Building a Custom Raid Boss...");
        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 10000)
                .build();

        dragon.displayInfo();
        EnemyDirector director = new EnemyDirector();
        director.setBuilder(new BasicEnemyBuilder());

        System.out.println("Director creating a standard Ice Elite:");
        Enemy iceElite = director.createElite(iceFactory);
        iceElite.setElement("ICE");
        iceElite.displayInfo();

        System.out.println("[Design Note]: build() is the Factory Method. Director delegates 'how' to build to the Builder interface.\n");

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();

        registry.addTemplate("fire-dragon-base", dragon);
        registry.addTemplate("ice-elite-base", iceElite);

        System.out.println("Cloning template to create a Mythic variant...");
        Enemy mythicDragon = registry.getEnemy("fire-dragon-base");
        mythicDragon.setName("Mythic Fire Dragon");
        mythicDragon.setHealth(mythicDragon.getHealth() * 3);

        mythicDragon.displayInfo();

        demonstrateDeepCopy(dragon, mythicDragon);

        EnemyComponentFactory sFactory = new ShadowComponentFactory();

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setAbilities(sFactory.createAbilities())
                .setLootTable(sFactory.createLootTable())
                .setAI(sFactory.createAIBehavior())
                .build();

        registry.addTemplate("demon-lord-template", demonLord);

        Enemy questDemon = registry.getEnemy("demon-lord-template");
        questDemon.setName("Weakened Shadow Demon (Quest Variant)");
        questDemon.setHealth(5000);

        System.out.println("Final Integrated Pipeline Result (Shadow Theme + Builder + Prototype):");
        questDemon.displayInfo();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("1. Abstract Factory: Themed component families (Fire, Ice, Shadow)");
        System.out.println("2. Builder: Complex step-by-step construction with Fluent Interface");
        System.out.println("3. Factory Method: Embedded in Builder.build() and Director");
        System.out.println("4. Prototype: Efficient template cloning with Deep Copy logic");

        System.out.println("\n=== Demo Complete ===");
    }

    private static void createThemeDemo(EnemyComponentFactory factory, String themeName) {
        System.out.println(">>> Theme: " + themeName);
        List<Ability> abilities = factory.createAbilities();
        LootTable loot = factory.createLootTable();
        String ai = factory.createAIBehavior();

        System.out.println("  Abilities: " + abilities.get(0).getName() + ", " + abilities.get(1).getName());
        System.out.println("  Loot Items: " + loot.getItems());
        System.out.println("  AI Behavior: " + ai);
        System.out.println();
    }

    private static void demonstrateDeepCopy(Enemy original, Enemy clone) {
        System.out.println("--- Deep Copy Verification ---");
        System.out.println("Original Name: " + original.getName() + " | HP: " + original.getHealth());
        System.out.println("Clone Name:    " + clone.getName() + " | HP: " + clone.getHealth());

        if (original.getAbilities() != clone.getAbilities()) {
            System.out.println("SUCCESS: Ability lists are different object references.");
        } else {
            System.out.println("FAILURE: Ability lists point to the same memory address!");
        }

        if (original.getLootTable() != clone.getLootTable()) {
            System.out.println("SUCCESS: Loot tables are independent objects.");
        } else {
            System.out.println("FAILURE: Shallow copy detected in LootTable!");
        }
        System.out.println();
    }
}