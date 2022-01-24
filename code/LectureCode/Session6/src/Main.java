package LectureCode.Session6.src;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TryCatchExample example = new TryCatchExample();
//        example.runExample6();
        MultipleCatchExample multipleCatchExample = new MultipleCatchExample();
//        multipleCatchExample.runExample4();
        NestedTryExample nestedTryExample = new NestedTryExample();
//        nestedTryExample.runExample1();
        TryCatchFinalExample tryCatchFinalExample = new TryCatchFinalExample();
//        tryCatchFinalExample.runExample3();
        ThrowExample throwExample = new ThrowExample();
        /**
         * java: unreported exception java.io.IOException; must be caught or declared to be thrown
         */
        //throwExample.runExample6();
        CustomExample customExample = new CustomExample();
//        customExample.runExample1("123");

        TrywithResourceExample trywithResourceExample = new TrywithResourceExample();
//        trywithResourceExample.runExample2();

        CallStackExample callStackExample = new CallStackExample();
//        callStackExample.runExample();

/*        FileReadExample fileReadExample = new FileReadExample();
        try {
            fileReadExample.readFromFileBufferThrows();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriteExample fileWriteExample = new FileWriteExample();
        try {
            fileWriteExample.WriteToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*        JavaLog javaLog = new JavaLog();
        try {
            javaLog.runExample();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        LocalDateExample localDateExample = new LocalDateExample();
        localDateExample.runExample();
    }
}
