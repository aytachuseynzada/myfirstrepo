package inheritance;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[3];

        while (true) {
            System.out.println("1.Create account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Run special action");
            System.out.println("5.Show account info");
            System.out.println("0.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            if (choice == 1) {

                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                System.out.println("Enter owner name");
                String ownerName = sc.nextLine();

                System.out.println("Enter starting balance");
                double startingBalance = sc.nextDouble();

                System.out.println("Enter account type: 1(loan)/2(deposit)/3(mortgage)");
                int accountType = sc.nextInt();
                sc.nextLine();

                Account newAcc = null;

                if (accountType == 1) {
                    newAcc = new LoanAccount(accountNumber, ownerName, startingBalance);
                } else if (accountType == 2) {
                    newAcc = new DepositAccount(accountNumber, ownerName, startingBalance);
                } else if (accountType == 3) {
                    newAcc = new MortgageAccount(accountNumber, ownerName, startingBalance);
                } else {
                    System.out.println("INVALID ACCOUNT TYPE");
                    continue;
                }

                boolean added = false;
                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i] == null) {
                        accounts[i] = newAcc;
                        System.out.println("Account created!");
                        added = true;
                        break;
                    }
                }

                if (!added) {
                    System.out.println("No space left for new accounts.");
                }
            }

            if (choice == 2) {

                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                System.out.println("Enter deposit amount");
                double amount = sc.nextDouble();
                sc.nextLine();

                boolean found = false;

                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)) {
                        accounts[i].deposit(amount);
                        System.out.println("Deposit successful.");
                        found = true;
                        break;
                    }
                }

                if (!found) System.out.println("Account not found!");
            }

            if (choice == 3) {

                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                System.out.println("Enter withdraw amount");
                double amount = sc.nextDouble();
                sc.nextLine();

                boolean found = false;

                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)) {
                        accounts[i].withdraw(amount);
                        System.out.println("Withdraw successful.");
                        found = true;
                        break;
                    }
                }

                if (!found) System.out.println("Account not found!");
            }

            if (choice == 4) {

                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < accounts.length; i++) {
                    Account acc = accounts[i];

                    if (acc != null && acc.getAccountNumber().equals(accountNumber)) {

                        if (acc instanceof LoanAccount) {
                            ((LoanAccount) acc).chargeInterest();
                        } else if (acc instanceof MortgageAccount) {
                            ((MortgageAccount) acc).addMonthlyFee();
                        } else if (acc instanceof DepositAccount) {
                            ((DepositAccount) acc).addMonthlyBonus();
                        }

                        System.out.println("Special action executed.");
                        found = true;
                        break;
                    }
                }

                if (!found) System.out.println("Account not found!");
            }

            if (choice == 5) {

                System.out.println("Enter account number");
                String accountNumber = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < accounts.length; i++) {
                    if (accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)) {
                        System.out.println(accounts[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) System.out.println("Account not found!");
            }
        }
    }
}