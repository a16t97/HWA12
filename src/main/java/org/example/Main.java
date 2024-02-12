package org.example;

import org.example.transport.Bike;
import org.example.transport.Bus;
import org.example.transport.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger;
    private static final String fileName = "src/main/resources/transport.csv";

    static String[] readFileUsingBufferedReader(String filename) {
        ArrayList<String> data = new ArrayList<String>();
        FileReader reader;

        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        var br = new BufferedReader(reader);
        String newLine;

        try {
            while ((newLine = br.readLine()) != null) {
                data.add(newLine);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Arrays.copyOf(data.toArray(), data.size(), String[].class);
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file", System.getenv("CONFIG_FILENAME"));
        logger = Logger.getLogger(Main.class.getName());

        logger.log(Level.CONFIG, "Starting to read data from file: " + fileName);
        String[] data = readFileUsingBufferedReader(fileName);
        logger.log(Level.CONFIG, "Read data from file: " + fileName);
        createTransportObject(data);
        logger.log(Level.CONFIG, "Finished processing, imported " + (data.length - 1) + " files");
    }

    private static void createTransportObject(String[] data) {
        for (int c = 1; c < data.length; c++) {
            var pieces = data[c].split(";"); // method split - щоб "побити" строку на підстроку
            LandTrans transport = null;
            try {
                switch (pieces[1].toLowerCase()) {
                    case "bus":
                        Bus bus = new Bus(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                        logger.log(Level.SEVERE, "Created new Bus: " + bus);
                        break;
                    case "car":
                        Car car = new Car(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                        logger.log(Level.FINE, "Created new Car: " + car);
                        break;
                    case "bike":
                        Bike bike = new Bike(Integer.parseInt(pieces[0]), pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Boolean.parseBoolean(pieces[5]));
                        logger.log(Level.INFO, "Created new Bike: " + bike);
                        break;
                    default:
                        logger.log(Level.WARNING, "Unknown type of transport: " + pieces[1]);
                        break;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                logger.log(Level.SEVERE, "Failed to create transport object: " + e.getMessage(), e);
            }
        }
    }
}