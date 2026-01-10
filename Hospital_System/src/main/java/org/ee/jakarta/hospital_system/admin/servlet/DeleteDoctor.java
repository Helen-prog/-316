package org.ee.jakarta.hospital_system.admin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.DoctorDao;
import org.ee.jakarta.hospital_system.db.DBConnect;

import java.io.IOException;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if(dao.deleteDoctor(id)) {
            session.setAttribute("succMsg", "Врач удален успешно");
            resp.sendRedirect("admin/doctor.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("admin/doctor.jsp");
        }
    }
}
