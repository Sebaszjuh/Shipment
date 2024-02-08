package org.example;

import org.example.io.CsvReader;
import org.example.io.CsvWriter;
import org.example.processor.ShipmentProcessor;


public class Solution {

    public static void main(String[] args) {
        final int maxValue = 500;
        ShipmentProcessor shipmentProcessor = new ShipmentProcessor(new CsvReader(), new CsvWriter());
        shipmentProcessor.processShipment(maxValue);
    }
}
