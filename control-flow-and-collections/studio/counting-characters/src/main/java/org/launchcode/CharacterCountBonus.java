package org.launchcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCountBonus {

    // Prompt the user to enter the string in the command line.
    // Make the character counts case-insensitive.
    // Exclude non-alphabetic characters.

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string below");
        String testString = input.nextLine();
        testString = testString.toUpperCase(); // To uppercase

        char[] charactersInString = testString.toCharArray();

        HashMap<Character, Integer> letterCount = new HashMap<>();

        for (char achar : charactersInString) {
            if (Character.isAlphabetic(achar)) {
                if (!letterCount.containsKey(achar)) {
                    letterCount.put(achar, 1);
                } else {
                    letterCount.put(achar, letterCount.get(achar) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> outputLetter : letterCount.entrySet()) {
            System.out.println(outputLetter.getKey() + ": " + outputLetter.getValue());
        }
    }
}