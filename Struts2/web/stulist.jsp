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
</head>
<body>
<table border="1">
    <tr>
        <td>奇数</td>
        <td>偶数</td>
        <td>第一</td>
        <td>最后</td>
        <td>索引</td>
        <td>计数</td>
        <td>名字</td>
        <td>年龄</td>
        <td>城市</td>
    </tr>
    <%--使用struts的遍历标签
        1.value；写值栈变量名
        2.var：用于接收遍历后数据的变量名,会存到contextMap中
        3.status：用于记录遍历的状态
            a.boolean isOdd(); 是否是奇数
            a.boolean isEven(); 是否是偶数
            a.boolean isFirst(); 是否是第一个
            a.boolean isLast(); 是否是最后
            a.int getIndex(); 索引，从零开始
            a.int getCount(); 遍历的个数，从1开始
    --%>
    <%--<s:iterator value="stuList" var="stu" status="st">
        <tr>
            <td>${st.odd}</td>
            <td>${st.even}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td><s:property value="#stu.name"/></td>
            <td><s:property value="#stu.age"/></td>
            <td><s:property value="#stu.city"/></td>
        </tr>
    </s:iterator><hr>--%>


    <%--OGNL投影：可以给定过滤条件
        1.?#  过滤所有符合条件的集合       例：stuList.{?#this.age>14}
        2.^#  过滤第一个符合条件的集合     例：stuList.{^#this.age>14}
        3.$#  过滤最后一个符合条件的集合   例：stuList.{$#this.age>14}
    --%>
    <%--OGNL投影：
    <s:iterator value="stuList.{^#this.age>14}" var="stu" status="st">
        <tr>
            <td>${st.odd}</td>
            <td>${st.even}</td>
            <td>${st.first}</td>
            <td>${st.last}</td>
            <td>${st.index}</td>
            <td>${st.count}</td>
            <td><s:property value="#stu.name"/></td>
            <td><s:property value="#stu.age"/></td>
            <td><s:property value="#stu.city"/></td>
        </tr>
    </s:iterator>--%>

    <%--使用指定属性投影
        1.只需要name属性
        2.遍历时，可以不用指定var属性，默认就是放在值栈的栈顶
        3.由于.{name}是把student的name属性放在栈顶，所以遍历取值时，不指定value属性值默认取栈顶
    --%>
    <s:iterator value="stuList.{name}" status="st">
    <tr>
        <td>${st.odd}</td>
        <td>${st.even}</td>
        <td>${st.first}</td>
        <td>${st.last}</td>
        <td>${st.index}</td>
        <td>${st.count}</td>
        <td><s:property/></td>
    </tr>
    </s:iterator>

</table>
<s:debug></s:debug>
</body>
</html>
