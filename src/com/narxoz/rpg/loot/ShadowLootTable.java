package com.narxoz.rpg.loot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private List<String> items;

    public ShadowLootTable() {
        this.items = new ArrayList<>(Arrays.asList("Shadow Gem", "Dark Essence", "Shadow Rune"));
    }

    private ShadowLootTable(List<String> itemsToCopy) {
        this.items = new ArrayList<>(itemsToCopy);
    }

    @Override public List<String> getItems() { return this.items; }
    @Override public int getGoldDrop() { return 300; }
    @Override public int getExperienceDrop() { return 600; }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(this.items);
    }
}
