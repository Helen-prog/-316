package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";

        String withdrawQuery = "UPDATE accounts SET balance = balance - ? WHERE accounts_number = ?";
        String depositQuery = "UPDATE accounts SET balance = balance + ? WHERE accounts_number = ?";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
           // try {
                PreparedStatement withdrawStmt = connection.prepareStatement(withdrawQuery);
                PreparedStatement depositStmt = connection.prepareStatement(depositQuery);
                withdrawStmt.setDouble(1, 500.00);
                withdrawStmt.setString(2, "account3");
                depositStmt.setDouble(1, 500.00);
                depositStmt.setString(2, "account4");
                int rowsWithdraw = withdrawStmt.executeUpdate();
                int rowsDeposit = depositStmt.executeUpdate();
                if(rowsWithdraw > 0 && rowsDeposit > 0) {
                    connection.commit();
                    System.out.println("Транзакция успешна");
                } else {
                    connection.rollback();
                    System.out.println("Транзакция не удалась");
                }

//            } catch (SQLException e) {
//
//
//            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
