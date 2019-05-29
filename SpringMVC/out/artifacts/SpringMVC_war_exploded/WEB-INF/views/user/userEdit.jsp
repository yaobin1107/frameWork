<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/16
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>userEdit</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/update.do?id=${user.id}" method="post">
            用户名：<input type="text" name="username" value="${user.username}"><br>
            密码：<input type="text" name="password" value="${user.password}"><br>
            性别：<input type="text" name="gender" value="${user.gender}"><br>
            <input type="submit" value="确定">
        </form>
    </body>
</html>
