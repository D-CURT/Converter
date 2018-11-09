<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Page</title>
</head>
<body>
view
${results}
<c:forEach var="result" items="${results}">
    <c:out value="${result}"/>
</c:forEach>
</body>
</html>
