<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
    <form action="${pageContext.request.contextPath}/form-data" method="post">
        <label>
            Введите поисковый запрос
            <input type="text" name="query"/>
        </label>
        <input type="submit" value="Search!">
    </form>
</body>
</html>
