package Solutions.step14.src;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface ValidateAge {
    public boolean validate(Integer age);
}

@FunctionalInterface
interface ValidateDate {
    public boolean validate(String startDate);
}

public class LoanOperation {
    HashMap<Integer, LoanInfo> loanHashMap = new HashMap<>();
    static int loanId = 0;

    /**
     * assignment 6: methods reference
     * ValidateDate validateDate
     * ValidateAge validateAge
     */
    ValidateDate validateDate = (startDate)->{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(startDate.compareTo(dateFormat.format(new Date()))<0) {
            return false;
        }
        return true;
    };

    ValidateAge validateAge = (age) -> (!(age >= 60 || age <= 13));

    /**
     * assignment 2: create registerLoan and validateLoan
     */
    public void registerLoan(LoanInfo loan) throws IllegalArgumentException {
        validateLoan(loan);
        loan.setLoanId(loanId++);
        loanHashMap.put(loan.getLoanId(), loan);
    }

    private boolean dateIsValid(String startDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        if(startDate.compareTo(dateFormat.format(new Date()))<0) {
            return false;
        }
        return true;
    }

    private boolean ageIsValid(Integer age) {
        if(age >= 60 || age <= 13)
            return false;
        return true;
    }

    private void validateLoan(LoanInfo loanInfo) {
        if (loanInfo == null) {
            throw new IllegalArgumentException("Null loan is not allowed when registering a new loan");
        }
        if (loanInfo.getCustomer() == null) {
            throw new IllegalArgumentException("Please ensure valid customer when registering a new loan");
        }
/*        if(!ageIsValid(loanInfo.getCustomer().getAge())) {
            throw new IllegalArgumentException("Please ensure valid customer age when registering a new loan");
        }*/
        if(!validateAge.validate(loanInfo.getCustomer().getAge())) {
            throw new IllegalArgumentException("Please ensure valid customer age when registering a new loan");
        }

        if (loanInfo.getLoanAmount() <= 0) {
            throw new IllegalArgumentException("Please ensure the loan amount > 0 when registering a new loan");
        }
/*        if (!dateIsValid(loanInfo.startDate)) {
            throw new IllegalArgumentException("Please ensure valid start date when registering a new loan");
        }*/
        if (!validateDate.validate(loanInfo.startDate)) {
            throw new IllegalArgumentException("Please ensure valid start date when registering a new loan");
        }
    }

    /**
     * Task 3:
     * create non-optional methods
     * getLoanByLoanId
     * getLoansByName
     * getLoansByStartDate
     */
    public LoanInfo getLoanByLoanId(Integer loanId) {
        for (LoanInfo loan :
                loanHashMap.values()) {
            if (loan.loanId == loanId) {
                return loan;
            }
        }
        return null;
    }

    public List<LoanInfo> getLoansByName(String name) {
        ArrayList<LoanInfo> list = new ArrayList<>();
        for (LoanInfo loan :
                loanHashMap.values()) {
            if (loan.getCustomer().getName().equalsIgnoreCase(name)) {
                list.add(loan);
            }
        }
        return list;
    }

    public ArrayList<LoanInfo> getLoansByStartDate(String startDate) {
        ArrayList<LoanInfo> list = new ArrayList<>();
        for (LoanInfo loan :
                loanHashMap.values()) {
            if (loan.getStartDate().equalsIgnoreCase(startDate)) {
                list.add(loan);
            }
        }
        return list;
    }

    /**
     * Task 4: create optional methods
     * getLoanByLoanIdOptional
     * getLoansByNameOptional
     * getLoansByNameOptional
     */
    public Optional<LoanInfo> getLoanByLoanIdOptional(Integer loanId) {
        for (LoanInfo loan :
                loanHashMap.values()) {
            if (loan.loanId == loanId) {
                return Optional.of(loan);
            }
        }
        return Optional.empty();
    }

    public Optional<List<LoanInfo>> getLoansByNameOptional(String name) {
        List<LoanInfo> LoansbyName = loanHashMap.entrySet()
                .stream()
                .map(entry->entry.getValue())
                .filter(loan-> loan.customer.getName().equals(name))
                .collect((Collectors.toList()));
        return Optional.ofNullable(LoansbyName);
    }


    public Optional<ArrayList<LoanInfo>> getLoansByStartDateOptional(String startDate) {
        ArrayList<LoanInfo> filteredLoanList = null;
        if(dateIsValid(startDate)) {
            filteredLoanList = getLoansByStartDateLambda(startDate);
        }
        return Optional.ofNullable(filteredLoanList);
    }

    /**
     * Task 5: create below methods using lambda expressions
     * getLoansByNameLambda
     * getLoansByStartDateLambda
     */
    public List<LoanInfo> getLoansByNameLambda(String name) {
        List<LoanInfo> LoansbyName = loanHashMap.entrySet()
                .stream()
                .map(entry->entry.getValue())
                .filter(loan-> loan.customer.getName().equals(name))
                .collect((Collectors.toList()));
        return LoansbyName;
    }

    public ArrayList<LoanInfo> getLoansByStartDateLambda(String startDate) {
        ArrayList<LoanInfo> list = new ArrayList<>();
        Stream<LoanInfo> filtered_data = loanHashMap.values().stream().filter(loan -> loan.getStartDate().equalsIgnoreCase(startDate));
        filtered_data.forEach((loan)->list.add(loan));
        return list;
    }


}
