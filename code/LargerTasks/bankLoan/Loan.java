package LargerTasks.bankLoan;

public abstract class Loan implements java.io.Serializable{
    double annualInterestRate;
    int numberOfYears;
    double loanAmount;
    LoanType loanType;
    CustomerInfo customer;
    java.util.Date startDate;
    /**
     * Task 2
     */
    /**
     * Constructors
     * Getters/Setters
     */


    /**
     *Make a regular method called calculateLoanPayment()
     */
    /**
     * Make an abstract method called getAnnualInterestRate()
     * It will be overriden by Child classes
     */
    /**
     * make an abstract method called printLoanInformation()
     * It will be overriden by Child classes
     */
}
