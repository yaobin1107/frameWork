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
    <s:actionerror/>
</head>
<body>
<s:form action="/upload" enctype="multipart/form-data">
    <s:textfield label="用户名" name="username"/>
    <s:textfield label="密码" name="password"/>
    <s:file label="照片" name="photo"/>
    <s:submit value="上传"/>
</s:form>
</body>
</html>
