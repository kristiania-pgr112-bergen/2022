package LectureCode.Session6.src;

import java.util.Scanner;
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundException extends Exception {
    public InsufficientFundException(String message) {
        super(message);
    }
}

class StudentBank{
    private double balance;
    public void deposite(double amount) throws InvalidAmountException {
        if(amount <= 0) {
            throw new InvalidAmountException(amount + "is not valid");
        }
        balance+= amount;
    }
    public void withdraw(double amount) throws InsufficientFundException {
        if(balance < amount) {
            throw new InsufficientFundException("Insufficient fund");
        }
        balance-= amount;
    }
    public void showBalance() {
        System.out.println("Your current balance is "+balance);
    }
}
public class StudentBankExample {
    public void runProgram(){
        try {
            Scanner scanner = new Scanner(System.in);
            StudentBank studentBank = new StudentBank();
            String option = "";
            do {
                System.out.println("1. DEPOSITE");
                System.out.println("2. WITHDRAW");
                System.out.println("3. SHOW BALANCE");
                System.out.println("ENTER OPTION");
                option = scanner.next();
                switch (option) {
                    case "1": {
                        System.out.println("ENTER DEPOSITE AMOUNT");
                        double amount = scanner.nextDouble();
                        studentBank.deposite(amount);
                        studentBank.showBalance();
                        break;
                    }
                    case "2": {
                        System.out.println("ENTER WITHDRAW AMOUNT");
                        double amount = scanner.nextDouble();
                        studentBank.withdraw(amount);
                        studentBank.showBalance();
                        break;
                    }
                    case "3": {
                        System.out.println("SHOW BALANCE");
                        studentBank.showBalance();
                        break;
                    }
                    default:
                        System.out.println("INVALID OPTION");
                }
                System.out.println("DO YOU WANT TO CONTINUE? (YES/NO)");
                option = scanner.next();
            } while (option.equalsIgnoreCase("YES"));
        }catch(InvalidAmountException e){
            System.out.println(e.getMessage());
        } catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

