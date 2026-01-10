package org.ee.jakarta.hospital_system.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.UserDao;
import org.ee.jakarta.hospital_system.db.DBConnect;

import java.io.IOException;

@WebServlet("/userChangePassword")
public class ChangePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        UserDao userDao = new UserDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if(userDao.checkOldPassword(uid, oldPassword)) {
            if(userDao.changePassword(uid, newPassword)) {
                session.setAttribute("sucMsg", "Пароль изменен успешно");
                resp.sendRedirect("change_password.jsp");
            } else {
                session.setAttribute("errorMsg", "Ошибка сервера");
                resp.sendRedirect("change_password.jsp");
            }
        } else {
            session.setAttribute("errorMsg", "Пароль неверный");
            resp.sendRedirect("change_password.jsp");
        }
    }
}
