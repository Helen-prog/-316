package lesson_7.account;

public class SavingAccount implements Account {

    private double balance;
    private double interestRate;

    public SavingAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void applyInterest() {
        balance += balance * interestRate / 100;
    }
}
