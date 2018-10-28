<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <table>
        <tr>
            <th>
                <c:choose>
                    <c:when test="${user.login == null}">
                        <c:out value="USER: guest"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="USER: ${user.login}"/>
                    </c:otherwise>
                </c:choose>
            </th>
            <td><a style="padding-left: 100px" href="<%=Constants.LOGIN_URL%>" <c:if test="${user.login != null}">hidden</c:if>>Login</a></td>
            <td><a href="<%=Constants.REGISTRATION_URL%>" <c:if test="${user.login != null}">hidden</c:if>>Registration</a></td>
            <td><a href="logout" <c:if test="${user.login == null}">hidden</c:if>>logout</a></td>
        </tr>
    </table>
</body>
</html>
