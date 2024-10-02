package org.launchcode;

public class Main {

    public static void main(String[] args) {

        // MenuItem(String name, double price, String category, String description)
        MenuItem saucy1 = new MenuItem("Cheese Aioli Fries", 6.50, "APPETIZERS", "Seasoned crinkle-cut fries with house-made spice mix, topped with chihuahua cheese, jalapeno aioli and scallions.");
        MenuItem saucy2 = new MenuItem("Tostones (Curry Aioli)", 6.00, "APPETIZERS", "Twice fried green plantains topped with pineapple salsa and scallions, served with curry aioli ");
        MenuItem saucy3 = new MenuItem("Puerto Rican Rice Bowl", 15.25, "RICE BOWLS", "Jasmine rice with sazon seasoning, sauteed with edamame beans, carrots, bean sprouts, scallions and choice of protein:");
        MenuItem saucy4 = new MenuItem("Picadillo Rice Bowl ", 14.50, "RICE BOWLS", "Slow cooked ground beef seasoned with tomato sauce, served with jasmine coconut rice, topped with a sunny-side fried egg.");
        MenuItem saucy5 = new MenuItem("Beef Baco", 4.85, "BACOS", "Beef Ropa Vieja with kimchi, served on a steamed bao bun.");
        MenuItem saucy6 = new MenuItem("Guajillo Pork Baco", 4.00, "BACOS", "Guajillo marinated pork topped with pineapple salsa and served on a steamed bao bun.");

        // Check item creation
        System.out.println(saucy1);
        System.out.println(saucy3);

        // CREATE MENU
        Menu menuPorka = new Menu();

        menuPorka.addItem(saucy1);
        menuPorka.addItem(saucy2);
        menuPorka.addItem(saucy3);
        menuPorka.addItem(saucy4);
        menuPorka.addItem(saucy5);
        menuPorka.addItem(saucy6);

        // Print specific menu
        String menuOption = menuPorka.toStringCategory("BACOS");
        System.out.println(menuOption);

        // Print whole menu
        System.out.println(menuPorka);
    }

}
