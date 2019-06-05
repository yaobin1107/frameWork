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
</head>
<body>
Struts的form标签<br>
<%--Struts表单特点：
    1.action不需要写项目名，会自动加
    2.会把表单里面的内容放在table中，并设置样式
    3.struts表单项必须有name属性--%>
    <s:form action="register.action">
        <%--相当于type=text--%>
        <%--
            requiredLabel="true"代表必填
            requiredPosition="left"必填“*”的位置
            showPassword="true"回显时，密码数据还在
        --%>
        <s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="left"></s:textfield>
        <%--相当于type=password--%>
        <s:password name="password" label="密码" requiredLabel="true" showPassword="true"></s:password>
        <s:textfield name="birthday" label="生日"></s:textfield>
        <s:checkboxlist list="#{'写代码':'写代码','学习':'学习','体育':'体育'}" label="爱好" name="hobby"></s:checkboxlist>
        <s:radio list="#{'true':'已婚','false':'未婚'}" label="是否已婚" name="married"></s:radio>
        <s:submit value="注册"></s:submit>
    </s:form>
<%--<hr>
HTML原始form标签<br>
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
    </form>--%>
</body>
</html>
