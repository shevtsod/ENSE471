package com.shevtsod;

/**
 * FILENAME: Form.java
 *
 * PURPOSE:
 *  Item holds menu item details
 *
 * CLASS: ENSE471
 * ASSIGNMENT: lab2
 * DATE: Feb. 02, 2017
 *
 * NAME: Daniel Shevtsov
 * SID: 200351253
 */
public class Item {
    private String title;
    private String description;
    private double price;

    /**
     * Default constructor
     */
    public Item() {
        title = "Default Item";
        description = "Default description";
        price = 0.00;
    }

    /**
     * Overloaded constructor
     * @param title Title of the item
     * @param description Description of the item
     * @param price Price of the item
     */
    public Item(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
