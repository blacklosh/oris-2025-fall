<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        for(int i = 0 ; i < 5 ; i++) {
    %>

    <%= "Ahaha<br>" %>

    <% } %>

    <hr>

    <%
        if ( 3 > 2) {
    %>
    Good
    <% } else { %>
    Bad
    <% } %>

</body>
</html>
