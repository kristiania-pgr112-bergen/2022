package Examples;

/**
 *  Arrays are
 */
public class OneDimensionalArray {
    public static void main(String[] args) {
        // No size is given here, but will be set
        // based on the elements given during array creation

        // implicitly size 10
        int[] integers = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };

        if (integers[1] + integers[9] == 10) {
            System.out.println("The length was correctly set to 10");
        }

        // implicitly size 2
        String[] strings = {
                "Alice",
                "Bob"
        };

        System.out.println(integers.length);
        System.out.println(strings.length);

        try {
            strings[2] = "Funker dette?";
        } catch (Exception e) {
            System.out.println("Om du ser dette, så nei :)");

            // The length is fixed, as in, not changed
        }
    }
}
