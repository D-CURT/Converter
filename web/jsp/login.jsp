<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript" src="/content/JS/Scripts.js"></script>
</head>
<body>
<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>
<form action="login" name="loginForm" method="get">
    <input type="text" name="login" value="" placeholder="login">
    <input type="password" name="password" value="" placeholder="password">
    <input type="button" value="log in" onclick="submit()">
</form>
</body>
</html>
