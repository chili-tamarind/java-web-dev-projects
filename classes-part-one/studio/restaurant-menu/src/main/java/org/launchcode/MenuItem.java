package org.launchcode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class MenuItem {

    private final LocalDate dateAdded; // a fixed value
    private String name;
    private double price;
    private String description;
    private String category; // e.g., appetizer, main course, dessert
    private boolean isNew; // indicates if the menu item is new

    // CONSTRUCTOR
    public MenuItem(String name, double price, String category, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;

        this.dateAdded = LocalDate.now();
        this.isNew = isNew();
    }

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isNew() {
        LocalDate today = LocalDate.now();
        LocalDate dateAdded = getDateAdded();

        if (dateAdded == null) { // Handle the case where dateAdded is null
            return false;
        }

        double daysBetween = getDateAdded().until(today, ChronoUnit.DAYS); // count number of days since last added
        return (daysBetween < 90);
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    // SPECIAL METHODS

    @Override
    public String toString() {
        String newText = isNew ? " - NEW!" : "";
        String priceDecimal = String.format("%.2f", price);

        return "\n" + name.toUpperCase() + newText
                + "\n*********************************************"
                + "\n" + description + "\n$" + priceDecimal + "\t\t[" + category + "]";

    }

    // equals and hashCode methods for comparison
    @Override
    public boolean equals(Object toBeCompared) {

        if (this == toBeCompared) return true;
        if (toBeCompared == null || getClass() != toBeCompared.getClass()) return false;

        // Casting
        MenuItem otherItem = (MenuItem) toBeCompared;
        return this.name.equals(otherItem.name) && category.equals(otherItem.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}