package inheritance;

public class MortgageAccount extends Account {
    public MortgageAccount(String accountNumber, String ownername, double balance) {
        super(accountNumber, ownername, balance);
    }

    public void addMonthlyFee() {
        setBalance(getBalance() - 10);
        if (getBalance()  < 0) {
            System.out.println("warning");
        }

    }
}

