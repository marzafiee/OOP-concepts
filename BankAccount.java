/**
 * Abstract class representing a generic bank account.
 *
 * Features:
 * - Fields: accountNumber, accountHolderName, and balance.
 * - Abstract method: calculateInterest()
 * - Final method: displayAccountDetails() to print account information.
 *
 * Author: Inez Agbenu
 * Date: August 27, 2025
 */
public abstract class BankAccount {
    // instantiating variables or fields
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    // constructor
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // abstract method: calculateInterest()
    public abstract double calculateInterest(double rate, int months);

    //getters
    public double getBalance() { return balance;}
    public int getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }

    // final method that prints account information
    public final void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Current balance: " + balance);
    }

    // toString method
    @Override
    public String toString() {
        String info = "Account Number: " + accountNumber + "\n"
                + "Account Holder Name: " + accountHolderName + "\n"
                + "Current Balance: ₵" + String.format("%.2f", balance);
        return info;
    }
} // class
