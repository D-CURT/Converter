<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <script type="text/javascript" src="content/JS/Scripts.js"></script>
</head>
<body>
<c:if test="${error != null}">
    <p style="color: red">${error}</p>
</c:if>
    <form action="registration" name="registrationForm" method="get">
        <input type="text" name="name" value="" placeholder="name">
        <input type="text" name="login" value="" placeholder="login">
        <input type="password" name="password" value="" placeholder="password">
        <input type="button" value="sign in" onclick="submit('registrationForm')">
    </form>
</body>
</html>
