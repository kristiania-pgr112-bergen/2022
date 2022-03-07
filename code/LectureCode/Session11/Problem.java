package LectureCode.Session11;

public class Problem {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);

        String problem = "";
        problem = problem + "Rhonda has 12 marbles more than Douglas.";
        problem = problem + "Douglas has 6 marbles more than Bertha.";
        problem = problem + "Rhonda has twice as many marbles as Bertha has.";
        problem = problem + "How many marbles does Douglas have?";

        int Douglas = 1;

        // bruteforce
        for (int x = -100; x < 100; x ++) {
            int Rhonda = x + 12;
            int Bertha = x - 6;

            terminal.ifEqual(Rhonda,Bertha * 2);
        }

        // Observation: Bertha < Douglas < Rhonda

        // Checking our terminal output, we can look for green text
        // to find where our bruteforce method found a solution to the problem

    }
}
