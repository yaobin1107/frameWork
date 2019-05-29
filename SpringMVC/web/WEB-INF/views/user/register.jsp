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
        <title>register</title>
    </head>
    <body>
    <%--=============================对应第一种获取参数的方式===============================--%>
        <%--<form action="${pageContext.request.contextPath}/register1.do" method="post">
            用户名1：<input type="text" name="username"><br>
            密码1：<input type="text" name="password"><br>
            性别1：<input type="text" name="gender"><br>
            生日1：<input type="text" name="birthday"><br>
            爱好1：<input type="checkbox" name="hobby" value="1">游戏
                <input type="checkbox" name="hobby" value="2">学习
                <input type="checkbox" name="hobby" value="3">敲代码<br>
            <input type="submit" value="提交">
        </form>
    <hr>--%>
    <%--=============================对应第二种获取参数的方式===============================--%>
        <%--<form action="${pageContext.request.contextPath}/register2.do" method="post">
            用户名2：<input type="text" name="username"><br>
            密码2：<input type="text" name="password"><br>
            性别2：<input type="text" name="gender"><br>
            生日2：<input type="text" name="birthday"><br>
            爱好2：<input type="checkbox" name="hobby" value="1">游戏
            <input type="checkbox" name="hobby" value="2">学习
            <input type="checkbox" name="hobby" value="3">敲代码<br>
            <input type="submit" value="提交">
        </form>
    <hr>--%>
    <%--=============================对应第三种获取参数的方式===============================--%>
        <%--<form action="${pageContext.request.contextPath}/register3.do" method="post">
            用户名3：<input type="text" name="user.username"><br>
            密码3：<input type="text" name="user.password"><br>
            性别3：<input type="text" name="user.gender"><br>
            生日3：<input type="text" name="user.birthday"><br>
            爱好3：<input type="checkbox" name="user.hobby" value="1">游戏
            <input type="checkbox" name="user.hobby" value="2">学习
            <input type="checkbox" name="user.hobby" value="3">敲代码<br>
            <input type="submit" value="提交">
        </form>
    <hr>--%>
    <%--=============================接收集合List类型参数===============================--%>
        <%--<form action="${pageContext.request.contextPath}/register4.do" method="post">
            &lt;%&ndash;相当于setUser[0].setUsername&ndash;%&gt;
            用户名1：<input type="text" name="usersList[0].username"><br>
            &lt;%&ndash;相当于setUser[0].setPassword&ndash;%&gt;
            密码1：<input type="text" name="usersList[0].password"><br>
            <hr>
            用户名2：<input type="text" name="usersList[1].username"><br>
            密码2：<input type="text" name="usersList[1].password"><br>
            <input type="submit" value="提交">
        </form>--%>
    <%--=============================接收集合Map类型参数===============================--%>
        <form action="${pageContext.request.contextPath}/register5.do" method="post">
            <%--相当于setUserMap.setKey("username")--%>
            用户名：<input type="text" name="userMap['username']"><br>
            密码：<input type="text" name="userMap['password']"><br>
            性别：<input type="text" name="userMap['gender']"><br>
            生日：<input type="text" name="userMap['birthday']"><br>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
