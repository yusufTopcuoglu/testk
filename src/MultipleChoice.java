import java.util.ArrayList;

public class MultipleChoice extends Question {
    private String correctAnswer;
    private ArrayList<String> answerOptions;

    public MultipleChoice(int id, String text) {
        super(id, text);
        answerOptions = new ArrayList<String>();

    }

    public boolean addAnswerOption(String option) {
        if (answerOptions.size() == 4) {
            return false;
        }
        for (int i = 0; i < answerOptions.size(); i++) {
            if (answerOptions.get(i).equals(option)) {
                return false;
            }
        }
        answerOptions.add(option);
        return true;
    }

    public boolean addAnswerOption(String option, boolean isCorrect) {
        if (answerOptions.size() == 4) {
            return false;
        }
        for (int i = 0; i < answerOptions.size(); i++) {
            if (answerOptions.get(i).equals(option)) {
                return false;
            }
        }
        answerOptions.add(option);
        if (isCorrect) {
            this.correctAnswer = option;
        }
        return true;
    }


    public ArrayList<String> getAnswerOptions() {
        return answerOptions;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}