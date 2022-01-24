package LectureCode.Session6.src;

import java.io.*;
import java.util.Scanner;

public class FileReadExample {
    public void readFromFileScanner() {
        Scanner scanner=null;
        try {
            scanner = new Scanner(new File("C:\\Users\\abc.txt"));
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }}
        catch (FileNotFoundException e){
            e.printStackTrace();
        } finally {
            if(scanner!=null) {
                scanner.close();
            }
            System.out.println("finally...");
        }
    }

    public void readFromFileScannerThrows() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\abc.txt"));
        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

    }


    public void readFromFileBufferThrows() throws IOException {
        FileReader file = new FileReader("C:\\Users\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);
        String line;
        while((line = fileInput.readLine())!=null){
            System.out.println(line);
        }
        fileInput.close();


        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
    }
}
