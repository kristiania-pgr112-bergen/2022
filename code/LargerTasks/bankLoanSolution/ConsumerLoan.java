package LargerTasks.bankLoanSolution;


public class ConsumerLoan extends Loan {

    public ConsumerLoan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo customer,
                        CustomerProxy customerProxy) {
        super(numberOfYears, loanAmount, loanType, customer, customerProxy);
        getAnnualInterestRate();
        if(customerProxy.getCustomer(customer.getSsn())==null) {
            try {
                customerProxy.registerCustomer(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    void getAnnualInterestRate() {
        annualInterestRate = 0.5;
    }

    @Override
    void printLoanInformation() throws Exception {
        System.out.println(customer);
        calculateLoanPayment();
    }
}
