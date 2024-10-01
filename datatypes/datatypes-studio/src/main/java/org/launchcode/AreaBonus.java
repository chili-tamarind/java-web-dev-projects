package org.launchcode;
import java.util.Scanner;

public class AreaBonus {

    public static void main(String[] args) {

        // Input
        Scanner input = new Scanner(System.in);

        // Variables
        boolean validInput = false;
        double numArea = -1;
        double numRadius;

        // do-while loop
        do {
            System.out.print("Enter the radius of the circle (m): ");
            String strRadius = input.nextLine();

            if (!strRadius.trim().isEmpty()) { // 1st level - not empty
                try {

                    if ((numRadius = Double.parseDouble(strRadius)) > 0) { // 2nd level - is a positive number
                        numArea = Circle.getArea(numRadius);
                        validInput = true;
                    }
                    else{
                        System.out.println("> Error: Must be greater than zero");
                    }
                }
                catch (Throwable throwableError) { // Handle any exception or error
                    System.out.println("> Error: Must be a positive number");
                }
            }
            else{
                System.out.println("> Error: Cannot be empty");
            }
        }
        while (!validInput);

        // Result
        String results = String.format("The area of the circle is %.2f m².", numArea);
        System.out.println(results);

        input.close();
    }
}