package org.launchcode;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {

    public static void main(String[] args) {

        String testString =  "I am the very model if of a modern major general";
        char[] charactersInString = testString.toCharArray();
        System.out.println(charactersInString.length);
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

        for (Map.Entry <Character, Integer> outputLetter : letterCount.entrySet()) {
            System.out.println(outputLetter.getKey() + ": " + outputLetter.getValue());
        }
    }
}

