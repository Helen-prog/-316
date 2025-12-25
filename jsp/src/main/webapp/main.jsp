<%--
  Created by IntelliJ IDEA.
  User: Helen
  Date: 2025-12-23
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="container">
        <jsp:include page="header.jsp" />

        <section>
            <form action="user.jsp" method="post">
                <p>Имя: <input type="text" name="username"></p>
                <p>Пол: <br>
                    <label for="female">
                        <input type="radio" name="gender" value="Женский" id="female"> Ж
                    </label> <br>
                    <label for="male">
                        <input type="radio" name="gender" value="Мужской" id="male"> М
                    </label>
                </p>
                <p>
                    Страна:
                    <select name="country">
                        <option>Россия</option>
                        <option>Беларусь</option>
                        <option>Турция</option>
                    </select>
                </p>
                <p>
                    Курс обучения: <br>
                    <label for="java">
                        <input type="checkbox" name="courses" value="Java" id="java"> Java
                    </label> <br>
                    <label for="html">
                        <input type="checkbox" name="courses" value="HTML" id="html"> HTML
                    </label> <br>
                    <label for="js">
                        <input type="checkbox" name="courses" value="JavaScript" id="js"> JS
                    </label>
                </p>
                <p><input type="submit" value="Подтвердить"></p>
            </form>
        </section>

        <jsp:include page="footer.jsp" />

    </div>
</body>
</html>
