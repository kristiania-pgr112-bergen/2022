package LectureCode.Session2;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // variables
        System.out.print("Hva er navnet ditt?");
        String name = input.nextLine();

        System.out.print("Hva er din alder? ");
        int age = input.nextInt();

        System.out.print("Hva er din høyde? ");
        float height = input.nextFloat();


        // System.out.println("Ditt navn er " + name);
        System.out.printf("Ditt navn er %s\n", name);

        //System.out.println("Din alder er " + age);
        System.out.printf("Din høyde er %d\n", age);

        // System.out.println("Din høyde er " + height + "m");
        System.out.printf("Din høyde er %.2fm\n", height);

        /*
            Rule of thumb: When doing an arithmetic calculation between two different built-in types, the "smaller"
            type will be converted into the "larger" type.

            double > float > long long(C99) > long > short > char
            - Yuan
        */
    }
}

