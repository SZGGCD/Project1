<%--
  Created by IntelliJ IDEA.
  User: 好少年
  Date: 2019/11/1
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>***************************************这是第一个SSM框架Test</h1>

    <a href="accountController/findAll">测试SpringMVC</a>

    <h3>测试包</h3>

    <form action="accountController/save" method="post">
        姓名:<input type="text" name="name"/><br/>
        金额:<input type="text" name="money"/><br/>
             <input type="submit" value="保存"/><br/>
    </form>

    <h1>***************************************这是第一个SSM框架Test</h1>


    <h1>-----------------------------------------------------------------------------------</h1>


    <h1>***************************************这是第二个SSM框架案例</h1>

    <%--<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有的产品信息</a>--%>

    <jsp:forward page="/pages/main.jsp"></jsp:forward>




    <h1>***************************************这是第二个SSM框架案例</h1>

</body>
</html>
