package LargerTasks.bankLoanSolution;

public class CustomerInfo {
    private String name;
    private String address;
    private String phone;
    private String email;
    private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public CustomerInfo(String ssn, String name, String address, String phone, String email) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString() {
        return String.format("Customer info: ssn is %s, name is %s, address is %s, phone is %s, email is %s",
                ssn, name, address, phone, email);
    }
}
