package Solutions.step14.src;

import java.util.Objects;

public class LoanInfo {
    double loanAmount;
    Customer customer;
    String startDate;
    Integer loanId;

    public LoanInfo(double loanAmount, Customer customer, String startDate) {
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

    public Customer getCustomer() {
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

    @Override
    public String toString() {
        return String.format("Loan info: loanAmount is %f, customer is %s, startDate is %s",
                loanAmount, customer.toString(), startDate);
    }
    //Assignment 3. Overriding equals (inherited from Object)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanInfo loan = (LoanInfo) o;
        return  loanAmount == loan.loanAmount &&
                startDate == loan.startDate &&
                Objects.equals(customer, loan.customer);
    }

    //Assignment 3. When overriding equals, we must also override hashCode (also from Object)
    @Override
    public int hashCode() {
        return Objects.hash(loanAmount, startDate, customer);
    }
}
