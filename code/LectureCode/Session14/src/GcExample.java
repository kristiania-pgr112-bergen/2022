package LectureCode.Session14.src;

import java.lang.ref.Cleaner;

class Student {
    private String name;
    private String major;
}
public class GcExample {
    String name;

    public GcExample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    static void method() {
        Student student = new Student();
        /**
         * by making a reference null
         */
        student = null;
        Student studentOne = new Student();
        Student studentTwo = new Student();
        /**
         * now the first object referred by studentOne is available for garbage collection
         */
        studentOne = studentTwo;

    }

    public static void main(String args[])
    {
        System.out.println("Start MyCleanerTest...");
        Cleaner cleaner = Cleaner.create();
         /**
         * we force JVM to garbage collect myObject initialization.
         **/
        for (int i = 0; i < 10; i++) {
            String id = Integer.toString(i);
            GcExample myObject = new GcExample(id);
            Cleaner.Cleanable c= cleaner.register(myObject, new MyCleanerRunnable(myObject.getName()));
            //c.clean();
        }
        //do some other memory intensive work
        for (int i = 1; i <= 100000; i++) {
            int[] a = new int[10000];
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
    private static class MyCleanerRunnable implements Runnable {
        String name;
        public MyCleanerRunnable(String name) {
            this.name = name;
        }
        public void run() {
            System.out.println("MyCleanerTest cleaning action executed for "+name);
        }
    }

}



