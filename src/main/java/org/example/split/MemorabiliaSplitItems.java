package org.example.split;

import org.example.data.ItemType;

public class MemorabiliaSplitItems extends SplitItem {

    private static final int MAX_ITEMS = 2;
    public MemorabiliaSplitItems(int maxValue) {
        super(maxValue);
    }

    @Override
    public int getMaxItemsOfType() {
        return MAX_ITEMS;
    }

    @Override
    public ItemType getItemType() {
        return ItemType.Memorabilia;
    }

}
