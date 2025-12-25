package org.ee.jakarta.hospital_system.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.UserDao;
import org.ee.jakarta.hospital_system.db.DBConnect;
import org.ee.jakarta.hospital_system.entity.User;

import java.io.IOException;

@WebServlet("/userRegister")
public class UserRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User(fullName, email, password);
            UserDao userDao = new UserDao(DBConnect.getConn());

            HttpSession session = req.getSession();
            boolean f = userDao.register(user);

            if(f){
                session.setAttribute("sucMsg", "Пользователь зарегистрирован успешно");
                resp.sendRedirect("signup.jsp");
            } else {
                session.setAttribute("errorMsg", "Ошибка регистрации");
                resp.sendRedirect("signup.jsp");
            }

    }
}
