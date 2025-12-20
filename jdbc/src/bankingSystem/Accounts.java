package bankingSystem;

import java.sql.*;
import java.util.Scanner;

public class Accounts {
    private Connection connection;
    private Scanner scanner;

    public Accounts(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public boolean accountExists(String email) {
        String sql = "SELECT account_number FROM account WHERE email = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public long openAccount(String email) {
        if(!accountExists(email)) {
            String openAccountQuery = "INSERT INTO account VALUES (?, ?, ?, ?, ?)";
            scanner.nextLine();
            System.out.print("Введите имя: ");
            String fullName = scanner.nextLine();
            System.out.print("Введите начальную сумму: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Введите защитный PIN-код: ");
            String securityPin = scanner.nextLine();
            try{
                long accountNumber = generateAccountNumber();
                PreparedStatement preparedStatement = connection.prepareStatement(openAccountQuery);
                preparedStatement.setLong(1, accountNumber);
                preparedStatement.setString(2, fullName);
                preparedStatement.setString(3, email);
                preparedStatement.setDouble(4, balance);
                preparedStatement.setString(5, securityPin);
                int rows = preparedStatement.executeUpdate();
                if(rows > 0) {
                    return accountNumber;
                } else {
                    throw new RuntimeException("Создание учетной записи не удалось");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Аккаунт уже существует");
    }

    private long generateAccountNumber() {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT account_number FROM account ORDER BY account_number DESC LIMIT 1");
            if(resultSet.next()) {
                long lastAccountNumber = resultSet.getLong("account_number");
                return lastAccountNumber + 1;
            } else {
                return 10000100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 10000100;
        }
    }

    public long getAccountNumber(String email) {
        String sql = "SELECT account_number FROM account WHERE email = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getLong("account_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Номер счета не существует");
    }
}
