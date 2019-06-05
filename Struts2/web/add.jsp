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
    <s:head></s:head>
    <s:debug></s:debug>
    <s:actionerror/>
</head>
<body>
Struts的form标签<br>
    <s:form action="/stu/add.action">
        <s:textfield name="username" label="用户名"/>
        <s:textfield name="age" label="年龄"/>
        <s:textfield name="email" label="邮箱"/>
        <s:password name="password" label="密码"/>
        <s:password name="repassword" label="确认密码"/>
        <s:textfield name="score" label="分数"/>
        <s:textfield name="url" label="个人主页"/>
        <s:radio list="{'男','女'}" name="gender" label="性别"/>
        <s:submit value="提交"/>
    </s:form>
</body>
</html>
