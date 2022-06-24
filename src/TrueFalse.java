public class TrueFalse extends Question {
    private boolean correctAnswer;
    private Boolean[] answerOptions;

    public TrueFalse(int id, String text) {
        super(id, text);
        answerOptions = new Boolean[2];
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return String.valueOf(correctAnswer);
    }
}