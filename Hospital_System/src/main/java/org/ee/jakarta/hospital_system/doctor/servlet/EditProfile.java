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

@WebServlet("/doctorUpdateProfile")
public class EditProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String dob = req.getParameter("dob");
        String qualification = req.getParameter("qualification");
        String spec = req.getParameter("spec");
        String email = req.getParameter("email");
        String phone = req.getParameter("mobno");

        int id = Integer.parseInt(req.getParameter("id"));

        Doctor doctor = new Doctor(id, fullName, dob, qualification, spec, email, phone, "");
        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if(dao.editDoctorProfile(doctor)){
            Doctor updateDoctor = dao.getDoctorById(id);
            session.setAttribute("succMsgd", "Врач обновлен успешно");
            session.setAttribute("doctorObj", updateDoctor);
            resp.sendRedirect("doctor/edit_profile.jsp");
        } else {
            session.setAttribute("errorMsgd", "Ошибка сервера");
            resp.sendRedirect("doctor/edit_profile.jsp");
        }
    }
}
