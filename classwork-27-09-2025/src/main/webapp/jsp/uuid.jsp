<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

    <h1>Your generated UUID v4:</h1>
    <hr>
    <h2>
        <%= request.getAttribute("uuid") %>
    </h2>

</body>
</html>
