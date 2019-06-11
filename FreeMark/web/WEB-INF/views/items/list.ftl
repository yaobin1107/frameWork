<html>
    <head>
        <title>itemsList</title>
    </head>
    <body>
        商品_freemark：<br>
        <table border="1">
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>描述</td>
                <td>日期</td>
                <td>操作</td>
            </tr>
            <#list itemsList as items>
                <tr>
                    <td>${items.name}</td>
                    <td>${items.price}</td>
                    <td>${items.detail}</td>
                    <#--freemark不能把date转成string需在后面加
                        1.?datetime 年月日时分秒
                        2.?date 年月日
                        3.?time 时分秒
                    或者自定义格式：${item.createtime?string("yyyy-MM-dd HH:mm:ss zzzz")}
                    -->
                    <td>${items.createtime?datetime}</td>
                    <td>
                        <a href="/items/delete.do?id=${items.id}">删除</a>
                        &nbsp;<a href="/items/edit.do?id=${items.id}">修改</a>
                    </td>
                </tr>
            </#list>
            <#--<c:forEach items="${itemsList}" var="items">
                <tr>
                    <td>${items.name}</td>
                    <td>${items.price}</td>
                    <td>${items.detail}</td>
                    <td>${items.createtime}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/items/delete.do?id=${items.id}">删除</a>
                        &nbsp;<a href="${pageContext.request.contextPath}/items/edit.do?id=${items.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>-->
        </table>
    </body>
</html>
