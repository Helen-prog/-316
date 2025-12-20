import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";
//        String query = "select * from employees";
//        String query = "INSERT INTO employees VALUES (4, 'Irina', 'Full Stack Developer', 47000.0)";
//        String query = "DELETE FROM employees WHERE id=4";
        String query = """
            UPDATE employees
            SET job = 'Full stack Developer', salary = 70000.0
            WHERE id = 2
        """;

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE employees (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), job VARCHAR(255), salary DOUBLE)");
//            stmt.executeUpdate("INSERT INTO employees VALUES (1, 'Roman', 'Java Developer', 75000.0)");
//            stmt.executeUpdate("INSERT INTO employees VALUES (2, 'Sergey', 'Devops Engineer', 65000.0)");

//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String job = rs.getString("job");
//                double salary = rs.getDouble("salary");
//                System.out.println(id + " " + name + " " + job + " " + salary);
//            }
            int row = stmt.executeUpdate(query);
            if(row > 0){
                System.out.println("Изменено строк: " + row);
            } else {
                System.out.println("Ошибка изменения строк");
            }

            stmt.close();
            conn.close();
//            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}