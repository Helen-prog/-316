package org.ee.jakarta.hospital_system.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ee.jakarta.hospital_system.dao.AppointmentDao;
import org.ee.jakarta.hospital_system.db.DBConnect;
import org.ee.jakarta.hospital_system.entity.Appointment;

import java.io.IOException;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("uderid"));
        String fullName = req.getParameter("fullname");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String appointDate = req.getParameter("appoint_date");
        String email = req.getParameter("email");
        String number = req.getParameter("number");
        String diseases = req.getParameter("diseases");
        int doctorId = Integer.parseInt(req.getParameter("doct"));
        String address = req.getParameter("address");

        Appointment ap = new Appointment(userId, fullName, gender, age, appointDate, email, number, diseases, doctorId, address, "В ожидании");

        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if(dao.addAppointment(ap)){
            session.setAttribute("succMsg", "Назначение создано успешно");
            resp.sendRedirect("user_appointment.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("user_appointment.jsp");
        }
    }
}
