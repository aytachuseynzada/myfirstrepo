package inheritance;

public class DepositAccount extends Account {
    public DepositAccount(String accountNumber, String ownername, double balance) {
        super(accountNumber, ownername, balance);
    }
    public void addMonthlyBonus() {
        var bonus = getBalance()*1.01;
        setBalance(bonus);

    }
}
