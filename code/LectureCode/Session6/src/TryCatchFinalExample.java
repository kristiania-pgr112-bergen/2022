package LectureCode.Session6.src;

public class TryCatchFinalExample {

    /**
     * NumberFormatException is caught
     */
    public void runExample1() {
        try {
            String s="OOP course";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } finally {
            System.out.println("final block is " +
                    "executed anyhow...");
        }
        System.out.println("rest of the code...");
    }

    /**
     * When there is no exception thrown
     */
    public void runExample2() {
        try {
            String s="123";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } finally {
            System.out.println("final block is " +
                    "executed anyhow...");
        }
        System.out.println("rest of the code...");
    }

    /**
     * The thrown NumberFormatException is not caught
     * by the catch block
     */

    public void runExample3() {
        try {
            String s="OOP course";
            int i = Integer.parseInt(s);
            System.out.println(i);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("final block is " +
                    "executed anyhow...");
        }
        System.out.println("rest of the code...");
    }
}
