<%@ page import="org.ee.jakarta.hospital_system.dao.AppointmentDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.DoctorDao" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Appointment" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %><%--
  Created by IntelliJ IDEA.
  User: Helen
  Date: 2025-12-30
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<jsp:include page="navbar.jsp" />
<section class="patient">
  <div class="wrap">
    <h2>Панель пациента</h2>
  
    <table class="table">
      <tr>
        <th scope="col">ФИО</th>
        <th scope="col">Пол</th>
        <th scope="col">Возраст</th>
        <th scope="col">Дата назначения</th>
        <th scope="col">Email</th>
        <th scope="col">Телефон</th>
        <th scope="col">Диагноз</th>
        <th scope="col">Имя врача</th>
        <th scope="col">Адрес</th>
        <th scope="col">Статус</th>
      </tr>
      <%
        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
        List<Appointment> list = dao.getAllAppointment();
        for (Appointment appointment : list) {
          Doctor d = dao2.getDoctorById(appointment.getDoctorId());
      %>
      <tr>
        <td><%= appointment.getFullName() %></td>
        <td><%= appointment.getGender() %></td>
        <td><%= appointment.getAge() %></td>
        <td><%= appointment.getAppointDate() %></td>
        <td><%= appointment.getEmail() %></td>
        <td><%= appointment.getPhoneNumber() %></td>
        <td><%= appointment.getDiseases() %></td>
        <td><%= d.getFullName() %></td>
        <td><%= appointment.getAddress() %></td>
        <td><%= appointment.getStatus() %></td>
      </tr>
      <% } %>
    </table>
  </div>
</section>
</body>
</html>
