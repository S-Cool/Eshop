<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    String sub = request.getParameter("enter");
    String reg = request.getParameter("register");
%>
<p><font color="#a52a2a">Login: <%= login%></font></p>

<p><font color="#5f9ea0">Password: <%= password%></font></p>

<p><font color="black">Button Log In: <%= sub%></font></p>

<p><font color="black">Button Registration: <%= reg%></font></p>
</body>
</html>
