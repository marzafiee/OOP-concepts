/**
 * Main class
 *
 * Author: Inez Agbenu
 * Date: August 27, 2025
 */
public class BankAccountDemo {
    public static void main(String[] args) {
        // constructor: public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate, int compountAmountYearly, double time,
        //                         double loanAmount, double yearsOfLoan)
        BankAccount trialAccount = new SavingsAccount("Eyra Agbenu", 400052, 400.0, 0.80, 200, 2.0, 800, 1.5);
        BankAccount trialAccount2 = new SavingsAccount("John Agbenu", 4000032, 450.0, 0.80, 200, 2.0, 800, 1.5);
        SavingsAccount.a;

        double interest = trialAccount.calculateInterest(0.05, 2);
        System.out.println(trialAccount.toString());
    }
}