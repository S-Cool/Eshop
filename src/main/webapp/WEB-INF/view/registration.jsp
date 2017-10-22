<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<section class="container">
    <div class="registration">
        <h1>Registration</h1>

        <form action="http://localhost:8080/user/signUp" method="POST">

            <p><input name = "id" type="text" value="" placeholder="view"></p>
            <p><input name = "firstName" type="text" value="" placeholder="view"></p>
            <p><input name = "lastName" type="text" value="" placeholder="view"></p>
            <p><input name = "age" type="text" value="" placeholder="view"></p>
            <p><input name = "phone" type="text" value="" placeholder="view"></p>
            <p><input name = "email" type="text" value="" placeholder="view"></p>
            <p><input name = "city" type="text" value="" placeholder="view"></p>
            <p><input name = "address" type="text" value="" placeholder="view"></p>
            <p><input name = "password" type="text" value="" placeholder="view"></p>
            <p><input name = "password" type="text" value="" placeholder="view"></p>
            <p class="submit"><input type="submit"></p>
        </form>
    </div>
</section>
</body>
</html>
