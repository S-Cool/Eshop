<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page errorPage="Error.jsp" %>


<html>
<head>
    <title>Hello</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>Authorization:</h1>
<a href="myServlet">Link servlet!</a>
<form action="page.jsp" method="get">
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="submit" name="enter" value="Log in">
    <input type="submit" name="register" value="Registration">
</form>
<%@include file="footer.jsp" %>
</body>
</html>
