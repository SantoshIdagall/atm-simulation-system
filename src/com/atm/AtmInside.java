package com.atm;

public class AtmInside implements AtmOperation{

	 private UserAccount user;

	    public AtmInside(UserAccount user) {
	        this.user = user;
	    }

	    @Override
	    public void viewBalance() {
	        System.out.println("Your Balance: ₹" + user.getBalance());
	    }

	    @Override
	    public void deposit(double amount) {
	        user.addBalance(amount);
	        user.addTransaction("Deposited: ₹" + amount);
	        System.out.println("Deposit Successful!");
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= user.getBalance()) {
	            user.deductBalance(amount);
	            user.addTransaction("Withdrawn: ₹" + amount);
	            System.out.println("Withdrawal Successful!");
	        } else {
	            System.out.println("Insufficient Balance!");
	        }
	    }

	    @Override
	    public void viewTransactionHistory() {
	        System.out.println("=== Transaction History ===");
	        for (String t : user.getTransactions()) {
	            System.out.println(t);
	        }
	    }
}
