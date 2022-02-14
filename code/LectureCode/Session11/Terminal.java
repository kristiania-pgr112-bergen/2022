package LectureCode.Session11;

// Read more about ANSI here, with examples
// https://stackoverflow.com/questions/4842424/list-of-ansi-color-escape-sequences

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Terminal {
    private Scanner scanner;
    private InputStream input;
    private PrintStream output;

    Terminal(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
        this.scanner = new Scanner(input);
    }

    public int getInteger() {
        return Integer.parseInt(this.getLine());
    }

    public double getDouble() {
        return Double.parseDouble(this.getLine());
    }

    public String getLine() {
        return this.scanner.nextLine();
    }

    void printLine(String message) {
        this.output.println(message);
    }

    void printLine(String color, String message) {
        switch(color) {
            case "white" -> this.output.println(message);
            case "red" -> this.output.println("\033[31m" + message + "\033[0m");
            case "green" -> this.output.println("\033[32m" + message + "\033[0m");
            case "blue" -> this.output.println("\033[34m" + message + "\033[0m");
            case "yellow" -> this.output.println("\033[33m" + message + "\033[0m");
        }
    }

    public String askQuestion(String question) {
        this.output.println(question);

        return this.getLine();
    }

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        terminal.printLine("red", "Rød tekst!");
        terminal.printLine("green", "Rød tekst!");
        terminal.printLine("blue", "Rød tekst!");
        terminal.printLine("yellow", "Rød tekst!");
    }

}
