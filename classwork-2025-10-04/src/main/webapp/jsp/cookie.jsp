<%--
  Created by IntelliJ IDEA.
  User: Fedor
  Date: 04.10.2025
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: <%= request.getAttribute("color")%>">

    <h1>Hello world from java</h1>

    <form action="/cookie" method="post">
        <input type="text" name="color"/>
        <input type="submit" value="Save">
    </form>

</body>
</html>
