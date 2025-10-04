<%@ page import="ru.itis.dto.FieldErrorDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Fedor
  Date: 04.10.2025
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Sign Up page</h1>

    <form action="/sign-up" method="post">
        Email: <input type="text" name="email"/><br>
        Password: <input type="text" name="password"/><br>
        Nickname: <input type="text" name="nickname"/><br>
        <input type="submit" value="Sign up!"/>
    </form>

    <% if(request.getAttribute("errors") != null) {
        for(FieldErrorDto errorDto : (List<FieldErrorDto>) request.getAttribute("errors")) { %>
    <span style="color: red;">Field <%=errorDto.getField()%>, error <%=errorDto.getMessage()%> <br></span>
            <% }
    } %>

</body>
</html>
