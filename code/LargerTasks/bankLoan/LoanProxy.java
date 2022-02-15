package LargerTasks.bankLoan;

public class LoanProxy implements ILoanProxy{

    /**
     * Task 5
     */
    /**
     * Create a loan HashMap. think about if we can use ssn as key
     * if not, we use loanId as key.
     * How shall we get loanId?
     */

    /**
     * Create a static field called loanId, which is shared among Loan instances
     * since each time we create a new Loan, loanId will be incremented by 1.
     * In such way we get auto-incremented unique index for each Loan
     */
    /**
     * Implement below methods
     */
    @Override
    public Loan getLoan(Integer loanId) {
        return null;
    }

    @Override
    public void registerLoan(Loan loan) throws Exception {
    /**
     * When you register a loan, remember to update the loan with created loanId
     */
    }


    /**
     * Task 8
     * recall how we iterate HashMap?
     */
    @Override
    public void printAllLoans() throws Exception {

    }

    /**
     * Task 8
     * For CarLoan and ConsumerLoan, you need to check if loan customer ssn equals to the input argument ssn.
     * For HouseLoan, you will need to check both main LoanTaker and co LoanTaker
     * hint: hashmap,entrySet().stream().map().filter().collect(Collectors.toList()). and this is lambda...
     * YFor HouseLoan you will also use instanceOf and downcasting...
     */
    @Override
    public void printLoanbySsn(String ssn) throws Exception {

    }
}
