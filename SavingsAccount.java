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
public class SavingsAccount extends BankAccount {
    // instance variables following the compound interest formula A = P × (1 + r/n)^(nt)
    private double interestRate; // this is r
    private int compountAmountYearly; // this is n
    private double time; // in years - it can also be 1,5 or 5.4, hence why the type is double

    // constructor
    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate, int compountAmountYearly, double time) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
        this.compountAmountYearly = compountAmountYearly;
        this.time = time;
    }

    // implementing calculateInterest() with aforementioned formula: A = P × (1 + r/n)^(nt)
    @Override
    public double calculateInterest(double rate, double time) {
        double principal = getBalamce();
        int n = compountAmountYearly;
        double actualCompoundAmount = principal * [(1 + rate / n) ** (n * time)];
        double finalInterest = actualCompoundAmount - principal;
        return finalInterest;
    }
    // getters
    public double getInterestRate() { return this.interestRate; }
    public int getCompountAmountYearly() { return this.compountAmountYearly; }
    public double getTimeInYears() { return this.time; }

    // setters for changine fields later on - to avoid hardcoding
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void setCompountAmountYearly(int compountAmountYearly) { this.compountAmountYearly = compountAmountYearly; }
    public void setTime(double time) { this.time = time; }

    // overriding the toString method
    @Override
    public String toString() {
        double interest = calculateInterest(interestRate, time);
        double finalBalance = getBalance() + interest;
        return super.toString() + "\n" +
                "Interest Rate: " + (interestRate * 100) + "\n" +
                "Compunded: " + compountAmountYearly + "annually" + "\n" +
                "Interest Earned: ₵" + String.format(%.2f, interest) + "\n" +
                "Time (in years): " + time + "\n" +
                "Balance after Interest: ₵" + String.format(%.2f, finalBalance);
    }
}//class