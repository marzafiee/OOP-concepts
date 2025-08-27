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
public class CurrentAccount extends BankAccount {
    // instance variables
    private double interestRate;
    private double time; // in years - it can also be 1,5 or 5.4, hence why the type is double

    // constructor
    public CurrentAccount(String accountHolderName, int accountNumber, double balance, double interestRate, double time) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
        this.time = time;
    }

    // implementing calculateInterest()
    @Override
    public double calculateInterest(double rate, double time) {
        return getBalance() * rate * time; // following simple interest calculation (SI = PRT)
    }
    // getters
    public void getInterestRate() { return this.interestRate; }
    public void getTimeInYears() { return this.time; }

    // setters for changine fields later on - to avoid hardcoding
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void setTime(double time) { this.time = time; }

    // overriding the toString method
    @Override
    public String toString() {
        double interest = calculateInterest(interestRate, time);
        double finalBalance = getBalance() + interest;
        return super.toString() + "\n" +
                "Interest Rate: " + (interestRate * 100) + "\n" +
                "Time (in years): " + time + "\n" +
                "Balance after Interest: ₵" + String.format(%.2f, finalBalance);
    }
}//class