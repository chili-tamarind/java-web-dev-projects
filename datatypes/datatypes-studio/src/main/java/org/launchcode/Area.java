package org.launchcode;
import java.util.Scanner;

public class Area {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius of the circle (m): ");
        double numRadius = input.nextDouble();

        double numArea = Circle.getArea(numRadius);
        String results = String.format("The area of the circle is %.2f m².", numArea);
        System.out.println(results);
    }
}