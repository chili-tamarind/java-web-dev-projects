package org.launchcode;

import java.io.FileNotFoundException;
import java.io.File;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCountFileRead {

    public static void main(String[] args) {

        StringBuilder fileText = new StringBuilder();

        try {
            File file = new File("src\\main\\java\\org\\launchcode\\readMeCount.txt"); //  ("readMeCount.txt") >>> Doesn't work
            Scanner fileInput = new Scanner(file);

            while (fileInput.hasNextLine()) {
                String data = fileInput.nextLine();
                fileText.append(data);
            }
                fileInput.close();
            }
        catch (FileNotFoundException e) {
            System.out.println(System.lineSeparator() + "ERROR: File not found!");
        }

        String testString = fileText.toString().toUpperCase();
        char[] charactersInString = testString.toCharArray();

        System.out.println(System.lineSeparator() + "Length of characters " + System.lineSeparator() + charactersInString.length);
        HashMap<Character, Integer> letterCount = new HashMap<>();

        for (char letter : charactersInString) {
            if (Character.isAlphabetic(letter)) {
                if (!letterCount.containsKey(letter)) {
                    letterCount.put(letter, 1);
                } else {
                    letterCount.put(letter, letterCount.get(letter) + 1);
                }
            }
        }

        System.out.println(System.lineSeparator());
        for (Map.Entry <Character, Integer> outputLetter : letterCount.entrySet()) {
            System.out.println(outputLetter.getKey() + ": " + outputLetter.getValue());
        }
    }
}
