package com.narxoz.rpg.enemy;

import com.narxoz.rpg.enemy.Enemy;
import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> templates = new HashMap<>();

    public void addTemplate(String key, Enemy template) {
        templates.put(key, template);
    }

    public Enemy getEnemy(String key) {
        Enemy template = templates.get(key);
        if (template != null) {
            return template.clone();
        }
        throw new IllegalArgumentException("Template with key " + key + " not found!");
    }

    public Enemy createEliteVariant(String baseKey, String eliteName) {
        Enemy elite = getEnemy(baseKey);

        elite.setName(eliteName);
        elite.setHealth(elite.getHealth() * 2);
        elite.setDamage(elite.getDamage() + 20);
        elite.setDefense(elite.getDefense() + 10);

        return elite;
    }
}