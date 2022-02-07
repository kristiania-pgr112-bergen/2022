package Solutions.step5;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *  Task 5
 *          Ask N questions and get N answers
 *
 *  - [X] Ask how many questions to gather as an int
 *  - [X] Use a loop to ask for that many questions
 *  - [X] Store each question received in the questions ArrayList
 *  - [X] Ask each question and collect answers into the answers ArrayList
 *  - [X] Loop through each question and output the answer given to that question
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

    public void start() {
        System.out.println("Hvor mange spørsmål ønsker du å ha?");

        questionCount = Integer.parseInt(this.scanner.nextLine());

        this.getQuestions();
        this.askQuestions();

        this.printQuestionsAndAnswers();
    }

    private void getQuestions() {
        for (int i = 0; i < this.questionCount; i ++) {
            System.out.println("Skriv inn spørsmålet ditt:");

            questions.add(this.scanner.nextLine());
        }
    }

    private void askQuestions() {
        for (String question : this.questions) {
            System.out.printf("%s%n", question);

            this.answers.add(this.scanner.nextLine());
        }
    }

    private void printQuestionsAndAnswers() {
        System.out.println("# Friendly Questions and Answers");

        if (this.questions.size() == this.answers.size()) {
            for (int i = 0; i < this.questions.size(); i ++) {
                System.out.printf("Q: %s%n", this.questions.get(i));
                System.out.printf("A: %s%n", this.answers.get(i));

                System.out.println("---");
            }
        }
    }

    public static void main(String[] args) {
        AskQuestionsGetAnswers FAQ = new AskQuestionsGetAnswers();

        FAQ.start();
    }
}
