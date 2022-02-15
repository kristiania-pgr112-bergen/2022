package LargerTasks.bankLoan;

public class HouseLoan extends Loan{
    private String houseAddress;
    private CustomerInfo coLoanTaker;

    /**
     * Constructor
     * Note that we should implement two constructors
     * Because a houseLoan might only have one Loan Taker,
     * or have both mainLoanTaker and coLoanTaker.
     */


    /**
     * Task 7
     * We want to pass CustomerProxy as an argument to Loan class constructor
     * so that we can use CustomerProxy methods.
     * For example, when we create a loan, the Loan constructor will check if the customer
     * is already registered in CustomerProxy, if not, register the new customer.
     *
     * For HouseLoan, we need to register customer information for both main LoanTaker and co LoanTaker.
     */

    /**
     * Getters/Setters
     */
    /**
     * Implement getAnnualInterestRate()
     * Don't forget @override annotation!
     */
    /**
     * Implement printLoanInformation()
     * It will call calculateLoanPayment() defined in Loan class
     * It will print extra information related to HouseLoan.
     * And when printing out customer info, you need to check if it is one Loan Taker, or two Loan Takers
     * Don't forget @override annotation!
     */
}
