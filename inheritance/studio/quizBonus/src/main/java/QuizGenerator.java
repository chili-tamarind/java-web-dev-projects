import questions.Choice;
import questions.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizGenerator {

    private final ArrayList<Question> questions = new ArrayList<>();
    private int numCorrect;
    private String newline = System.lineSeparator();

    // Default constructor is sufficient

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void addQuestions(Question[] questionArray) {
        // Add list of questions into array
        Collections.addAll(questions, questionArray);
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        Collections.shuffle(questions);

        for (Question question : questions) {

            // Print question for user
            System.out.println(question);

            // Evaluate answers
            ArrayList<String> userAnswerAll = new ArrayList<>();

            int q = 0;
            while (q < question.getMaxResponses()) {

                // Variables
                String userAnswer;
                String userAnswerValidInt;
                ArrayList<String> letterOptions = question.getListofOptions();

                // Get valid response
                do {
                    System.out.print(newline + "Enter the letter to answer: ");
                    userAnswer = input.nextLine().toUpperCase();
                } while (!question.isInvalid(userAnswer)); // Predefined method to check that answer is valid

                userAnswerValidInt = String.valueOf(letterOptions.indexOf(userAnswer)+1);

                /*
                System.out.println("A1>>> "+ userAnswerValidInt);
                System.out.println("A2>>> "+ question.getChoiceMap());
                System.out.println("A3>>> "+ question.getChoiceMap().get(userAnswerValidInt));
                System.out.println("A4>>> "+ question.getChoiceMap().get(userAnswerValidInt).isCorrect());
                */

                // Check for duplicate answers
                if (userAnswerAll.contains(userAnswer)) {
                    System.out.println("Error: That answer was already selected!");

                // Wrong answers
                } else if (!question.getChoiceMap().get(userAnswerValidInt).isCorrect()) {
                    {
                        System.out.print("Incorrect: The answer was ");
                        for (Choice choice : question.getChoiceMap().values()) {
                            if (choice.isCorrect()) {
                                System.out.print(choice.getContent() + ",");
                            }
                        }
                        break;
                    }

                // Correct answers
                } else {
                    System.out.println("Correct!");
                    userAnswerAll.add(userAnswer);

                    if (q == (question.getMaxResponses() - 1)) { // Check that all correct answers are selected
                        numCorrect++;
                    }
                    q++;
                }
            }
        }

        input.close(); // Close scanner
    }
}
