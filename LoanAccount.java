/**
 * interface
 *
 * Features:
 * - Has a method applyForLoan() that SavingsAccount class implements
 *
 * Author: Inez Agbenu
 * Date: August 27, 2025
 */
public interface LoanAccount{
    boolean applyForLoan(double loanAmount, double yearsOfLoan); // note that this method is both public and abstract by default
}