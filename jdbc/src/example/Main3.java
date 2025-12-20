package example;

import java.io.*;
import java.sql.*;

public class Main3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "123456";
//        String image_path = "E:\\PV316\\jdbc\\src\\example\\OIP.jpg";
//        String query = "INSERT INTO image_table(image_data) VALUES(?)";
        String folder_path = "E:\\PV316\\jdbc\\src\\example\\";
        String query = "SELECT image_data FROM image_table WHERE image_id = ?";

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                String image_path = folder_path + "extractedImage.jpg";
                OutputStream outputStream = new FileOutputStream(image_path);
                outputStream.write(image_data);
            } else {
                System.out.println("Изображение не найдено");
            }
            connection.close();
//            FileInputStream fileInputStream = new FileInputStream(image_path);
//            byte[] fileData = new byte[fileInputStream.available()];
//            fileInputStream.read(fileData);
//
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setBytes(1, fileData);
//            int row = preparedStatement.executeUpdate();
//            if(row > 0) {
//                System.out.println("Изображение добавлено успешно");
//            } else{
//                System.out.println("Изображение не добавлено");
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
