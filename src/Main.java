import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static int counter = 1;
    public static ArrayList<Test> tests = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("WELCOME TO TEST PROGRAM");
        int userAction;
        Scanner keyboard = new Scanner(System.in);

        do {

            userAction = DisplayMainMenu();
            if (userAction == 1) {
                Test t = CreateTest();
                String yesOrNo = "no";
                do {
                    Question question = CreateQuestion();
                    t.addQuestion(question);
                    System.out.println("add more (yes or no ?)");
                    yesOrNo = keyboard.next();
                } while (yesOrNo.equals("yes"));


                tests.add(t);
            } else if (userAction == 2) {
                for (int i = 0; i < tests.size(); i++) {
                    System.out.println(tests.get(i).toString());
                }
            }
            counter++;

        } while (userAction == 1 || userAction == 2);


    }

    public static int DisplayMainMenu() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\t 1. Create a Test");
        System.out.println("\n\t 2. List Existing Test");
        System.out.print("Make a Selection (1 or 2): ");

        return keyboard.nextInt();
    }

    public static Test CreateTest() {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("\n \t Enter a name for the test: ");
        String name = keyboard.next();
        System.out.println("\n \t Test is created.");

        return new Test(name);

    }

    public static Question CreateQuestion() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\tAdd MC or TF? (1 or 2):");
        int answer = keyboard.nextInt();
        if (answer == 1) {
            return CreateMC();
        } else if (answer == 2) {
            return CreateTF();
        }
        return null;
    }

    public static MultipleChoice CreateMC() {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("\n\n Adding MC questions # %d", counter);
        System.out.println("\tQuestion text:");
        String question = keyboard.next();
        System.out.println("\n \t Enter the answer options. \nAfter entering an option press Enter key.\nAdd * to indicate the correct answer.");

        System.out.println("\tOption #1:");
        String answer = keyboard.next();
        System.out.println("\tOption #2:");
        String answer1 = keyboard.next();
        System.out.println("\tOption #3:");
        String answer2 = keyboard.next();
        System.out.println("\tOption #4:");
        String answer3 = keyboard.next();
        MultipleChoice m = new MultipleChoice(counter, question);
        m.addAnswerOption(answer);
        m.addAnswerOption(answer1);
        m.addAnswerOption(answer2);
        m.addAnswerOption(answer3);
        return m;
    }

    public static TrueFalse CreateTF() {
        Scanner keyboard = new Scanner(System.in);
        System.out.printf("\n\n Adding TF questions # %d", counter);
        System.out.println("\tQuestion text:");
        String question = keyboard.next();
        System.out.println("\tEnter the correct answer (True or False):");
        String answer = keyboard.next();
        TrueFalse tf = new TrueFalse(counter, question);
        tf.setCorrectAnswer(Boolean.parseBoolean(answer));

        return tf;
    }


}