import questions.CheckBox;
import questions.Essay;
import questions.LinearScale;
import questions.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class SurveyGenerator extends QuizGenerator {
    private final ArrayList<String> allResponses = new ArrayList<>();
    private String newline = System.lineSeparator();

    ArrayList<String> getAllResponses() {
        return allResponses;
    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);

        for (Question question : getQuestions()) {
            int q = 0;
            String content;

            System.out.println(question);

            do{
                System.out.print(newline + "Enter the letter to answer: ");
                String userAnswer = input.nextLine();

                if (userAnswer.equalsIgnoreCase("Submit")){
                    break;
                } else {
                    while (question.isInvalid(userAnswer)){
                        System.out.println(newline + "Error: That response is invalid!");
                        userAnswer = input.nextLine();
                    }
                    System.out.println("Response submitted");
                }

                // For essay and linear scale
                if (question instanceof Essay || question instanceof LinearScale) {
                    content = userAnswer;
                } else {
                    ArrayList<String> letterOptions = question.getListofOptions();
                    String userAnswerValidInt = String.valueOf(letterOptions.indexOf(userAnswer)+1);
                    content = question.getChoiceMap().get(userAnswerValidInt).getContent();
                }

                String contentResponse = question.getQuestion() + ": " + content;
                allResponses.add(contentResponse);
                q++;

                if (question instanceof CheckBox && q < question.getMaxResponses()) {
                    System.out.println("Select another option or enter SUBMIT");
                }

            } while (q < question.getMaxResponses());
        }

        input.close();
    }
}
