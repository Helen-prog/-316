import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";
//        String query = "select * from employees where name = ?";
        String query = "insert into employees values(?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "Sergey");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String job = resultSet.getString("job");
//                double salary = resultSet.getDouble("salary");
//                System.out.println(id + " " + name + " " + job + " " + salary);
//            }
//            resultSet.close();
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Viktor");
            preparedStatement.setString(3, "SEO");
            preparedStatement.setDouble(4, 85000.0);

            int row = preparedStatement.executeUpdate();
            if(row > 0) {
                System.out.println("Данные записаны успешно");
            } else{
                System.out.println("Ошибка сохранения данных");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
