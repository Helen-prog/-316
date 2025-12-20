package bankingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
    private static final String user = "root";
    private static final String password = "123456";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Scanner scanner = new Scanner(System.in);
            User user = new User(connection, scanner);
            Accounts accounts = new Accounts(connection, scanner);
            AccountManager accountManager = new AccountManager(connection, scanner);

            String email;
            long accountNumber;

            while (true) {
                System.out.println("*** ДОБРО ПОЖАЛОВАТЬ В БАНКОВСКУЮ СИСТЕМУ ***");
                System.out.println();
                System.out.println("1. Регистрация");
                System.out.println("2. Авторизация");
                System.out.println("3. Выход");
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if (email != null) {
                            System.out.println("Пользователь вошел в систему!\n");
                            if (!accounts.accountExists(email)) {
                                System.out.println("1. Открытие нового банковского счета");
                                System.out.println("2. Выход");
                                System.out.print("Ваш выбор: ");
                                if (scanner.nextInt() == 1) {
                                    accountNumber = accounts.openAccount(email);
                                    System.out.println("Аккаунт создан успешно");
                                    System.out.println("Ваш номер счета: " + accountNumber);
                                } else {
                                    break;
                                }
                            }
                            accountNumber = accounts.getAccountNumber(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println("1. Снятие личных средств");
                                System.out.println("2. Займ кредитных средств");
                                System.out.println("3. Перевод денег");
                                System.out.println("4. Проверка баланса");
                                System.out.println("5. Выход");
                                System.out.print("Ваш выбор: ");
                                choice2 = scanner.nextInt();
                                switch (choice2) {
                                    case 1:
                                        accountManager.debitMoney(accountNumber);
                                        break;
                                    case 2:
                                        accountManager.creditMoney(accountNumber);
                                        break;
                                    case 3:
                                        accountManager.transferMoney(accountNumber);
                                        break;
                                    case 4:
                                        accountManager.getBalance(accountNumber);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Такого варианта нет!");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Некорректный адрес почты или пароль!\n");
                        }
                        break;
                    case 3:
                        System.out.println("Выход из системы!");
                        return;
                    default:
                        System.out.println("Такого варианта нет");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
