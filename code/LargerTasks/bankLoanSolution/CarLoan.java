package LargerTasks.bankLoanSolution;


public class CarLoan extends Loan {
    private String carModel;
    private String miles;
    private InsuranceType typeOfInsurance;


    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public InsuranceType getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(InsuranceType typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public CarLoan(int numberOfYears, double loanAmount, LoanType loanType, CustomerInfo customer,
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
        annualInterestRate = 0.4;
    }

    @Override
    void printLoanInformation() throws Exception {
        System.out.println(customer);
        System.out.println("This car model is "+carModel);
        System.out.println("The miles is "+miles);
        System.out.println("The type of insurance is "+typeOfInsurance);
        calculateLoanPayment();
    }
}
