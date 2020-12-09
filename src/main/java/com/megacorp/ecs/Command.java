package com.megacorp.ecs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class Command {

    private Perpend perpend;
    private Perpend copperWire;

    public Command() {
        this.perpend = new Perpend();
        this.copperWire = new CopperWire();
    }

    public void addPerpend(int quantity) {
        perpend.addQuantity(quantity);
    }

    public void show() {
        System.out.println("\nThe order contains:\n");
        perpend.show();
        copperWire.show();
    }

    public void save() {
        String id = UUID.randomUUID().toString();
        String header = "id; Date;Perpend Palets;Copper Wire Coils;Copper Wire Meters;";
        String fileName = "./" + LocalDate.now().toString() + "-orders.csv";
        FileWriter fileWriter = null;

        File file = new File(fileName);
        Boolean append = file.isFile();
        try {
            fileWriter = new FileWriter(file, append);
            if (!append) {
                //Write the CSV file header
                fileWriter.append(header);
                //Add a new line separator after the header
                fileWriter.append("\n");
            }
            //Write a the order to the CSV file
            fileWriter.append(id);
            fileWriter.append(";");
            fileWriter.append(LocalDate.now().toString());
            fileWriter.append(";");
            fileWriter.append(String.valueOf(perpend.getQuantity()));
            fileWriter.append(";");
            fileWriter.append(String.valueOf(((CopperWire) copperWire).getWireQuantity().get("coil")));
            fileWriter.append(";");
            fileWriter.append(String.valueOf(((CopperWire) copperWire).getWireQuantity().get("wire")));
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                System.out.println("Order Saved");
            } catch (IOException e) {
                System.out.println("Error !!!");
                e.printStackTrace();
            }
        }
    }

    public void addCopperWire(int quantity) {
        copperWire.addQuantity(quantity);
    }
}
