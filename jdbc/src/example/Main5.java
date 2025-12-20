package example;

import java.sql.*;

public class Main5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            try{
                Statement statement = connection.createStatement();
                statement.addBatch("insert into employees(name, job, salary) values('Igor','HR Manager',65000.0)");
                statement.addBatch("insert into employees(name, job, salary) values('Oleg','C++ Developer',62000.0)");
                statement.addBatch("insert into employees(name, job, salary) values('Petr','JS Developer',67000.0)");
                statement.executeBatch();
                connection.commit();
                System.out.println("Пакетная обработка прошла успешно!");
            } catch (BatchUpdateException e) {
                connection.rollback();
                System.out.println("Ошибка пакетной обработки");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
