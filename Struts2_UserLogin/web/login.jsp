<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/27
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="登陆">
    </form>--%>

<%--防止表单重复提交--%>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <s:token/>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
