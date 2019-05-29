<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/16
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>info</title>
    </head>
    <body>
        显示表单提交的数据：<br>
        <%--获取第1种方式的参数--%>
        用户名：${username}<br>
        <%--获取第2种方式的参数--%>
        <%--相当于getUser.getPassword--%>
        密码：${user.password}<br>
        <%--获取第四种方式的参数_List--%>
        密码List：${userExt.usersList[0].password}<br>
        <%--获取第3种方式的参数--%>
        <%--相当于getUserExt.getUser.getGender--%>
        性别：${userExt.user.gender}<br>
        <%--获取第5种方式的参数_Map--%>
        <%--相当于getUserExt.getUserMap().get("birthday")--%>
        生日Map： ${userExt.userMap.birthday}<br>
    </body>
</html>
