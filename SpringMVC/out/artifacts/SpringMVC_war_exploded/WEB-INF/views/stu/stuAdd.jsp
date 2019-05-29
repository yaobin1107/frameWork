<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>stuAdd</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/stu/save.do" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
