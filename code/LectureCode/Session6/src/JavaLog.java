package LectureCode.Session6.src;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaLog {
    private void helperMethod2() {
        System.out.println("In helperMethod2");
        int i = 10/0;
        System.out.println("i:"+i);
        System.out.println("helperMethod2 done");
    }

    private void helperMethod1() {
        System.out.println("In helperMethod1");
        helperMethod2();
        System.out.println("helperMethod1 done");
    }
    public void runExample() throws IOException {
        Path currentRelativePath = Paths.get("");
        String dir= currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current absolute path is: " + dir);
        Logger logger = Logger.getLogger(JavaLog.class.getName());
        logger.addHandler(new FileHandler(new File(dir, "logs.txt").toString()));

        try{
            helperMethod1();
        }
        catch (NullPointerException e){
            logger.log(Level.SEVERE, "It is NullPointerException", e.getMessage());
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "It is ArithmeticException", e.getMessage());
        }
    }
}
