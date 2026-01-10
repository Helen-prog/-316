<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.AppointmentDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Appointment" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp" />
</head>
<body>
<c:if test="${empty doctorObj}">
  <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>

<jsp:include page="navbar.jsp" />
<section class="doctor">
  <div class="wrap">
    <h2>Панель врача</h2>
    <c:if test="${not empty succMsg}">
      <p class="center text-success fs-3">${succMsg}</p>
      <c:remove var="succMsg" scope="session" />
    </c:if>
    <c:if test="${not empty errorMsg}">
      <p class="center text-danger fs-3">${errorMsg}</p>
      <c:remove var="errorMsg" scope="session" />
    </c:if>
    <table class="table">
      <tr>
        <th scope="col">ФИО</th>
        <th scope="col">Пол</th>
        <th scope="col">Возраст</th>
        <th scope="col">Дата назначения</th>
        <th scope="col">Email</th>
        <th scope="col">Телефон</th>
        <th scope="col">Диагноз</th>
        <th scope="col">Статус</th>
        <th scope="col">Действие</th>
      </tr>
      <%
        Doctor doc = (Doctor) session.getAttribute("doctorObj");
        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        List<Appointment> list = dao.getAllAppointmentByDoctorLogin(doc.getId());
        for (Appointment app : list) {
      %>
      <tr>
        <td><%= app.getFullName() %></td>
        <td><%= app.getGender() %></td>
        <td><%= app.getAge() %></td>
        <td><%= app.getAppointDate() %></td>
        <td><%= app.getEmail() %></td>
        <td><%= app.getPhoneNumber() %></td>
        <td><%= app.getDiseases() %></td>
        <td><%= app.getStatus() %></td>
        <td>
          <% if("В ожидании".equals(app.getStatus())){ %>
          <a href="comment.jsp?id=<%= app.getId() %>" class="btn btn-sm btn-info">Комментарий</a>
          <% } else { %>
          <a href="#" class="btn btn-info btn-sm disabled">Комментарий</a>
          <% } %>
        </td>
      </tr>
      <% } %>

    </table>
  </div>
</section>
</body>
</html>
