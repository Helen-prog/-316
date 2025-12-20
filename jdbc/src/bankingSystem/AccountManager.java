package bankingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager {
    private Connection connection;
    private Scanner scanner;

    public AccountManager(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void debitMoney(long accountNumber) throws SQLException {
        scanner.nextLine();
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите PIN-код: ");
        String securityPin = scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if (accountNumber != 0){
                PreparedStatement preparedStatement = connection.prepareStatement("select * from account where account_number = ? and security_pin = ?");
                preparedStatement.setLong(1, accountNumber);
                preparedStatement.setString(2, securityPin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    double currentBalance = resultSet.getDouble("balance");
                    if(amount <= currentBalance){
                        String debit_query = "update account set balance = balance - ? where account_number = ?";
                        PreparedStatement debitStatement = connection.prepareStatement(debit_query);
                        debitStatement.setDouble(1, amount);
                        debitStatement.setLong(2, accountNumber);
                        int rows = debitStatement.executeUpdate();
                        if (rows > 0){
                            System.out.println("РУБЛИ: " + amount + " списано успешно\n");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        } else {
                            System.out.println("Транзакция не удалась");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    } else {
                        System.out.println("Недостаточный баланс");
                    }
                } else {
                    System.out.println("Неверный PIN-код!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection.setAutoCommit(true);
        }
    }

    public void creditMoney(long accountNumber) throws SQLException {
        scanner.nextLine();
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите защитный PIN-код: ");
        String securityPin = scanner.nextLine();

        try{
            connection.setAutoCommit(false);
            if (accountNumber != 0){
                PreparedStatement preparedStatement = connection.prepareStatement("select * from account where account_number = ? and security_pin = ?");
                preparedStatement.setLong(1, accountNumber);
                preparedStatement.setString(2, securityPin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    String creditQuery = "update account set balance = balance + ? where account_number = ?";
                    PreparedStatement creditStatement = connection.prepareStatement(creditQuery);
                    creditStatement.setDouble(1, amount);
                    creditStatement.setLong(2, accountNumber);
                    int rows = creditStatement.executeUpdate();
                    if (rows > 0){
                        System.out.println("РУБЛИ: " + amount + " зачислено успешно\n");
                        connection.commit();
                        connection.setAutoCommit(true);
                    } else {
                        System.out.println("Транзакция не удалась");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                }else {
                    System.out.println("Неверный PIN-код\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

    public void transferMoney(long senderAccountNumber) throws SQLException {
        scanner.nextLine();
        System.out.print("Введите номер счета получателя: ");
        long receiverAccountNumber = scanner.nextLong();
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите PIN-код: ");
        String securityPin = scanner.nextLine();

        try {
            connection.setAutoCommit(false);
            if (senderAccountNumber != 0 && receiverAccountNumber != 0){
                PreparedStatement preparedStatement = connection.prepareStatement("select * from account where account_number = ? and security_pin = ?");
                preparedStatement.setLong(1, senderAccountNumber);
                preparedStatement.setString(2, securityPin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    double currentBalance = resultSet.getDouble("balance");
                    if(amount <= currentBalance){
                        String debitQuery = "update account set balance = balance - ? where account_number = ?";
                        String creditQuery = "update account set balance = balance + ? where account_number = ?";
                        PreparedStatement debitStatement = connection.prepareStatement(debitQuery);
                        PreparedStatement creditStatement = connection.prepareStatement(creditQuery);
                        debitStatement.setDouble(1, amount);
                        debitStatement.setLong(2, senderAccountNumber);
                        creditStatement.setDouble(1, amount);
                        creditStatement.setLong(2, receiverAccountNumber);
                        int rows1 = debitStatement.executeUpdate();
                        int rows2 = creditStatement.executeUpdate();
                        if (rows1 > 0 && rows2 > 0){
                            System.out.println("Транзакция прошла успешно!\n");
                            System.out.println("РУБЛИ: " + amount + " переведено успешно\n");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        } else {
                            System.out.println("Транзакция не удалась");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    } else {
                        System.out.println("Недостаточный баланс\n");
                    }
                } else {
                    System.out.println("Неверный PIN-код\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

    public void getBalance(long accountNumber) {
        scanner.nextLine();
        System.out.print("Введите PIN-код: ");
        String securityPin = scanner.nextLine();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select balance from account where account_number = ? and security_pin = ?");
            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, securityPin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                double balance = resultSet.getDouble("balance");
                System.out.println("Баланс: " + balance);
            } else {
                System.out.println("Неверный PIN-код");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
