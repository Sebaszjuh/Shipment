package org.example.processor;

import org.example.data.Item;
import org.example.data.ItemType;
import org.example.data.Shipment;
import org.example.io.CsvReader;
import org.example.io.CsvWriter;
import org.example.split.SplitItem;

import java.util.ArrayList;
import java.util.List;

public class ShipmentProcessor {
    private final CsvReader csvReader;
    private final CsvWriter csvWriter;
    private List<Item> listOfItems;

    private final List<Shipment> listOfShipments;

    public ShipmentProcessor(CsvReader csvReader, CsvWriter csvWriter) {
        this.listOfShipments = new ArrayList<>();
        this.csvReader = csvReader;
        this.csvWriter = csvWriter;
    }

    public void processShipment(int maxValue) {
        readLines();
        splitItemIntoShipment(maxValue);
        writeLines();
    }

    private void readLines() {
        try {
            csvReader.readLines();
            csvReader.processUnprocessedItems();
            listOfItems = csvReader.getListOfItems();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Failed to process shipment");
        }
    }

    private void writeLines() {
        csvWriter.writeCsvShipment(listOfShipments);
    }

    private void splitItemIntoShipment(int maxValue) {
        for (ItemType type : ItemType.values()) {
            SplitItem splitItem = ItemFactory.getSplitItemProcessor(type, maxValue);
            splitItem.processItem(getListOfItems(), listOfShipments);
        }
    }

    private List<Item> getListOfItems() throws IllegalArgumentException {
        if (listOfItems == null) {
            throw new IllegalArgumentException("List of items is null");
        }
        return listOfItems;
    }
}
