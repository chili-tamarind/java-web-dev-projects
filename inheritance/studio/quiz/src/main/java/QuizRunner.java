import questions.*;

public class QuizRunner {

    // Create quiz
    private static final QuizGenerator quiz = new QuizGenerator();
    private static String newline = System.lineSeparator();

    public static void main(String[] args) {

        // Create questions - checkbox
        String q1String = "Identify all the animals";
        Choice[] q1Choices = new Choice[]{
                new Choice("Cucumber"),
                new Choice("Banana"),
                new Choice("Chicken", true),
                new Choice("Rabbit", true)};
        CheckBox q1 = new CheckBox(q1String, q1Choices);

        // Create questions - multiple choice
        String q2String = "Which of the following is a color?";
        Choice[] q2Choices = new Choice[]{
                new Choice("Orange",true),
                new Choice("Apple"),
                new Choice("Blueberry")};
        MultipleChoice q2 = new MultipleChoice(q2String, q2Choices);

        // Create questions - true/false
        String q3String = "The earth is flat";
        TrueFalse q3 = new TrueFalse(q3String, false);

        String q4String = "Sleep is awesome";
        TrueFalse q4 = new TrueFalse(q4String, true);

        // Add question to the quiz
        quiz.addQuestions(new Question[]{q1, q2, q3, q4});

        // Display quiz to the user
        quiz.run();
        System.out.println(newline + "QUIZ COMPLETED" + newline +
                "You answered " + quiz.getNumCorrect() + " of " + quiz.getQuestions().size() + " questions correctly" + newline);
    }
}