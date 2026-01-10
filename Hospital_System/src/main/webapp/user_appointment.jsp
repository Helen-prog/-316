<%@ page import="org.ee.jakarta.hospital_system.dao.DoctorDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Doctor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <title>Title</title>
    <jsp:include page="component/allcss.jsp" />
  </head>
  <body>
  <jsp:include page="component/navbar.jsp" />

  <div class="appointment">
    <div class="wrap">
      <h2>Панель назначения</h2>
      <c:if test="${not empty succMsg}">
        <p class="center text-success fs-3">${succMsg}</p>
        <c:remove var="succMsg" scope="session" />
      </c:if>
      <c:if test="${not empty errorMsg}">
        <p class="center text-danger fs-3">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session" />
      </c:if>
      <form action="addAppointment" method="post" class="row g-3">
        <input type="hidden" name="uderid" value="${userObj.id}">

        <div class="col-md-6">
          <label for="fio" class="form-label">ФИО</label>
          <input type="text" class="form-control" name="fullname" required id="fio">
        </div>
        <div class="col-md-6">
          <label for="gender" class="form-label">Пол</label>
          <select name="gender" id="gender" class="form-control" required>
            <option value="male">Мужской</option>
            <option value="female">Женский</option>
          </select>
        </div>
        <div class="col-md-6">
          <label for="age" class="form-label">Возраст</label>
          <input type="number" class="form-control" name="age" required id="age">
        </div>
        <div class="col-md-6">
          <label for="date" class="form-label">Дата назначения</label>
          <input type="date" class="form-control" name="appoint_date" required id="date">
        </div>
        <div class="col-md-6">
          <label for="email" class="form-label">Email</label>
          <input type="email" class="form-control" name="email" required id="email">
        </div>
        <div class="col-md-6">
          <label for="tel" class="form-label">Телефон</label>
          <input type="text" class="form-control" name="number" required id="tel">
        </div>
        <div class="col-md-6">
          <label for="diseases" class="form-label">Диагноз</label>
          <input type="text" class="form-control" name="diseases" required id="diseases">
        </div>
        <div class="col-md-6">
          <label for="doctor" class="form-label">Врач</label>
          <select name="doct" id="doctor" class="form-control" required>
            <option value="">-- Выбор --</option>
            <%
              DoctorDao dao = new DoctorDao(DBConnect.getConn());
              List<Doctor> list = dao.getAllDoctors();
              for (Doctor doc : list) {
            %>
            <option value="<%= doc.getId() %>"><%= doc.getFullName() %> (<%= doc.getSpeciality() %>)</option>
            <% } %>
          </select>
        </div>
        <div class="col-md-12">
          <label for="address" class="form-label">Адрес</label>
          <textarea class="form-control" name="address" rows="3" required id="address"></textarea>
        </div>

        <c:if test="${empty userObj}">
          <a href="user_login.jsp" class="btn btn-info">Отправить</a>
        </c:if>
        <c:if test="${not empty userObj}">
          <button class="btn btn-info">Отправить</button>
        </c:if>
      </form>
      
    </div>
  </div>
  <jsp:include page="component/footer.jsp" />
  </body>
</html>
