package LargerTasks.bankLoan;

public class LoanFactory {
    /**
     * Task 6
     */

    /**
     * Task 9: Design a user interface using Scanner!
     * The new user interface shall be able to handle:
     * 1. create a new customer
     * 2. register a customer after created
     * 3. create a new loan
     * 4. you will be able to choose  the type: CarLoan, ConsumerLoan, HouseLoan
     * 5. register the loan after created
     * 6. print all loans
     * 7. print loan based on SSN
     */
    public static void main(String[] args) {
        LoanFactory loanFactory = new LoanFactory();

        /**
         * Create customers
         * Register customers
         */

        /**
         * call createLoan(), create whatever loan you would like to.
         * Remember upcasting, example is as below.
         * Also register the loans
         */
        try {
            /**
             * here comes the question, what if we want to call houseLoan.houseAddress()?
             * use downcasting
             */
            Loan houseLoan = loanFactory.createLoan(LoanType.HouseLoan);
        } catch (LoanException e) {
            e.printStackTrace();
        }
        /**
         * try printAllLoans() and printLoanbySsn()
         */

    }

    /**
     * create a method called createLoan()
     * The function is used to create different loan based on the loanType
     * You will need to accomplish this function.
     *
     */
    public Loan createLoan(LoanType loanType) throws LoanException {
        /**
         *
         */
        switch (loanType) {
            case CarLoan:
                return new CarLoan();
            /**
             * more here
             */
            default:
                throw new LoanException();
        }
    }
}
