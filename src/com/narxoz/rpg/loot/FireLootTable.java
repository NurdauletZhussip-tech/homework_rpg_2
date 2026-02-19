package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable {
    private List<String> items;

    public FireLootTable() {
        this.items = new ArrayList<>(Arrays.asList("Fire Gem", "Dragon Scale", "Flame Rune"));
    }

    private FireLootTable(List<String> itemsToCopy) {
        this.items = new ArrayList<>(itemsToCopy);
    }

    @Override
    public List<String> getItems() {
        return this.items;
    }

    @Override
    public int getGoldDrop() {
        return 200;
    }

    @Override
    public int getExperienceDrop() {
        return 500;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(this.items);
    }
}