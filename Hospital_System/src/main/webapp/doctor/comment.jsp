<%@ page import="org.ee.jakarta.hospital_system.dao.AppointmentDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Appointment" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp"/>
</head>
<body>
<c:if test="${empty doctorObj}">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>

<jsp:include page="navbar.jsp" />

<div class="comment">
    <div class="wrap">
        <h2>Комментарий пациенту</h2>

        <%
            int id = Integer.parseInt(request.getParameter("id"));
            AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
            Appointment ap = dao.getAppointmentById(id);
        %>

        <form action="../updateStatus" method="post" class="row">
            <div class="col-md-6">
                <label for="name">Имя пациента</label>
                <input type="text" class="form-control" readonly id="name" value="<%= ap.getFullName() %>">
            </div>
            <div class="col-md-6">
                <label for="age">Возраст</label>
                <input type="text" class="form-control" readonly id="age" value="<%= ap.getAge() %>">
            </div>
            <div class="col-md-6">
                <label for="phone">Телефон</label>
                <input type="text" class="form-control" readonly id="phone" value="<%= ap.getPhoneNumber() %>">
            </div>
            <div class="col-md-6">
                <label for="diseases">Назначение</label>
                <input type="text" class="form-control" readonly id="diseases" value="<%= ap.getDiseases() %>">
            </div>
            <div class="col-md-12">
                <label for="comment">Комментарий</label>
                <textarea name="comm" class="form-control" required id="comment"></textarea>
            </div>
            <input type="hidden" name="id" value="<%= ap.getId() %>">
            <input type="hidden" name="did" value="<%= ap.getDoctorId() %>">
            <div>
                <button class="btn but">Отправить</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
