<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html>
<head>
    <title>Register page</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

    <h1>Register</h1>

    <form method="post" action="/users/register">
        <@spring.bind "accountRequest"/>
        <p class="error">${spring.status.errorMessage}</p>
        <@spring.formInput "accountRequest.email"/> <br/>
        <@spring.showErrors "<br/>" "error"/><br/>
        <@spring.formInput "accountRequest.username"/> <br/>
        <@spring.showErrors "<br/>" "error"/><br/>
        <@spring.formInput "accountRequest.password"/> <br/>
        <@spring.showErrors "<br/>" "error"/><br/>
        <input type="submit"/>
    </form>

</body>
</html>