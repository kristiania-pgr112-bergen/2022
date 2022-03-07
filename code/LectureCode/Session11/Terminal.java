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

    void ifEqual(int A, int B) {
        if (A == B) {
            this.printLine("green", A + " == " + B);
        }
        else {
            this.printLine("red", A + " == " + B);
        }
    }

    /**
     * Prints out a normal line
     * @param message A string line.
     */
    public void printLine(String message) {
        this.output.println(message);
    }

    /**
     * Print out a line with a color specified
     * @param color Which color to use, red, green, etc
     * @param message The line to be printed
     */
    public void printLine(String color, String message) {
        this.output.println(this.startColor(color) + message + this.endColor());
    }

    public String startColor(String color) {
        switch(color) {
            case "red" -> { return "\033[31m"; }
            case "green" -> { return "\033[32m"; }
            case "blue" -> { return "\033[34m"; }
            case "yellow" -> { return "\033[33m"; }
            default -> { return ""; }
        }
    }

    public String endColor() {
        return "\033[0m";
    }

    public String askQuestion(String question) {
        this.output.println(question);

        return this.getLine();
    }

    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        terminal.printLine("red", "Rød tekst!");
        terminal.printLine("white", "Rød tekst!");
        terminal.printLine("white", "Rød tekst!");
        terminal.printLine("yellow", "Rød tekst!");
    }

}
