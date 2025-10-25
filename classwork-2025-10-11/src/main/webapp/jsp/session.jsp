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
<body>

    <h1><span style="color: <%= request.getAttribute("color")%>">Session example</span></h1>

    <form action="/session" method="post">
        <input type="text" name="color"/>
        <input type="submit" value="Save">
    </form>

</body>
</html>
