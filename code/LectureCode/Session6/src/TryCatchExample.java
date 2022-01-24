package LectureCode.Session6.src;

/**
 * below code show different types of unchecked exceptions
 */
public class TryCatchExample {
    /**
     * ArithmeticException example
     */
    public void runExample1() {
        try {
            int data = 100/0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * NullPointerException example
     */
    public void runExample2() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * ArrayIndexOutOfBoundsException example
     */
    public void runExample3() {
        try {
            int a[] = new int[5];
            System.out.println(a[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * NumberFormatException example
     */
    public void runExample4() {
        try {
            String s="OOP course";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * NumberFormatException is not caught since we only catch NullPointerException
     */
    public void runExample5() {
        try {
            String s="OOP course";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * No exception is thrown
     */
    public void runExample6() {
        try {
            String s="123";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }



}
