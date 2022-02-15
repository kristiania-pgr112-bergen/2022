package LargerTasks.bankLoan;

public interface ILoanProxy {
    /**
     * Task 5
     */

    Loan getLoan(Integer loanId);
    void registerLoan(Loan loan) throws Exception;
    void printAllLoans() throws Exception;
    void printLoanbySsn(String ssn) throws Exception;
}
