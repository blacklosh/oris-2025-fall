<!DOCTYPE html>
<html>
<head>
    <title>Users page</title>
</head>
<body>

    <h1>
        Registered users:
    </h1>

    <#list users as user>
        ${user.username} : ${user.email} <br/>
    </#list>

</body>
</html>