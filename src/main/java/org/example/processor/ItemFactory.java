package org.example.processor;

import org.example.data.ItemType;
import org.example.split.CardsSplitItems;
import org.example.split.MemorabiliaSplitItems;
import org.example.split.SplitItem;

public class ItemFactory {

    public static SplitItem getSplitItemProcessor(ItemType itemType, int maxValue) {
        return switch (itemType) {
            case Memorabilia -> new MemorabiliaSplitItems(maxValue);
            case Card -> new CardsSplitItems(maxValue);
            default -> throw new IllegalArgumentException("Unknown Itemtype:" + itemType);
        };
    }
}
