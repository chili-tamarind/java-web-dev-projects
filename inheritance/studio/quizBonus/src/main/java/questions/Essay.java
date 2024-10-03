package questions;

public class Essay extends Question{

    public Essay(String question, int wordCount) {
        super(question);
    }

    @Override
    public String toString() {
        String newline = System.lineSeparator();
        String question = newline + newline + "SHORT ANSWER (" + getWordCount() + " characters max)" + newline + "__________________"
                + newline + getQuestion()
                + "__________________";
        return question;
    }

    @Override
    public boolean isInvalid(String response){
        return response.length() >= getWordCount();
    }

}
