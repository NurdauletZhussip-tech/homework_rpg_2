package com.narxoz.rpg.loot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable {
    private List<String> items;

    public IceLootTable() {
        this.items = new ArrayList<>(Arrays.asList("Ice Gem", "Frost Scale", "Ice Rune"));
    }

    private IceLootTable(List<String> itemsToCopy) {
        this.items = new ArrayList<>(itemsToCopy);
    }

    @Override public List<String> getItems() { return this.items; }
    @Override public int getGoldDrop() { return 120; }
    @Override public int getExperienceDrop() { return 250; }

    @Override
    public LootTable clone() {
        return new IceLootTable(this.items);
    }
}