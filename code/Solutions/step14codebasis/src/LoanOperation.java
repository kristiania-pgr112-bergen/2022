package Solutions.step14codebasis.src;

import Solutions.step14.src.LoanInfo;

import java.util.HashMap;

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
     * Task 6: methods reference
     * ValidateDate validateDate
     * ValidateAge validateAge
     */


    /**
     * Task 2: create below methods
     * registerLoan
     * validateLoan
     */

    /**
     * Task 3:
     * create non-optional methods
     * getLoanByLoanId
     * getLoansByName
     * getLoansByStartDate
     */

    /**
     * Task 4: create optional methods
     * getLoanByLoanIdOptional
     * getLoansByNameOptional
     * getLoansByNameOptional
     */

    /**
     * Task 5: create below methods using lambda expressions
     * getLoansByNameLambda
     * getLoansByStartDateLambda
     */

}
