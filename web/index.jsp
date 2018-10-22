<%@ page import="utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
      <form action="converter" name="form" method="post">
          <input type="text" name="inputValue" value="${inputValue}">
          <select name="from">
              <option value="<%=Constants.KMH%>"><%=Constants.KMH%></option>
              <option value="<%=Constants.MPH%>"><%=Constants.MPH%></option>
              <option value="<%=Constants.KN%>"><%=Constants.KN%></option>
              <option value="<%=Constants.MS%>"><%=Constants.MS%></option>
          </select>
          to
          <select name="to">
              <option value="<%=Constants.KMH%>"><%=Constants.KMH%></option>
              <option value="<%=Constants.MPH%>"><%=Constants.MPH%></option>
              <option value="<%=Constants.KN%>"><%=Constants.KN%></option>
              <option value="<%=Constants.MS%>"><%=Constants.MS%></option>
          </select>
          <input type="submit" value="Convert">
          <br>
          <c:forEach var="result" items="${results}">
              <c:out value="${result}"/>
          </c:forEach>
         <%-- <input type="text" name="outputValue" value="${results}">--%>
      </form>
      <input type="hidden" name="results" value="">
  </body>
</html>
