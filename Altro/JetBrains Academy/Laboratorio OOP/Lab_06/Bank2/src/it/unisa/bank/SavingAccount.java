package it.unisa.bank;

public class SavingAccount /* TODO */ {

    private double interestRate;

    /**
     * A saving account has a balance that can be changed by deposits and withdrawals.
     */
    public SavingAccount(String customerName, double interestRate) {
        /* TODO */
    }

    public SavingAccount(String customerName, double initialBalance, double interestRate) {
        /* TODO */
    }

    /**
     * Add the interest rate for three months
     */
    public void addInterest() {
        /* TODO */
    }

    /**
     * Gets the interest rate of the saving account.
     *
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate of the saving account.
     *
     * @param interestRate the interest rate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}