package com.atm;

import java.util.ArrayList;
import java.util.List;

public class UserAccount {
	
    private String pin;
    private double balance;
    private List<String> transactions;
  //This creates a list to store all the transactions of the user.  ex > depo , witdra

    public UserAccount(String pin, double balance) {
        
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
       // When you create a new user, a new empty list is created. Every user gets their own transaction history.
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void addTransaction(String message) {
        transactions.add(message);
    }

    public List<String> getTransactions() {
        return transactions;
    }

}
