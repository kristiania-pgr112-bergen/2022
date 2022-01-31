package Tasks.step3.Wallet.src;

/**
 *  This is a very simple wallet, available as a Java-class named Wallet.
 *      - It only keeps track of how many coins are within the wallet
 *      - At first, it has one method which prints the amount of coins
 *        within the wallet, into the terminal (standard output).
 *
 *  It has one field and one method to start with.
 *
 *  It does not distinguish between types of coins, as in, it has no
 *  data available to answer the question,
 *      "Are there different types of coins within the wallet?"
 *
 *  Some tasks available as a challenge:
 *  - [ ]:  Make the `coins` field private, and provide getters/setters
 *  - [ ]:  Add a zipper (boolean state), that is either open or closed
 *  - [ ]:  Add methods to close and open the wallet containing coins
 *              (as in, opening or closing the zipper)
 *  - [ ]:  Edit your setter and other methods, those which change (mutate)
 *          the value of coins within the value, to only do so when the
 *          zipper is open.
 *  - [ ]:  Create an array which holds a (one) type of coin, where the
 *          `coins` field refers to the length of that array.
 */
public class WalletExample {
    int coins = 0;

    void printCoins() {
        System.out.println("You have " + this.coins + " coins.");
    }
}