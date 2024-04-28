
// Develop an intuitive online store application capable of seamlessly integrating with your inventory data stored in a file named 'inventory.csv.'
// Additionally, ensure the app facilitates effortless inventory updates by syncing with a file labeled 'newArrivals.csv.'
// This functionality guarantees smooth operations, keeping your store up-to-date with the latest products and inventory levels

// this is an African food store in Pittsburgh, PA

package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreApp {

    static final String FILENAME = "inventory.csv";

    public static void main(String[] args) {

        ArrayList<Product> inventory = loadInventory();

        System.out.println("\nWelcome to our online store:\n");

        int i = 1;

        // loop to display items in the store
        for(Product product : inventory){

            System.out.println(i + ". ID: " + product.getId() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getDepartment());
            i++;

        }

    }

    // method that creates the initial inventory
    public static ArrayList<Product> loadInventory(){

        // create the instance the loadInventory() method
        ArrayList<Product> products = new ArrayList<>();

        // create a file reading functionality for inventory.csv
        try {

            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line; // a String to read each line from inventory.csv

            while((line = bufferedReader.readLine()) != null){

                // extract values from inventory.csv
                String[] parts = line.split("\\|");

                // validate that the array has the expected size
                if (parts.length == 4){

                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    String department = parts[3];

                    // create an instance of the Product class
                    Product product = new Product(id, description, price, department);

                    products.add(product); // add objects to the ArrayList

                }

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("FileNotFoundException occurred! " + e.getMessage());

        } catch (IOException e){

            System.out.println("IOException occurred! " + e.getMessage());

        }

        return products;

    }
}
