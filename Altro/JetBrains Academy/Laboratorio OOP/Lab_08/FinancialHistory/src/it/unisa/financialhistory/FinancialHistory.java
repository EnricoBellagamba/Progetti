package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        /* TODO */
    }

    public void receiveFrom(int amount, String source) {
        /* TODO */
    }

    public void spendFor(int amount, String reason) {
        if (amount > 0) {
            throw new IllegalArgumentException("Il movimento deve essere negativo");
        }
        //Bisogna invertire il segno perché le somme delle spese sono sempre negativi
        if (amount * -1 > balance)
            throw new IllegalArgumentException("Non hai abbastanza denaro");
        this.movements.add(new Movement(reason, amount));
        this.balance += amount;
    }

    public double cashOnHand() {
        /* TODO */
    }

    public double totalReceivedFrom(String source) {
        /* TODO */
    }

    public double totalSpentFor(String reason) {
        /* TODO */
    }

    public void printMovements() {
        /* TODO */
    }

}
