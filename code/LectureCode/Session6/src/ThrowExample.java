package LectureCode.Session6.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowExample {
    /**
     * we explicitly throw an exception
     */
    public void runExample1() {
        try {
            /**
             * remember when we throw an exception we need new keyword to instantiate an instance
             */
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");

    }

    /**
     * we explicitly throw an exception inside try block
     * and re-throw it in catch block
     */
    public void runExample2() {
        try {
            throw new NullPointerException();
        }catch (NullPointerException e) {
            System.out.println(e);
            throw e;
        }
    }

    /**
     * validate() throw ArithmeticException
     * runExample3() does not handle it
     */
    public void validate(String ssn) {
        if(ssn.length()!=11) {
            throw new ArithmeticException();
        }
    }
    public void runExample3() {
        validate("123");
        System.out.println("rest of the code...");
    }

    public void runExample4() throws IOException {
        /**
         * You either add exception into method
         * signature or use try-catch clause
         */
        FileReader file = new FileReader("C:\\Users\\abc.txt");
        BufferedReader fileInput = new BufferedReader(file);
        String line;
        while((line = fileInput.readLine())!=null){
            System.out.println(line);
        }
        fileInput.close();
    }
    /**
     * runExample4() might throw java.io.IOException
     * runExample5() use try-catch clause
     * It can also further throw IOException
     */
    public void runExample5() {
        try {
            runExample4();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("rest of the code...");
    }
    /**
     * runExample4() might throw java.io.IOException
     * Is it valid if runExample5() does not handle it?
     * here we add exception into method signature
     */
    public void runExample6() throws IOException {
        runExample4();
        System.out.println("rest of the code...");
    }

}
