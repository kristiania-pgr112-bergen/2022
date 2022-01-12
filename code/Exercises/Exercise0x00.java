package Exercises;

/**
 * Exercise 0x00
 *
 *  An exercise which introduces how code and programs run
 *  within a Java context. There will be more concepts later
 *  on in the course, so for now, let us start simple:
 *
 *      - How to compile Java source code?
 *      - How to execute compiled Java classes?
 *
 *  Take a look at the code below.
 *
 *  It is a simple Java application which does one thing:
 *      Prints out "Hello, world!" in the terminal as a standard output
 *
 */

public class Exercise0x00 {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}

/**
 * Read this when finished above.
 *
 *  Before explaining the different lines, let us begin with
 *  the following:
 *      - Java source code needs to be compiled
 *      - How to run compiled Java code
 *
 *  Firstly, you can compile and run Java source code using
 *  a terminal, with the following commands available:
 *      - `javac`
 *          - Example:
 *              `javac Exercises.Exercise0x00.java`
 *            You should now have a compiled .class file,
 *            let us run it:
 *      - `java`
 *          - Example:
 *              `java Exercises.Exercise0x00`
 *            You should now see some output, "Hello, world!",
 *            as expected from the code in this Java code file.
 *
 *  IntelliJ also provides functionality to do this for you,
 *  with a configuration you can edit from inside IntelliJ.
 *
 *      "Add Configuration..."-button on the toolbar above.
 *
 *      Add a new configuration, to the left in the new window,
 *      select Java application.
 *
 *      Keep it simple for now.
 *
 *      You can also use the green arrows in the gutter
 *      on your left side, right next to each line number.
 *
 *      The arrows will display on classes and static main
 *      methods defined within classes. It will show up in other
 *      contexts as well, but that is for later.
 *
 *      For now, use this green arrow to run your code while using
 *      IntelliJ.
 *
 *      What are classes you might ask?
 *
 *      Move on to the next exercise, 0x01.
 */