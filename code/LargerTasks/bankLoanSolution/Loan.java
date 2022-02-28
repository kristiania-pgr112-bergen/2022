package LargerTasks.bankLoanSolution;

import java.util.HashMap;

/**
 * java.io.Serializable is a public interface
 */
public abstract class Loan implements java.io.Serializable{
    double annualInterestRate;
    int numberOfYears;
    double loanAmount;
    LoanType loanType;
    CustomerInfo customer;
    java.util.Date startDate;
    Integer loanId;

    CustomerProxy customerProxy;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Loan() {
    }

    public Loan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo customer,
                CustomerProxy customerProxy) {
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.customer = customer;
        this.startDate = new java.util.Date();

        this.customerProxy = customerProxy;
     }

    /**
     * abstract method
     */
    abstract void getAnnualInterestRate();
    abstract void printLoanInformation() throws Exception;

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        loanType = loanType;
    }

    /**
     * regular method
     */
    public void calculateLoanPayment()
    {
        double monthlyInterestRate=annualInterestRate/1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        System.out.println(" The Loan Type:          "+loanType.toString());
        System.out.println(" The Loan starts from:          "+startDate);
        System.out.println(" The Loan Amount:          NOK"+loanAmount);
        System.out.println(" The Annual interest rate:          %"+annualInterestRate);
        System.out.println(" Monthly payment     NOK"+monthlyPayment);
        System.out.println(" Total payment     NOK"+totalPayment);
    }
}
