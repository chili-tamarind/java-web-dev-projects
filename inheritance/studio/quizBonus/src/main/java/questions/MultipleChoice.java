package questions;

public class MultipleChoice extends Question{

    public MultipleChoice(String question, Choice[] choiceArray) {
        super(question, choiceArray);
    }

    @Override
    public String toString() {
        String newline = System.lineSeparator();
        String question = newline + newline + "SELECT THE CORRECT ANSWER" + newline + "__________________"
                + newline + getQuestion() + newline + getFormattedChoices()
                + "__________________";;
        return question;
    }
}
