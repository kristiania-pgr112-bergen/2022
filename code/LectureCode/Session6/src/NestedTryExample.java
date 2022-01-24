package LectureCode.Session6.src;

public class NestedTryExample {
    public void runExample1(){
        try {
            try {
                int a[] = new int[5];
                a[5] = 10/0;
            }catch (IndexOutOfBoundsException e) {
                System.out.println(e);
            }
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }

        System.out.println("rest of the code...");
    }
}
