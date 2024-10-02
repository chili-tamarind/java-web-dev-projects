package org.launchcode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Menu {
    private ArrayList<MenuItem> menuItems;
    private LocalDate lastUpdated;

    // CONSTRUCTOR
    public Menu() {
        this.menuItems = new ArrayList<>();
        this.lastUpdated = LocalDate.now(); // set the current date when the menu is created
    }

    // Method to add a menu item
    public void addMenuItem(MenuItem item) {
        if (!menuItems.contains(item)) {
            menuItems.add(item);
            updateLastUpdated(); // update the menu's last updated date
        }
    }

    // Method to remove a menu item
    public void removeMenuItem(MenuItem item) {
        menuItems.remove(item);
        updateLastUpdated(); // update the menu's last updated date
    }

    // Method to update the lastUpdated field
    private void updateLastUpdated() {
        this.lastUpdated = LocalDate.now();
    }

    // Getter for lastUpdated
    public LocalDate getLastUpdated() {
        return lastUpdated;
    }


    // SPECIAL METHODS


    // Print entire menu
    @Override
    public String toString() {

        StringBuilder menu = new StringBuilder();
        menu.append("\n******************* SAUCY PORKA APPETIZERS *******************\n")
            .append(toStringCategory("Appetizers"))
            .append(toStringCategory("Rice Bowls"))
            .append(toStringCategory("Bacos"));

        return menu.toString();
    }

    // Print specific category
    public String toStringCategory(String categoryMenu) {
        StringBuilder category = new StringBuilder();

        category.append("\n----------\n")
                .append(categoryMenu.toUpperCase())
                .append("\n----------");

        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(categoryMenu)) { // Use equalsIgnoreCase for case-insensitive comparison
                category.append("\n").append(item.toString());
            }
        }
        return category.toString();
    }

    // Add item to menu
    public void addItem(MenuItem newItem) {

        // BONUS - Prevent duplicates
        String addError = "This item is already in the menu!";
        if (menuItems.contains((newItem))) {
            System.out.println(addError);
            return;
        }

        for (MenuItem item : menuItems) {
            if(item.equals(newItem)) {
                System.out.println(addError);
                return;
            }
        }

        menuItems.add(newItem);
        lastUpdated = LocalDate.now();
    }

    // Remove item to menu
    void removeItem(MenuItem newItem) {
        menuItems.remove(newItem);
        lastUpdated = LocalDate.now();
    }

    // Display the entire menu
    public void displayMenu() {
        for (MenuItem item : menuItems) {
            System.out.println(item.toString());
        }
        System.out.println("Menu last updated: " + lastUpdated);
    }

    // Display items by category
    public void displayByCategory(String category) {
        for (MenuItem item : menuItems) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println(item.toString());
            }
        }
    }

}