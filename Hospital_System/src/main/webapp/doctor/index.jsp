<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.DoctorDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %><%--
  Created by IntelliJ IDEA.
  User: Helen
  Date: 2025-12-27
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<section class="admin">
  <div class="wrap">
    <h2>Панель врача</h2>
      <%
          Doctor d = (Doctor) session.getAttribute("doctorObj");
          DoctorDao dao = new DoctorDao(DBConnect.getConn());
      %>
      <div class="doctor__block">
          <div class="doctor__element">
              <h3>Врач</h3>
              <h4><%= dao.countDoctor() %></h4>
          </div>
          <div class="doctor__element">
              <h3>Назначение</h3>
              <h4><%= dao.countAppointmentByDoctorId(d.getId()) %></h4>
          </div>
      </div>
  </div>
</section>
</body>
</html>
