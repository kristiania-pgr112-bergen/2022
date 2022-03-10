package Solutions.step14.src;
import LectureCode.Session14.src.GcExample;

import java.lang.ref.Cleaner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LoanOperation loanOperation = new LoanOperation();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        Date tomorrow = cal.getTime();
        cal.add(Calendar.DATE, -2);
        Date yesterday = cal.getTime();

        Customer customer0 = new Customer("Test", 10);
        Customer customer1 = new Customer("Tom", 20);
        Customer customer2 = new Customer("Jerry", 15);
        LoanInfo loanInfo0 = new LoanInfo(1000000, customer0, dateFormat.format(today));
        LoanInfo loanInfo1 = new LoanInfo(1000000, customer1, dateFormat.format(today));
        LoanInfo loanInfo2 = new LoanInfo(500000, customer2, dateFormat.format(yesterday));
        LoanInfo loanInfo3 = new LoanInfo(100000, customer1, dateFormat.format(today));
        LoanInfo loanInfo4 = new LoanInfo(200000, customer2, dateFormat.format(tomorrow));
        try {
            loanOperation.registerLoan(loanInfo0);
        } catch (IllegalArgumentException e) {
            System.out.println("catch IllegalArgumentException as expected");
            System.out.println(e.getMessage());
        }

        try {
            loanOperation.registerLoan(loanInfo1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loanOperation.registerLoan(loanInfo2);
        } catch (IllegalArgumentException e) {
            System.out.println("catch IllegalArgumentException as expected");
            System.out.println(e.getMessage());
        }

        try {
            loanOperation.registerLoan(loanInfo3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            loanOperation.registerLoan(loanInfo4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("loanOperation getLoanByLoanId 6");
        Optional<LoanInfo> myloan = loanOperation.getLoanByLoanIdOptional(6);
        if(myloan.isPresent()){
            System.out.println("I have found the Loan info" + myloan.get());
        }else{
            System.out.println("Nothing was found");
        }

        System.out.println("loanOperation getLoansByName Tom");
        List<LoanInfo> myloans =  loanOperation.getLoansByNameLambda("Tom");
        System.out.println("Loan found for Tom:");
        for (LoanInfo loan :
                myloans) {
            System.out.println(loan);
        }

        System.out.println("loanOperation getLoansByName Test user");
        Optional<List<LoanInfo>> myloans2 = loanOperation.getLoansByNameOptional("Test user");
        System.out.println("Loan found for Test user:");
        if(myloans2.isEmpty()) {
            System.out.println("newloans is empty");
        } else {
            for (LoanInfo loan :
                    Optional.of(myloans2.get()).orElse(new ArrayList<>())) {
                System.out.println(loan);
            }
        }

        System.out.println("loanOperation getLoansByStartDateOptional today");
        Optional<ArrayList<LoanInfo>> getLoansByToday = loanOperation.getLoansByStartDateOptional(dateFormat.format(today));

        System.out.println("print Optional ifPresent");
        getLoansByToday.ifPresent(loan -> System.out.println(loan));

        System.out.println("print method reference");
        getLoansByToday.get().forEach(System.out::println);

        System.out.println("loanOperation getLoansByStartDateOptional yesterday");
        Optional<ArrayList<LoanInfo>> getLoansByYesterday = loanOperation.getLoansByStartDateOptional(dateFormat.format(yesterday));
        if(getLoansByYesterday.isEmpty()) {
            System.out.println("getLoansByYesterday is empty");
        } else {
            for (LoanInfo loan :
                    Optional.of(getLoansByYesterday.get()).orElse(new ArrayList<>())) {
                System.out.println(loan);
            }
        }


    }

}
