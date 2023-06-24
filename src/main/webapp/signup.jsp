<%--
  Created by IntelliJ IDEA.
  User: m_hadian
  Date: 6/24/2023
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
<form action="/signup.do">
  <input type="text" name="username"/>
  <input type="text" name="password"/>
  <input type="submit"/>
</form>
<form action="/signup.do" method="post">
  <input type="text" name="name"/>
  <input type="text" name="family"/>
  <input type="submit"/>
</form>
</body>
</html>
