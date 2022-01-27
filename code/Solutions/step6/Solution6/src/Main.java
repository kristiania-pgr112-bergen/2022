package Solutions.step6.Solution6.src;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        /*
        try {
            program.oppgave4();
        } catch (FileNotFoundException e) {
            System.out.println("Klarte ikke kjøre oppgave 4. FileNotFoundException");
            e.printStackTrace();
        }



        try {
            program.oppgave5();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            program.oppgave7();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */

        try {
            program.oppgave8();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
