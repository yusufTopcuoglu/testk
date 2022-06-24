import java.util.ArrayList;

public class Test {
    private ArrayList<Question> questions;
    private String testName;

    public Test(String testName) {
        this.testName = testName;
        questions = new ArrayList<Question>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addQuestion(int order, Question question) {
        questions.add(order, question);
    }

    public boolean deleteQuestion(int id) {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).GetId() == id)
                questions.remove(i);
            return true;
        }
        return false;
    }

    public int countTFQuestions() {
        int count = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i) instanceof TrueFalse) {
                count++;
            }
        }
        return count;
    }

    public int countMCQuestions() {
        int count = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i) instanceof MultipleChoice) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public String toString() {
        String str = testName + "\n \t Number of Questions: " + getNumberOfQuestions() + "\n \t \t True/false: " + countTFQuestions() + "\n \t \t Multiple Choice: " + countMCQuestions();

        return str;

    }
}