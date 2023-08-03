<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 03.08.2023
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Race start</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/race/run" method="post">
   Horses amount: <input type="number" name="horseAmount" />
    <br/>
   Your bet: <input type="number" name="bet" />
    <input type="submit" name="submit">
</form>
</body>
</html>
