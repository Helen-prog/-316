package org.ee.jakarta.hospital_system.doctor.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.DoctorDao;
import org.ee.jakarta.hospital_system.db.DBConnect;
import org.ee.jakarta.hospital_system.entity.Doctor;

import java.io.IOException;

@WebServlet("/docLogin")
public class DoctorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        DoctorDao userDao = new DoctorDao(DBConnect.getConn());
        Doctor doctor = userDao.login(email, password);

        if (doctor != null) {
            session.setAttribute("doctorObj", doctor);
            resp.sendRedirect("doctor/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Некорректный email или пароль");
            resp.sendRedirect("doctor_login.jsp");
        }
    }
}
