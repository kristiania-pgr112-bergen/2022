package Tasks.step5.src;

import java.util.ArrayList;

public class TerminalMenu {
    ArrayList<String> options = new ArrayList<>();

    public static void main(String[] args) {
        TerminalMenu menu = new TerminalMenu();

        // Create 3 different options ( + 1 extra to exit the menu)

        // Print the different options together with a number (for selection an option)

        // Let the user select one of the options

        // Create three different methods which should be called upon when each respective option is selected
        /*
            example:
                switch(option) {
                    case 1 -> showBalance();
                    case 2 -> depositMoney();
                    case 3 -> withdrawMoney();
                }
         */

        // Bonus: Displaying the options could work nicely as a method!
        // Remember: Don't Repeat Yourself
        // Remember: Make sure you use the correct data types and validate user input!

        /*
        Example involving a simple bank:

            Options:
            1. Show balance
            2. Deposit
            3. Withdraw
            4. Exit

            Select your option:
            1

            You have 0 money.

            Select your option:
            2

            How much would you like to deposit?
            100

            Select your option:
            1

            You have 100 money.

            Select your option:
            3

            How much would you like to withdraw?
            42

            Select your option:
            1

            You have 58 money.

            Select your option:
            4

            Have a nice day!
         */
    }
}
