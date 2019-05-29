<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/16
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>用户列表</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>性别</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${userList}" var="users">
                <tr>
                    <td>${users.username}</td>
                    <td>${users.password}</td>
                    <td>${users.gender}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit.do?id=${users.id}">修改</a>
                    </td>
                    <td>
                        <%--URL模板映射--%>
                        <a href="${pageContext.request.contextPath}/edit1/${users.id}.do">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
