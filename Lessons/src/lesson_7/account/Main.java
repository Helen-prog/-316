package lesson_7.account;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingAccount savingAccount = new SavingAccount(1000, 1.25);
        System.out.println("===== Сберегательный счет =====\nПервоначальный депозит: $" + savingAccount.getBalance() + "\nПроцентная ставка: " + savingAccount.getInterestRate() + "%\n");

        CurrentAccount currentAccount = new CurrentAccount(5000.0, 1000.0);
        System.out.println("===== Текущий счет =====\nПервоначальный депозит: $" + currentAccount.getBalance() + "\nЛимит овердрафта: $" + currentAccount.getOverdraftLimit());

        bank.addAccount(savingAccount);
        bank.addAccount(currentAccount);

        System.out.println("\nВносим 100 долларов на сберегательный счет.");
        bank.deposit(savingAccount, 100.0);

        System.out.println("\nВносим 500 долларов на текущий счет.");
        bank.deposit(currentAccount, 500.0);

        System.out.println("\nСнимаем 150 долларов со сберегательного счета");
        bank.withdraw(savingAccount, 150.0);

        System.out.println("\n===== Сберегательный счет и текущий счет =====");
        bank.printAccountBalance();

        savingAccount.applyInterest();
        System.out.println("\nПосле начисления процентов на сберегательный счет после 1 года");

        System.out.println("\n===== Сберегательный счет и текущий счет =====");
        bank.printAccountBalance();
    }
}
