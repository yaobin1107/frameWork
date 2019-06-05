<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/24
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%--OGNL表达式
            1.导入标签库：<%@ taglib uri="/struts-tags" prefix="s" %>
            2.<s:property value="java-struts2"/>标签中写代码
        OGNL表达式的作用：
            1.取值，或者说输出数据到jsp页面
            2.调用方法
            3.访问静态属性/方法
                默认情况下，struts2把静态属性的访问内禁止了，需要打开
            4.封装list数据，数组   {'1','2','3'}
                <s:radio list="{'男','女'}" label="性别list" name="genderlist"/><br>
            5.封装map数据 #{'key1':'value1','key2':'value2'}}
                <s:radio list="#{'男':'male','女':'female'}" label="性别" name="gender"/>
    --%>
    <%--表示从作用域通过key取值--%>
    <%--作用域取值：<s:property value="java-struts2"/><br>
    &lt;%&ndash;表示字符串&ndash;%&gt;
    字符串：<s:property value="'java-struts2'"/><br>
    &lt;%&ndash;直接调用方法&ndash;%&gt;
    字符串长度：<s:property value="'java-struts2'.length()"/><br>
    &lt;%&ndash;访问静态属性&ndash;%&gt;
    int最大值：<s:property value="@java.lang.Integer@MAX_VALUE"/><br>
    &lt;%&ndash;访问静态方法&ndash;%&gt;
    随机数：<s:property value="@java.lang.Math@random()"/><br>

    <s:radio list="{'男','女'}" label="性别list" name="genderlist"/><br>

    <s:radio list="#{'男':'male','女':'female'}" label="性别map" name="gendermap"/>--%>

    <%--s:set标签；往作用域存数据
        value：值
        var：变量名
        scope：作用域，可写类型:application,session,request,page,action
            不写默认是action
    --%>
    <%--<s:set value="'yb_s:set1'" var="标签测试1" scope="application"></s:set>
    <s:set value="'yb_s:set2'" var="标签测试2" scope="session"></s:set>
    <s:set value="'yb_s:set3'" var="标签测试3" scope="request"></s:set>
    <s:set value="'yb_s:set4'" var="标签测试4" scope="action"></s:set>
    <s:property value="#application.标签测试1"/><br>
    <s:property value="#session.标签测试2"/><br>
    <s:property value="#request.标签测试3"/><br>
    <s:property value="#标签测试4"/><br>--%>

    <%--s:action标签：在jsp中访问一个action
        下面代码的意思：把stuOGNL.action的数据显示在当前页面
    --%>
    <%--<s:action name="stuONGL" executeResult="true"/>--%>

    <%--s:if,s:else,s:elseif--%>
    <%--<s:set value="'D'" var="level"/>
    <s:if test="#level == 'A'">A</s:if>
    <s:elseif test="#level == 'B'">B</s:elseif>
    <s:elseif test="#level == 'C'">C</s:elseif>
    <s:else>D</s:else>--%>

    <%--s:url：声明一个URL，存在contextMap
        注意：Url中只能传一个参数给后台(第一个参数)
    --%>
    <%--<s:url value="stuONGL" var="myUrl">
        <s:param name="username">yb</s:param>
        <s:param name="password">123456</s:param>
    </s:url>
    <a href="<s:property value='#myUrl'/> ">点击跳转</a>--%>

    <%--s:a：就是一个a标签--%>
    <s:a action="stuONGL">
        <s:param name="username">yb</s:param>
        <s:param name="password">123456</s:param>s:a标签
    </s:a>

    <s:debug></s:debug>
</body>
</html>
