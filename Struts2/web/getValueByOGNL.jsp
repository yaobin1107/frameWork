<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/28
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <%--取值
        <s:property value=""
        value写的时OGNL表达式
        如果取contextMap，写#+key名字
        如果去valueStack，直接写key名字
        --%>
    取valueStack的值：<s:property value="[0].username"/><br>
    取valueStack的值：<s:property value="[1].username"/><br>
    取contextMap的值：<s:property value="#contextMap"/><br>
    取contextMap的session的值：<s:property value="#session.contextMap_session"/><br>
    取contextMap的request的值：<s:property value="#request.contextMap_request"/><br>
    取contextMap的application的值：<s:property value="#application.contextMap_application"/><br>

    栈顶：<s:property/><br>

    获取栈顶Map中user的username的数据：
<%
    ValueStack valueStack = ActionContext.getContext().getValueStack();
    out.write((String) valueStack.findValue("user.username"));
%>


    <s:debug></s:debug>
</body>
</html>
