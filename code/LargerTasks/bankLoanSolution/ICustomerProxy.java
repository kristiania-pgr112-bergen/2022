package LargerTasks.bankLoanSolution;

public interface ICustomerProxy {
    CustomerInfo getCustomer(String ssn);
    boolean isValidSsn(String personalIdentifyNumber) throws Exception;
    void registerCustomer(CustomerInfo customerInfo) throws Exception;
}
