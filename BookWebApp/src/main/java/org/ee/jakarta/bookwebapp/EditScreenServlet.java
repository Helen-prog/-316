package org.ee.jakarta.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
    public static final String query = "select book_title, book_edition, book_price from book_data where id=?";

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
            ResultSet rs = ps.executeQuery();
            rs.next();
            out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='list'>");
            out.println("<form action='editUrl?id="+ id +"' method='post'>");
            out.println("<table>");

            out.println("<tr>");
            out.println("<td>Название книги</td>");
            out.println("<td><input type='text' name='bookTitle' value='"+ rs.getString(1) +"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Книжное издание</td>");
            out.println("<td><input type='text' name='bookEdition' value='"+ rs.getString(2) +"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Цена</td>");
            out.println("<td><input type='text' name='bookPrice' value='"+ rs.getString(3) +"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><input type='submit' value='Изменить' class='submit'></td>");
            out.println("<td><input type='reset' value='Отменить' class='reset'></td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("</form>");
        } catch (SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='home.html'>Главая</a>");
        out.println("</div></body></html>");
    }
}
