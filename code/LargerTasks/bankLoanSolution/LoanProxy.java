package LargerTasks.bankLoanSolution;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoanProxy implements ILoanProxy{
    HashMap<Integer, Loan> loanHashMap = new HashMap<>();
    static int loanId = 0;

    public LoanProxy(HashMap<Integer, Loan> loanHashMap) {
        this.loanHashMap = loanHashMap;
    }

    @Override
    public Loan getLoan(Integer loanId) {
        return loanHashMap.get(loanId);
    }

    @Override
    public void registerLoan(Loan loan) throws Exception {
        loan.setLoanId(loanId++);
        loanHashMap.put(loan.getLoanId(), loan);
    }

    @Override
    public void printAllLoans() throws Exception {
        for(Integer index : loanHashMap.keySet()) {
            System.out.println("Loan Id is "+index);
            loanHashMap.get(index).printLoanInformation();
        }
    }

    @Override
    public void printLoanbySsn(String ssn) throws Exception {

/*        Map<Integer, Loan> newLoanHashMap = loanHashMap.entrySet()
                .stream()
                .filter(entry-> entry.getValue() instanceof HouseLoan)
                .map(loan -> (HouseLoan)loan)
                .filter(loan-> loan.customer.getSsn().equals(ssn) || loan.getCoLoaner().getSsn().equals(ssn))
                .collect(Collectors.toMap(loan -> loan.getLoanId(), loan -> loan));*/

        List<Loan> newLoans = loanHashMap.entrySet()
                .stream()
                .map(entry->entry.getValue())
                .filter(loan-> loan instanceof HouseLoan? ((HouseLoan)loan).getCoLoaner().getSsn().equals(ssn)  || ((HouseLoan)loan).customer.getSsn().equals(ssn)
                        : loan.customer.getSsn().equals(ssn))
                .collect((Collectors.toList()));

        for(Loan loan : newLoans) {
            System.out.println("Loan Id is "+ loan.getLoanId());
            loan.printLoanInformation();
        }

    }
}
