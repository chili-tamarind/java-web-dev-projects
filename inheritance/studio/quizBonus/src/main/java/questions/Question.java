package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public abstract class Question {

    private final String question;
    private final HashMap<String, Choice> choiceMap = new HashMap<>();
    private int wordCount;

    private  int maxResponses = 1;
    private final String newline = System.lineSeparator();

    // Constructor - For questions with choices
    public Question(String question, Choice[] choiceArray) {
        this.question = question;
        createRandomizedChoiceMap(choiceArray);
    }

    // Constructor - For questions without choices
    public Question(String question) {
        this.question = question;
    }

    // Constructor - For essay
    public Question(String question, int wordCount) {
        this.question = question;
        this.wordCount = wordCount;
    }

    // Constructor - For TrueFalse
    public Question(String question, boolean answer) {
        this.question = question;

        Choice[] choiceArray;
        if (answer) {
            choiceArray = new Choice[]{
                    new Choice("True", true),
                    new Choice("False")};
        } else {
            choiceArray = new Choice[]{
                    new Choice("True"),
                    new Choice("False", true)};
        }
        createRandomizedChoiceMap(choiceArray);
    }

    // GETTERS
    public String getQuestion() { return question; }
    public HashMap<String, Choice> getChoiceMap() {
        return choiceMap;
    }
    public int getMaxResponses() {
        return maxResponses;
    }
    public void setMaxResponses(int maxResponses) {
        this.maxResponses = maxResponses;
    }
    public int getWordCount() {return wordCount;}

    @Override
    public abstract String toString();

    void createRandomizedChoiceMap(Choice[] choiceArray){
        ArrayList<Choice> choiceList = new ArrayList<>();

        Collections.addAll(choiceList, choiceArray); // Compiles questions
        Collections.shuffle(choiceList);

        for (int i=0; i < choiceList.size(); i++){
            choiceMap.put(String.valueOf(i+1), choiceList.get(i));
        }
    }

    String getFormattedChoices() {
        StringBuilder formattedChoices = new StringBuilder();
        String newline = System.lineSeparator();
        char letter = 'A'; // One char lower than A

        for (String letterChoice: choiceMap.keySet()) {
            String choice = "\t[" + letter + "] " + choiceMap.get(letterChoice).getContent() + newline;
            formattedChoices.append(choice);
            letter++;
        }
        return formattedChoices.toString();
    }

    public ArrayList<String> getListofOptions() {
        int letterOptionsLength = choiceMap.size() - 1;
        ArrayList<String> letterOptions = new ArrayList<>();
        letterOptions.add("A");

        for (int i = 1; i <= letterOptionsLength; i++) {
            char letter = (char) ('A' + i);
            letterOptions.add(String.valueOf(letter));
        }
        return letterOptions;
    }

    public boolean isInvalid(String userAnswer) {
        ArrayList<String> letterOptions = getListofOptions();

        if (letterOptions.contains(userAnswer.toUpperCase())) {
            return true;
        } else {
            System.out.println("Error: That is not a valid input!" + newline);
            return false;
        }
    }

}
