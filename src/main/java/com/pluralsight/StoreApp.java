
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
import java.util.Collections;
import java.util.Comparator;

public class StoreApp {

    static final String FILE_NAME = "inventory.csv";
    static final String FILE_NAME1 = "newArrivals.csv";

    public static void main(String[] args) {

        ArrayList<Product> inventory = loadInventory(FILE_NAME);

        System.out.println("\nWelcome to our online store:\n");

        int i = 1;

        // loop to display items in the store
        for(Product product : inventory){

            System.out.println(i + ". ID: " + product.getId() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getDepartment());
            i++;

        }


        // Implement inventory update functionality using data from 'newArrivals.csv'
        // create a file reading functionality for inventory.csv
        try {

            FileReader fileReader1 = new FileReader(FILE_NAME1);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);

            String input; // a String to read each line from newArrivals.csv

            while((input = bufferedReader1.readLine()) != null){

                // extract values from inventory.csv
                String[] tokens = input.split("\\|");

                // validate that the array has the expected size
                if (tokens.length == 4){

                    int id1 = Integer.parseInt(tokens[0]);
                    String description1 = tokens[1];
                    double price1 = Double.parseDouble(tokens[2]);
                    String department1 = tokens[3];

                    // create an instance of the Product class
                    Product product1 = new Product(id1, description1, price1, department1);

                    inventory.add(product1); // add objects to the ArrayList

                }

            }

            bufferedReader1.close();

        } catch (FileNotFoundException e) {

            System.out.println("FileNotFoundException occurred! " + e.getMessage());

        } catch (IOException e){

            System.out.println("IOException occurred! " + e.getMessage());

        }


        // updated inventory
        System.out.println("\nWelcome to our updated online store:\n");

        int j = 1;

        // loop to display items in the store
        for(Product product : inventory){

            System.out.println(j + ". ID: " + product.getId() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getDepartment());
            j++;

        }

        Collections.sort(inventory, new ProductDepartmentComparator());

        // updated inventory
        System.out.println("\nWelcome to our updated online store:\n");

        int k = 1;

        // loop to display items in the store
        for(Product product : inventory){

            System.out.println(k + ". ID: " + product.getId() + " - " + product.getDescription() + " - $" + product.getPrice() + " - " + product.getDepartment());
            k++;

        }

    }

    // method that creates the initial inventory
    public static ArrayList<Product> loadInventory(String file){

        // create the instance the loadInventory() method
        ArrayList<Product> products = new ArrayList<>();

        // create a file reading functionality for inventory.csv
        try {

            FileReader fileReader = new FileReader(file);
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

    // Custom comparator for sorting products by department
    static class ProductDepartmentComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {

            return p1.getDepartment().compareTo(p2.getDepartment());

        }
    }

}
