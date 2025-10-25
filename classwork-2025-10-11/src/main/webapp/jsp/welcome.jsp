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

    <h1>Welcome! Project AuthApplication</h1>

    <a href="/sign-in">SIGN IN</a><br>
    <a href="/sign-up">SIGN UP</a><br>
    <a href="/profile">PROFILE</a><br>

</body>
</html>
