package Solutions.step14codebasis.src;

import Solutions.step14.src.Customer;

public class LoanInfo {
    double loanAmount;
    Solutions.step14.src.Customer customer;
    String startDate;
    Integer loanId;

    public LoanInfo(double loanAmount, Solutions.step14.src.Customer customer, String startDate) {
        this.loanAmount = loanAmount;
        this.customer = customer;
        this.startDate = startDate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Solutions.step14.src.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    /**
     * Task 1. Overriding toString, equals and hashCode
     */

}
