<%--
  Created by IntelliJ IDEA.
  User: Fedor
  Date: 04.10.2025
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: <%= request.getAttribute("color")%>">

    <h1>Profile page</h1>
    <h2>Your account is <%=request.getAttribute("email")%></h2>

    <a href="/">MAIN</a><br>
    <a href="/logout">LOGOUT</a><br>

</body>
</html>
