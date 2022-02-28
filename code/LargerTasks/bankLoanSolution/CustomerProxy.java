package LargerTasks.bankLoanSolution;

import java.util.HashMap;

public class CustomerProxy implements ICustomerProxy{
    HashMap<String, CustomerInfo> customerInfoHashMap;
    public CustomerProxy(HashMap<String, CustomerInfo> customerInfoHashMap) {
        this.customerInfoHashMap = customerInfoHashMap;
    }
    @Override
    public CustomerInfo getCustomer(String ssn) {
        return customerInfoHashMap.get(ssn);
    }

    @Override
    public boolean isValidSsn(String ssn) throws Exception {
        if(ssn.length()!=11) throw new Exception();
        else return true;
    }

    @Override
    public void registerCustomer(CustomerInfo customerInfo) throws Exception {
        if(isValidSsn(customerInfo.getSsn())) {
            customerInfoHashMap.put(customerInfo.getSsn(), customerInfo);
        } else
            throw new Exception();
    }
}
