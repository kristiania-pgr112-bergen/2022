package Examples;

public class NumberClasses {
    public static void main(String[] args) {
        Number[] numberArray = new Number[] {
                1,      // int
                2.0f,   // float
                3.0d,   // double
        };

        /*
            Number-class here is a generalization of numbers, as in, it
            can represent any number, be it an integer, float, double, long etc.
         */

        //---

        // The following two arrays are identical due to
        // Integer being a wrapper class around the primitive data type int

        Integer[] integers1 = new Integer[] {
                1, 2, 3
        };

        int[] integers2 = new int[] {
                1, 2, 3
        };

        // Other wrapper classes are: Float, Double, Long, etc.
        // these can be found in the java.lang package
    }
}
