<%@ page import="org.ee.jakarta.hospital_system.entity.User" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.AppointmentDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.DoctorDao" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Appointment" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="component/allcss.jsp"/>
</head>
<body>
<jsp:include page="component/navbar.jsp"/>

<c:if test="${empty userObj}">
    <c:redirect url="user_login.jsp"></c:redirect>
</c:if>

<div class="appointment">
    <div class="wrap">
        <h2>Просмотр назначения</h2>

        <table class="table">
            <tr>
                <th scope="col">ФИО</th>
                <th scope="col">Пол</th>
                <th scope="col">Возраст</th>
                <th scope="col">Дата назначения</th>
                <th scope="col">Диагноз</th>
                <th scope="col">Имя врача</th>
                <th scope="col">Статус</th>
            </tr>
            <%
                User user = (User) session.getAttribute("userObj");
                AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
                DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
                List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
                for (Appointment appointment : list) {
                    Doctor d = dao2.getDoctorById(appointment.getDoctorId());
            %>
            <tr>
                <td><%= appointment.getFullName() %>
                </td>
                <td><%= appointment.getGender() %>
                </td>
                <td><%= appointment.getAge() %>
                </td>
                <td><%= appointment.getAppointDate() %>
                </td>
                <td><%= appointment.getDiseases() %>
                </td>
                <td><%= d.getFullName() %>
                </td>
                <td>
                    <% if ("В ожидании".equals(appointment.getStatus())) { %>
                    <a href="#" class="btn btn-info">В ожидании</a>
                    <% } else { %>
                    <%= appointment.getStatus() %>
                    <% } %>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
