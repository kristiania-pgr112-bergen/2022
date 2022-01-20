package Solutions.step4.Step4extra2.src;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RevArrayList program = new RevArrayList();

        // Declaring arraylist without any initial size
        ArrayList<String> namelist = new ArrayList<>();

        // Appending elements at the end of the list
        namelist.add("Kari");
        namelist.add("Lars");
        namelist.add("Markus");
        namelist.add("Tobias");
        System.out.print("Elements before reversing:\n");
        program.printElements(namelist);
        namelist = program.reverseArrayList3(namelist);
        System.out.print("\nElements after reversing:\n");
        program.printElements(namelist);
    }
}
