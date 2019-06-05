<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/25
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--theme="simple"：取消struts的样式--%>
<s:form>
    <s:textfield name="username" label="用户名"/>
    <s:password name="password" label="密码"/>
    <s:checkbox name="marry" label="已婚" value="true"/>
    <s:checkboxlist list="{'吃饭','睡觉','打豆豆'}" name="hobby" label="爱好"/>
    <s:select list="#{'xa':'西安','gz':'广州','sc':'四川'}" label="城市" name="city" headerKey="" headerValue="--请选择城市--"/>
    <s:radio list="{'男','女'}" label="性别" name="gender"/>
    <s:textarea label="备注" name="remark" rows="10" cols="50"/>
    <s:submit value="提交"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>
