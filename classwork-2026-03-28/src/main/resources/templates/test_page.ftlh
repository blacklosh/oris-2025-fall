<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <title>Test page</title>
</head>
<body>

    <h1>
        <@spring.message "WELCOME_MESSAGE"/>
    </h1>

    <h2>
        <@spring.message "SUBWELCOME_MESSAGE"/>
    </h2>

    <a href="?lang=ru">RU</a><br/>
    <a href="?lang=en">EN</a><br/>

</body>
</html>