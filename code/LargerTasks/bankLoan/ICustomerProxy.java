package LargerTasks.bankLoan;

public interface ICustomerProxy {
    /**
     * Task 4
     */
    /**
     * why throws exception here? in case ssn is not valid
     */

    CustomerInfo getCustomer(String ssn) throws LoanException;
    boolean isValidSsn(String personalIdentifyNumber) throws LoanException;
    void registerCustomer(CustomerInfo customerInfo) throws LoanException;
}
