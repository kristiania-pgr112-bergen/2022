package LectureCode.Session5;

import java.util.ArrayList;
import java.util.Scanner;


public class TerminalMenu {
    ArrayList<String> options = new ArrayList<>();

    public static void main(String[] args) {
        TerminalMenu menu = new TerminalMenu();

        menu.options.add("Vis saldo");
        menu.options.add("Sett inn penger");
        menu.options.add("Ta ut penger");

        for (int i = 0; i < menu.options.size(); i ++) {
            // System.out.println(i + ". " + menu.options.get(i));
            System.out.printf("%d. %s\n", i + 1, menu.options.get(i));
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Ditt valg: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> menu.showBalance();
            case 2 -> menu.depositMoney();
            case 3 -> menu.withdrawMoney();
        }
    }

    void showBalance() {
        System.out.println("Du har sikkert mye på konto kan en håpe!");
    }

    void depositMoney() {
        System.out.println("Sett inn penger");
    }

    void withdrawMoney() {
        System.out.println("Ta ut penger!");
    }
}
