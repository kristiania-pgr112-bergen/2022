package Tasks.step3wallet.src;

/**
 *  Wallet-class
 *
 *  Fields:
 *  - int coins
 *      - Amount of coins within the wallet
 *
 *  Methods:
 *  - public void printCoins()
 *      - Prints the amount of counts within the wallet to standard output
 */
public class Wallet {
    int coins = 0;

    public void printCoins() {
        System.out.println("You have " + this.coins + " coins.");
    }
}
