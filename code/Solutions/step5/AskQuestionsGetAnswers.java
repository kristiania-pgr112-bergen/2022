package Solutions.step5;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *  Task 5
 *          Ask N questions and get N answers
 *
 *  - [x] Ask how many questions to gather as an int
 *  - [ ] Use a loop to ask for that many questions
 *  - [ ] Store each question received in the questions ArrayList
 *  - [ ] Ask each question and collect answers into the answers ArrayList
 *  - [ ] Loop through each question and output the answer given to that question
 *
 *
 *  In other words:
 *
 *      Ask how many questions the user should give you.
 *      Collect that many questions.
 *      Ask each question and collect the answer.
 *      Display a list of each question and answer given.
 *
 */

public class AskQuestionsGetAnswers {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();

    int questionCount = 0;

    void getQuestionCount() {
        System.out.println("How many questions do you want to add?");

        this.questionCount = this.scanner.nextInt();
    }

    void start() {
        this.getQuestionCount();
    }

    public static void main(String[] args) {
        AskQuestionsGetAnswers FAQ = new AskQuestionsGetAnswers();

        FAQ.start();
    }
}
