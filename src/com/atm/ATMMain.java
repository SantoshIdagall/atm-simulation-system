package com.atm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMMain {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        // Store by PIN (like ATM card)
	        Map<String, UserAccount> users = new HashMap<>();
	        users.put("1234", new UserAccount("1234", 5000));
	        users.put("1111", new UserAccount("1111", 10000));

	        System.out.println("====== Welcome to State Bank India ======");
	        System.out.println(" Insert Youtr Atm Card");

	        System.out.print(" Enter Your  PIN: ");
	        String pin = sc.nextLine();

	        if (!users.containsKey(pin)) {
	            System.out.println("Invalid PIN enter Try again.");
	            return;
	        }

	        UserAccount loggedUser = users.get(pin);
	        AtmInside atm = new AtmInside(loggedUser);

	        System.out.println("\nLogin Successful! Welcome.");

	        // ATM MENU
	        while (true) {
	            System.out.println("\n===== ATM MENU =====");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Transaction History");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");

	            try {
	                int choice = Integer.parseInt(sc.nextLine());

	                // PIN verification for every operation
	                if (choice >= 1 && choice <= 4) {
	                    System.out.print("Enter PIN for verification: ");
	                    String verifyPin = sc.nextLine();

	                    if (!verifyPin.equals(loggedUser.getPin())) {
	                        System.out.println("Wrong PIN Enter");
	                        continue;
	                    }
	                }

	                switch (choice) {

	                    case 1:
	                        atm.viewBalance();
	                        break;

	                    case 2:
	                        System.out.print("Enter deposit amount: ");
	                        double dep = Double.parseDouble(sc.nextLine());
	                        atm.deposit(dep);
	                        break;

	                    case 3:
	                        System.out.print("Enter withdrawal amount: ");
	                        double wd = Double.parseDouble(sc.nextLine());
	                        atm.withdraw(wd);
	                        break;

	                    case 4:
	                        atm.viewTransactionHistory();
	                        break;

	                    case 5:
	                        System.out.println("Thank you for using ATM!");
	                        return;

	                    default:
	                        System.out.println("Invalid option!");
	                }

	            } catch (Exception e) {
	                System.out.println("Invalid input!");
	            }
	        }
	    }
}
