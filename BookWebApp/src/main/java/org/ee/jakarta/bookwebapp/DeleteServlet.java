package org.ee.jakarta.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/deleteUrl")
public class DeleteServlet extends HttpServlet {
    public static final String query = "delete from book_data where id=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:mysql:///book", "root", "123456");
            PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='list'>");
            if(row == 1) {
                out.println("<h2>Удаление прошло успешно!</h2>");
            } else {
                out.println("<h2>Удаление не удалось</h2>");
            }
        } catch (SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='home.html'>Главая</a>");
        out.println("<br><a href='bookList'>Список книг</a>");
        out.println("</div></body></html>");
    }
}
