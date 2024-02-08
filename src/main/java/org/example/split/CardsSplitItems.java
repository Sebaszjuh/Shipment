package org.example.split;

import org.example.data.ItemType;

public class CardsSplitItems extends SplitItem {

    private static final int MAX_ITEMS = 50;

    public CardsSplitItems(int maxValue) {
        super(maxValue);
    }

    @Override
    public int getMaxItemsOfType() {
        return MAX_ITEMS;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.Card;
    }

    //TODO might increase processItem here if we want to combine cards & an additional item type
}
