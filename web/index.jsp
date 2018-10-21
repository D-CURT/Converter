<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 20.10.2018
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
      <form action="converter" name="form" method="post">
          <input type="submit" value="Show">
      </form>
      <input type="hidden" name="hid" value="">
      ${hid}
  </body>
</html>
