<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/25
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--默认读取全局国际化资源文件--%>
    <%--<form action="${pageContext.request.contextPath}/login.action" method="post">
        <s:text name="login.username"/><input type="text" name="username"><br>
        <s:text name="login.password"/><input type="text" name="password"><br>
        <input type="submit" value="<s:text name="login.submit"/>">
    </form>--%>

<%--配置读取指定包下面的资源文件--%>
    <s:i18n name="cn.yb.struts.web.action.package">
        <form action="${pageContext.request.contextPath}/login.action" method="post">
            <s:text name="login.username"/><input type="text" name="username"><br>
            <s:text name="login.password"/><input type="text" name="password"><br>
            <input type="submit" value="<s:text name="login.submit"/>">
        </form>
    </s:i18n>
</body>
</html>
