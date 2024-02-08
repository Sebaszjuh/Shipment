package org.example.io;

import org.example.data.Item;
import org.example.data.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader {

    private final Scanner sc;
    private final List<Item> listOfNewItems;
    private final List<String> listOfUnprocessedItems;
    private static final String SPLIT_DENOMINATOR = ",";

    public CsvReader() {
        listOfNewItems = new ArrayList<>();
        listOfUnprocessedItems = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void readLines() {
        int counter = 0;
        while (counter < 3 && sc.hasNext()) {
            String unprocessedItem = sc.nextLine();
            listOfUnprocessedItems.add(unprocessedItem);
            counter++;
        }
        System.out.println(listOfUnprocessedItems.size());
        sc.close();
    }

    public void processUnprocessedItems() {
        for (String unprocessedItem: listOfUnprocessedItems) {
            processItemStringIntoItem(unprocessedItem);
        }
    }

    public void processItemStringIntoItem(String unprocessItems) {
        if (!isValidItem(unprocessItems)) {
            return;
        }
        processUnprocessItemString(unprocessItems);
    }

    public void processUnprocessItemString(String unprocessItems){
        String[] splitUnprocessItem = unprocessItems.split(SPLIT_DENOMINATOR);
        int quantity = Integer.parseInt(splitUnprocessItem[0]);
        ItemType type = ItemType.valueOf(splitUnprocessItem[1]);
        int unitPrice = Integer.parseInt(splitUnprocessItem[2]);

        for(int i = 0; i < quantity; i++) {
            Item item = new Item(unitPrice, type);
            listOfNewItems.add(item);
        }
        System.out.println(listOfNewItems.size());
    }

    private boolean isValidItem(String unprocessedItem) {
        return true;
    }

    public List<Item> getListOfItems(){
        return listOfNewItems;
    }
}
