package LargerTasks.bankLoanSolution;

import java.util.HashMap;

public class LoanFactory {
    public static void main(String[] args) {
        CustomerProxy customerProxy = new CustomerProxy(new HashMap<>());
        LoanProxy loanProxy = new LoanProxy(new HashMap<Integer, Loan>());
        CustomerInfo customer1 = new CustomerInfo("12345678901", "ola", "kirkegata 15", "99887766", "ola@gmail.com" );
        CustomerInfo customer2 = new CustomerInfo("12345678902","kari", "hansaparken", "66778899", "kari@gmail.com" );
        CustomerInfo customer3 = new CustomerInfo("12345678903","johaug", "princessgata", "22334455", "johaug@gmail.com" );
        try {
            customerProxy.registerCustomer(customer1);
            customerProxy.registerCustomer(customer2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LoanFactory loanFactory = new LoanFactory();
        try {
            Loan houseLoan = loanFactory.createLoan(10, 2000000, LoanType.HouseLoan, customer1, customer2,
                    customerProxy);
            Loan carLoan = loanFactory.createLoan(5, 500000, LoanType.CarLoan, customer1, null,
                    customerProxy);
            ((CarLoan)carLoan).setTypeOfInsurance(InsuranceType.FullKakso);
            Loan consumerLoan = loanFactory.createLoan(1, 50000, LoanType.ConsumerLoan, customer3, null,
                    customerProxy);
            loanProxy.registerLoan(houseLoan);
            loanProxy.registerLoan(carLoan);
            loanProxy.registerLoan(consumerLoan);

            //loanProxy.printAllLoans();
            loanProxy.printLoanbySsn("12345678902");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loan createLoan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo mainLoaner, CustomerInfo coLoaner,
                           CustomerProxy customerProxy) throws Exception {
        switch (loanType) {
            case CarLoan:
                if(coLoaner!=null) throw new Exception("Car loan can not have coLoaner");
                return new CarLoan(numberOfYears, loanAmount, loanType, mainLoaner,
                        customerProxy);
            case HouseLoan:
                if(coLoaner!=null) {
                    return new HouseLoan(numberOfYears, loanAmount, loanType, mainLoaner, coLoaner,
                            customerProxy);
                } else {
                    return new HouseLoan(numberOfYears, loanAmount, loanType, mainLoaner,
                            customerProxy);
                }

            case ConsumerLoan:
                if(coLoaner!=null) throw new Exception("Consumer loan can not have coLoaner");
                return new ConsumerLoan(numberOfYears, loanAmount, loanType, mainLoaner,
                        customerProxy);
            default:
                throw new Exception();
        }
    }
}

