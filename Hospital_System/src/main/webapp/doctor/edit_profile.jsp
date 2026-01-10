<%@ page import="org.ee.jakarta.hospital_system.dao.SpecialistDao" %>
<%@ page import="org.ee.jakarta.hospital_system.db.DBConnect" %>
<%@ page import="org.ee.jakarta.hospital_system.entity.Specialist" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../component/allcss.jsp"/>
</head>
<body>
<c:if test="${empty doctorObj}">
    <c:redirect url="../doctor_login.jsp"></c:redirect>
</c:if>

<jsp:include page="navbar.jsp"/>

<div class="wrap">
    <h2>Редактирование профиля</h2>
    <c:if test="${not empty succMsg}">
        <p class="center text-success fs-3">${succMsg}</p>
        <c:remove var="succMsg" scope="session"/>
    </c:if>
    <c:if test="${not empty errorMsg}">
        <p class="center text-danger fs-3">${errorMsg}</p>
        <c:remove var="errorMsg" scope="session"/>
    </c:if>

    <c:if test="${not empty succMsgd}">
        <p class="center text-success fs-3">${succMsgd}</p>
        <c:remove var="succMsgd" scope="session"/>
    </c:if>
    <c:if test="${not empty errorMsgd}">
        <p class="center text-danger fs-3">${errorMsgd}</p>
        <c:remove var="errorMsgd" scope="session"/>
    </c:if>

    <div class="row">
        <div class="col-md-4">
            <div class="card point-card">
                <div class="card-body">
                    <form action="../doctChangePassword" method="post">
                        <div>
                            <label for="old">Введите старый пароль:</label>
                            <input type="password" name="oldPassword" class="form-control" id="old" required>
                        </div>
                        <div>
                            <label for="new">Введите новый пароль:</label>
                            <input type="password" name="newPassword" class="form-control" id="new" required>
                        </div>
                        <input type="hidden" value="${doctorObj.id}" name="uid">
                        <button class="btn button">Изменить пароль</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="card point-card">
                <div class="card-body">
                    <form action="../doctorUpdateProfile" method="post">
                        <div class="mb-3">
                            <label for="full" class="form-label">Полное имя</label>
                            <input type="text" required name="fullName" class="form-control" id="full" value="${doctorObj.fullName}">
                        </div>

                        <div class="mb-3">
                            <label for="dob" class="form-label">Дата рождения</label>
                            <input type="date" required name="dob" class="form-control" id="dob" value="${doctorObj.dob}">
                        </div>

                        <div class="mb-3">
                            <label for="qualit" class="form-label">Квалификация</label>
                            <input type="text" required name="qualification" class="form-control" id="qualit" value="${doctorObj.qualification}">
                        </div>

                        <div class="mb-3">
                            <label for="special" class="form-label">Специалист</label>
                            <select name="spec" required class="form-control" id="special">
                                <option value="">${doctorObj.speciality}</option>
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
                            <input type="email" required name="email" class="form-control" id="email" readonly value="${doctorObj.email}">
                        </div>

                        <div class="mb-3">
                            <label for="tel" class="form-label">Телефон</label>
                            <input type="text" required name="mobno" class="form-control" id="tel" value="${doctorObj.mobNo}">
                        </div>

                        <input type="hidden" name="id" value="${doctorObj.id}">

                        <button class="btn btn-primary">Отправить</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
