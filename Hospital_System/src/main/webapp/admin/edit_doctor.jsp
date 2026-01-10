<%@ page import="org.ee.jakarta.hospital_system.dao.SpecialistDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Specialist" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ee.jakarta.hospital_system.dao.DoctorDao" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Title</title>
  <jsp:include page="../component/allcss.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<section class="doctor">
  <div class="wrap">

     <div class="offcanvas offcanvas-start show" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop" aria-labelledby="staticBackdropLabel">
      <div class="offcanvas-header">
        <h3 class="offcanvas-title" id="staticBackdropLabel">Редактировать врача</h3>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <div>
          <c:if test="${not empty succMsg}">
            <p class="center text-success fs-3">${succMsg}</p>
            <c:remove var="succMsg" scope="session"/>
          </c:if>
          <c:if test="${not empty errorMsg}">
            <p class="center text-danger fs-3">${errorMsg}</p>
            <c:remove var="errorMsg" scope="session"/>
          </c:if>

          <%
            int id = Integer.parseInt(request.getParameter("id"));
            DoctorDao daoEdit = new DoctorDao(DBConnect.getConn());
            Doctor doc = daoEdit.getDoctorById(id);
          %>

          <form action="../updateDoctor" method="post">
            <div class="mb-3">
              <label for="full" class="form-label">Полное имя</label>
              <input type="text" required name="fullName" class="form-control" id="full" value="<%= doc.getFullName() %>">
            </div>

            <div class="mb-3">
              <label for="dob" class="form-label">Дата рождения</label>
              <input type="date" required name="dob" class="form-control" id="dob" value="<%= doc.getDob() %>">
            </div>

            <div class="mb-3">
              <label for="qualit" class="form-label">Квалификация</label>
              <input type="text" required name="qualification" class="form-control" id="qualit" value="<%= doc.getQualification() %>">
            </div>

            <div class="mb-3">
              <label for="special" class="form-label">Специалист</label>
              <select name="spec" required class="form-control" id="special">
                <option value=""><%= doc.getSpeciality() %></option>
                <%
                  SpecialistDao dao = new SpecialistDao(DBConnect.getConn());
                  List<Specialist> list = dao.getAllSpecialist();
                  for (Specialist s : list) {
                %>
                <option><%= s.getSpecialistName() %></option>
                <%
                  }
                %>
              </select>
            </div>

            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" required name="email" class="form-control" id="email" value="<%= doc.getEmail() %>">
            </div>

            <div class="mb-3">
              <label for="tel" class="form-label">Телефон</label>
              <input type="text" required name="mobno" class="form-control" id="tel" value="<%= doc.getMobNo() %>">
            </div>

            <div class="mb-3">
              <label for="psw" class="form-label">Пароль</label>
              <input type="password" required name="password" class="form-control" id="psw" value="<%= doc.getPassword() %>">
            </div>

            <input type="hidden" name="id" value="<%= doc.getId() %>">

            <button class="btn btn-primary">Обновить</button>
          </form>
        </div>
      </div>
    </div>
    <br>
    <table class="table">
      <tr>
        <th scope="col">Имя</th>
        <th scope="col">Дата рождения</th>
        <th scope="col">Квалификация</th>
        <th scope="col">Специализация</th>
        <th scope="col">Email</th>
        <th scope="col">Телефон</th>
        <th scope="col">Действие</th>
      </tr>
      <%
        DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
        List<Doctor> list2 = dao2.getAllDoctors();
        for (Doctor s : list2) {
      %>
      <tr>
        <td><%= s.getFullName() %></td>
        <td><%= s.getDob() %></td>
        <td><%= s.getQualification() %></td>
        <td><%= s.getSpeciality() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getMobNo() %></td>
        <td>
          <a href="edit_doctor.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-info">Изменить</a>
          <a href="../deleteDoctor?id=<%=s.getId()%>" class="btn bun-small btn-danger">Удалить</a>
        </td>
      </tr>
      <% } %>
    </table>
  </div>
</section>
</body>
</html>
