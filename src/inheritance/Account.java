package inheritance;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public void setAccountNumber(String accountNumber) {
        if (accountNumber != null && accountNumber.length() >= 4) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("error and do not change the field");
        }

    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && ownerName.length() >= 3) {
            this.ownerName = ownerName;
        } else {
            System.out.println("error");
        }

    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("error");

        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount");
        }

    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Not enough balance");
        }
    }

}




