package LectureCode.Session11;

public class ClearTerminal {
    public static void main(String[] args) {
        System.out.println("Om du ser denne linjen så fungerer ikke ANSI koden nedenfor!");

        System.out.println("\033[2J\033[1;1H");

        System.out.println("Det funker om du kun ser denne linjen!");
    }
}
