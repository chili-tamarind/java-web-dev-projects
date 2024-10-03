package questions;

public class Choice {

    private final String content;
    private final boolean correct;

    // Constructor
    public Choice(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }

    // Other constructor option - defaults to false
    public Choice(String content) {
        this(content, false);
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }
}
