package org.example.data;

import java.util.List;

public class Shipment {
    private final List<Item> listOfItems;

    public Shipment(List<Item> listOfItmes) {
        this.listOfItems = listOfItmes;
    }

    public int getTotalValue(){
        return listOfItems.stream().mapToInt(Item::getValue).sum();
    }

    public int getTotalItems() {
        return listOfItems.size();
    }

    public String getItemType() {
        //TODO Not sure what to do here, could be improved
        return listOfItems.get(0).getItemType().name();
    }

}
