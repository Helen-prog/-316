<%--
  Created by IntelliJ IDEA.
  User: Helen
  Date: 2025-12-23
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String firstName = request.getParameter("name1");
        out.println(firstName);
    %>
<%
    String cname = (String) session.getAttribute("session_name");
    out.println(cname);
%>
</body>
</html>
