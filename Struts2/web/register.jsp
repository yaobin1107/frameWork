<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/25
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:fielderror></s:fielderror>
    <form action="${pageContext.request.contextPath}register.action" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        生日：<input type="text" name="birthday"><br>
        爱好：<input type="checkbox" name="hobby" value="学习">学习
              <input type="checkbox" name="hobby" value="游戏">游戏
              <input type="checkbox" name="hobby" value="体育">体育<br>
        是否已婚:<input type="radio" name="married" value="true">已婚
                 <input type="radio" name="married" value="false">未婚<br>
        <input type="submit" value="注册">
    </form>

    <%--第三种方式--%>
    <%--<form action="${pageContext.request.contextPath}/login.action" method="post">
        用户名：<input type="text" name="user.username"><br>
        密码：<input type="text" name="user.password"><br>
        <input type="submit" value="登陆">
    </form>--%>
</body>
</html>
