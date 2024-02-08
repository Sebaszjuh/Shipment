package org.example.io;

import org.example.data.Shipment;

import java.util.List;

public class CsvWriter {
    private static final String FORMAT = "%s, %s, %s";

    public CsvWriter() {}

    public void writeCsvShipment(List<Shipment> listOfShipments){
        for(Shipment shipment: listOfShipments) {
            System.out.println("------SHIPMENTS-----");
            System.out.printf((FORMAT) + "%n", shipment.getTotalItems(), shipment.getItemType(), shipment.getTotalValue());
            System.out.println("----------------------");
        }

    }
}
