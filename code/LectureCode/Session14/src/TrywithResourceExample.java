package LectureCode.Session14.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrywithResourceExample {
    public void runExample1() {
        Scanner scanner=null;
        try {
            scanner = new Scanner(new File(
                    "C:\\Users\\abc.txt"));
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }}
        catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(scanner!=null) {
                scanner.close();
            }
        }
    }

    public void runExample2() {
        try(Scanner scanner = new Scanner(new File(
                "C:\\Users\\abc.txt"))) {
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }}
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
