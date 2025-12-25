<%--
  Created by IntelliJ IDEA.
  User: Helen
  Date: 2025-12-23
  Time: 19:49
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

    <p><b>Имя: <%= request.getParameter("username") %></b></p>
    <p><b>Пол: <%= request.getParameter("gender") %></b></p>
    <p><b>Страна: <%= request.getParameter("country") %></b></p>
    <p><b>Курс обучения:</b></p>
      <ul>
          <%
            String[] courses = request.getParameterValues("courses");
            for (String course : courses){
                out.println("<li>" + course + "</li>");
            }
          %>
      </ul>

  </section>
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
