package pages;

public class BankAccount {

    static int accountBalance;
    static int remainingBalance;

    public void depositAmount(int amount) {
        accountBalance = amount;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setRemainingBalance(int balance) {
        remainingBalance = balance;
    }

    public int getRemainingBalance() {
        return remainingBalance;
    }
}
