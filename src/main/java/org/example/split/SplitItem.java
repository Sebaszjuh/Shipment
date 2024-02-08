package org.example.split;

import org.example.data.Item;
import org.example.data.ItemType;
import org.example.data.Shipment;

import java.util.ArrayList;
import java.util.List;

public abstract class SplitItem {

    protected final int maxValue;

    public SplitItem(int maxValue) {
        this.maxValue = maxValue;
    }

    public void processItem(List<Item> listOfItems, List<Shipment> listOfShipments) {
        List<Item> filteredItems = getItemOfType(listOfItems);
        List<List<Item>> shipmentItems = new ArrayList<>();
        List<Item> itemList = new ArrayList<>();
        for (Item item : filteredItems) {
            if (itemList.isEmpty()) {
                itemList.add(item);
                continue;
            }
            //Check is we still add an item value wise / max items are reached
            if (isAddedValueValid(itemList, item) && !isMaxItemsReacher(itemList)) {
                itemList.add(item);
            } else {
                addItemsToShipmentList(shipmentItems, itemList, item);

            }
        }
        if (!itemList.isEmpty()) {
            shipmentItems.add(itemList);
        }
        createShipments(shipmentItems, listOfShipments);
    }

    private void createShipments(List<List<Item>> shipmentItems, List<Shipment> listOfShipments) {
        for (List<Item> items : shipmentItems) {
            listOfShipments.add(new Shipment(items));
        }
    }

    private void addItemsToShipmentList(List<List<Item>> shipmentItems, List<Item> itemList, Item item) {
        shipmentItems.add(new ArrayList<>(itemList));
        itemList.clear();
        itemList.add(item);
    }

    public boolean isAddedValueValid(List<Item> itemList, Item item) {
        return itemList.stream().mapToInt(Item::getValue).sum() + item.getValue() <= maxValue;
    }

    public boolean isMaxItemsReacher(List<Item> itemsList) {
        return itemsList.size() >= getMaxItemsOfType();
    }

    public List<Item> getItemOfType(List<Item> listOfItems) {
        return listOfItems.stream()
                .filter(item -> item.getItemType().equals(getItemType()))
                .toList();
    }

    public abstract ItemType getItemType();

    public abstract int getMaxItemsOfType();

}
