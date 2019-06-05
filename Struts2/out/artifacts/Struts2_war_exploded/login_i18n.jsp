<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/25
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //获取到默认国家语言
        /*Locale locale = Locale.getDefault();*/
        ResourceBundle rb = ResourceBundle.getBundle("resources.message", Locale.US);
    %>
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        <%=rb.getString("login.username")%>：<input type="text" name="username"><br>
        <%=rb.getString("login.password")%>：<input type="text" name="password"><br>
        <input type="submit" value="<%=rb.getString("login.submit")%>">
    </form>
</body>
</html>
