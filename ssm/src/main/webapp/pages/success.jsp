<%--
  Created by IntelliJ IDEA.
  User: 好少年
  Date: 2019/11/1
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <h1>查询成功</h1>

    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>


</body>
</html>
