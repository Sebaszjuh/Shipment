package org.example.data;

public class Item {

    private final int value;
    private final ItemType type;

    public Item(int value, ItemType type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public ItemType getItemType() {
        return type;
    }
}
