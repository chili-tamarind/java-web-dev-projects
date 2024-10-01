package org.launchcode;
import java.util.Scanner;

public class AreaInput {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle (m): ");
        double numRadius = input.nextDouble();

        double numArea = Math.PI * Math.pow(numRadius, 2); // Raise to power

        String results = String.format("The area of the circle is %.2f m\u00B2.", numArea);
        System.out.println(results);
    }
}