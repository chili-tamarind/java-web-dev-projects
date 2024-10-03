import questions.*;

public class SurveyRunner {

    // Create quiz
    private static final SurveyGenerator survey = new SurveyGenerator();
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

        // Create questions - essay
        String q4String = "How are you doing?";
        Essay q4 = new Essay(q4String, 55);

        // Create questions - linearscale
        String q5String = "How many caramel frappuccinos can you drink?";
        LinearScale q5 = new LinearScale(q5String, 1000);

        // Add question to the quiz
        survey.addQuestions(new Question[]{q1,q2,q3,q4,q5});

        // Display quiz to the user
        survey.run();

        System.out.println(newline + "SURVEY COMPLETED" + newline +
                "You answered " + survey.getNumCorrect() + " of " + survey.getQuestions().size() + " questions correctly" + newline);

        System.out.println(String.join(newline + "\t", survey.getAllResponses()));
    }
}