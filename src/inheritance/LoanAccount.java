package inheritance;

public class LoanAccount extends Account {
    public LoanAccount(String accountNumber, String ownername, double balance) {
        super(accountNumber, ownername, balance);
    }
    public void chargeInterest() {
        double interest = getBalance()*1.05;
        setBalance(interest);
    }
}

