package LectureCode.Session6.src;

public class MultipleCatchExample {
    /**
     * At a time only one exception occurs and only one catch block is executed
     * The first exception that occurs gets handled
     */
    public void runExample1(){
        try {
            int a[] = new int[5];
            a[5] = 10;
            a[0] = 10/0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * compilation error
     * All catch blocks must be ordered from most specific to most general
     * i.e., catch for ArithmeticException must come before Exception
     */
/*    public void runExample2(){
        try {
            int a[] = new int[5];
            a[5] = 10;
            a[0] = 10/0;
        }  catch (Exception e) {
            System.out.println(e);
        }catch (ArithmeticException e) {
            System.out.println(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }*/

    /**
     * The first occured ArithmeticException is not caught by provided catch block - program terminated
      */
    public void runExample3(){
        try {
            int a[] = new int[5];
            a[5] = 10/0;
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }

    /**
     * The first occured ArithmeticException is not caught by provided IndexOutOfBoundsException catch block
     * but caught by general Exception
     *
     * hint: always provide Exception catch block in the end
     */
    public void runExample4(){
        try {
            int a[] = new int[5];
            a[5] = 10/0;
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }
}
