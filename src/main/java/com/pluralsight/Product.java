package com.pluralsight;

public class Product {

    // private attributes
    private int id;
    private String description;
    private double price;
    private String department;

    // constructor
    public Product(int id, String description, double price, String department) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.department = department;
    }

    // getters of the private attributes
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }
}
