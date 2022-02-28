package LargerTasks.bankLoanSolution;

public class HouseLoan extends Loan {
    private String houseAddress;
    private CustomerInfo coLoaner;

    public CustomerInfo getCoLoaner() {
        return coLoaner;
    }

    public void setCoLoaner(CustomerInfo coLoaner) {
        this.coLoaner = coLoaner;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }


    public HouseLoan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo customer,
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

    public HouseLoan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo customer, CustomerInfo coLoaner,
                     CustomerProxy customerProxy) {
        super();
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.customer = customer;
        this.coLoaner = coLoaner;
        this.startDate = new java.util.Date();

        this.customerProxy = customerProxy;
        getAnnualInterestRate();

        if(customerProxy.getCustomer(customer.getSsn())==null) {
            try {
                customerProxy.registerCustomer(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(customerProxy.getCustomer(coLoaner.getSsn())==null) {
            try {
                customerProxy.registerCustomer(coLoaner);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    void getAnnualInterestRate() {
        annualInterestRate = 0.3;
    }

    @Override
    void printLoanInformation() throws Exception {
        System.out.println(customer);
        if(coLoaner!=null )
        {
            System.out.println(coLoaner);
        }
        calculateLoanPayment();
    }
}
