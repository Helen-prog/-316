package org.ee.jakarta.hospital_system.doctor.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.AppointmentDao;
import org.ee.jakarta.hospital_system.db.DBConnect;

import java.io.IOException;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int did = Integer.parseInt(req.getParameter("did"));

        String comm = req.getParameter("comm");

        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if(dao.updateCommentStatus(id, did, comm)) {
            session.setAttribute("succMsg", "Комментарий обновлен");
            resp.sendRedirect("doctor/patient.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("doctor/patient.jsp");
        }
    }
}
