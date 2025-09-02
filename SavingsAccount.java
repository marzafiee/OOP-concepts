/**
 * concrete subclass representing a generic bank account.
 *
 * Features:
 * - Implement calculateInterest() differently.
 * - Override the toString() method.
 *
 * Author: Inez Agbenu
 * Date: August 27, 2025
 */
// note that when declaring a class, extends always comes before implements
public class SavingsAccount extends BankAccount implements LoanAccount{
    // instance variables following the compound interest formula A = P × (1 + r/n)^(nt)
    private double interestRate; // this is r
    private final int compountAmountYearly; // this is n
    private double time; // in years - it can also be 1,5 or 5.4, hence why the type is double
    private double loanAmount, yearsOfLoan;
    public static int a;

    // constructor 1 - main (with everything - balance and loan)
    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate, int compountAmountYearly, double time,
                         double loanAmount, double yearsOfLoan) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
        this.compountAmountYearly = compountAmountYearly;
        this.time = time;
        this.loanAmount = loanAmount;
        this.yearsOfLoan = yearsOfLoan;
    }

    // constructor 2 - (without balance and without loan) ---- constructor overloading
    public SavingsAccount(String accountHolderName, int accountNumber, double interestRate, int compountAmountYearly, double time) {
        super(accountHolderName, accountNumber);
        this.interestRate = interestRate;
        this.compountAmountYearly = compountAmountYearly;
        this.time = time;
    }

    // constructor 3 - (with balance and no loan application)
    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate, int compountAmountYearly, double time) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
        this.compountAmountYearly = compountAmountYearly;
        this.time = time;
    }

    // constructor 4 - (with loan and no balance)
    public SavingsAccount(String accountHolderName, int accountNumber, double interestRate, int compountAmountYearly, double time, double loanAmount, double yearsOfLoan) {
        super(accountHolderName, accountNumber);
        this.interestRate = interestRate;
        this.compountAmountYearly = compountAmountYearly;
        this.time = time;
        this.loanAmount = loanAmount;
        this.yearsOfLoan = yearsOfLoan;
    }

    // implementing calculateInterest() with aforementioned formula: A = P × (1 + r/n)^(nt)
    @Override
    public double calculateInterest(double rate, double time) {
        double principal = getBalance();
        int n = compountAmountYearly;
        double actualCompoundAmount = principal * Math.pow((1 + rate / n), (n * time));
        double finalInterest = actualCompoundAmount - principal;
        return finalInterest;
    }

    // getters
    public double getInterestRate() { return this.interestRate; }
    public int getCompountAmountYearly() { return this.compountAmountYearly; }
    public double getTimeInYears() { return this.time; }

    // setters for changine fields later on - to avoid hardcoding
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    // public void setCompountAmountYearly(int compountAmountYearly) { this.compountAmountYearly = compountAmountYearly; }
    public void setTime(double time) { this.time = time; }

    // LoanAccount intercae implementation of method applyForLoan()
    @Override
    public boolean applyForLoan(double loanAmount, double yearsOfLoan) {
        // let's assume anyone can apply for a loan only up to 2 times their balance
        double maxLoanAmount = 2 * super.getBalance();

        // exceptions
        if(loanAmount <= 0 || yearsOfLoan <= 0) {
            System.out.println("Invalid loan amount or time. It should be a positive value");
            return false;
        }

        if (loanAmount > maxLoanAmount) {
            // can't request a loan that is more than twice their bank balance
            System.out.println("Loan Denied because the requested amount exceeds limit (2 times the balance");
            return false;

        }

        // loan approved if all else fails
        System.out.println("Loan Approved for amount: ₵" + loanAmount + " over a period of " + yearsOfLoan + " years.");
        return true;
    }

    // overriding the toString method
    @Override
    public String toString() {
        double interest = calculateInterest(interestRate, time);
        double finalBalance = getBalance() + interest;
        return super.toString() + "\n" +
                "Interest Rate: " + (interestRate * 100) + "%\n" +
                "Compounded: " + compountAmountYearly + "annually" + "\n" +
                "Interest Earned: ₵" + String.format("%.2f", interest) + "\n" +
                "Time (in years): " + time + "\n" +
                "Balance after Interest: ₵" + String.format("%.2f", finalBalance);
    }
}//class