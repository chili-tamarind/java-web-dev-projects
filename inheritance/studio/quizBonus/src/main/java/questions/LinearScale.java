package questions;

public class LinearScale extends Question{
    private final int highestNumber;
    
    public LinearScale(String question, int highestNumber) {
        super(question);
        this.highestNumber = highestNumber;
    }

   @Override
    public String toString() {
        String newline = System.lineSeparator();
        String question = newline + newline + "LINEAR SCALE" + newline + "__________________"
                + newline + getQuestion()
                + newline + "Enter a number from 1 to " + getWordCount()
                + "__________________";
        return question;
    }

    @Override
    public boolean isInvalid(String userAnswer) {
        try {
            int userAnswerInt = Integer.parseInt(userAnswer);
            return userAnswerInt <= 0 || userAnswerInt > highestNumber;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
