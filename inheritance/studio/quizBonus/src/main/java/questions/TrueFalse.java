package questions;

public class TrueFalse extends Question {

    public TrueFalse(String question, boolean answer) {
        super(question, answer);
    }


    @Override
    public String toString() {
        String newline = System.lineSeparator();
        String question = newline + newline + "TRUE/FALSE" + newline + "__________________"
                + newline + getQuestion() + newline + getFormattedChoices()
                + "__________________";;
        return question;
    }
}
