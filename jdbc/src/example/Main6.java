package example;

import java.sql.*;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            String sql = "insert into employees(name, job, salary) values(?, ?, ?)";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                Scanner scanner = new Scanner(System.in);
                while(true){
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Job: ");
                    String job = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, job);
                    preparedStatement.setDouble(3, salary);
                    preparedStatement.addBatch();
                    System.out.println("Добавить следующее значение: Y / N");
                    String res = scanner.nextLine();
                    if (res.toUpperCase().equals("N")) {
                        break;
                    }
                }
                preparedStatement.executeBatch();
                connection.commit();
                System.out.println("Пакетная обработка прошла успешно!");
                connection.close();
            } catch (BatchUpdateException ex){
                connection.rollback();
                System.out.println("Ошибка пакетной обработки");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
