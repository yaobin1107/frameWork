<%--
  Created by IntelliJ IDEA.
  User: 10598
  Date: 2019/5/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>register</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
        <script>
            function register() {
                alert("OK");
                var url = '${pageContext.request.contextPath}/stu/save.do';
                //获取表单数据
                var name = document.getElementById("name").value;
                var sex = document.getElementById("sex").value;
                //将数据封装成json对象
                var jsonObj = {name:name,sex:sex};
                //把json对象转成字符串
                var params = JSON.stringify(jsonObj);
                console.log(jsonObj);
                console.log(params);
                //jquery提交json数据
                $.ajax({
                    type:'post',
                    url:url,
                    contentType:'application/json;charset=utf-8',
                    data:params,
                    success:function (respData) {
                        console.log("respData:"+ respData);
                    }
                });
            }
        </script>
    </head>
    <body>
    <%--请求响应都是json格式的表单
        <form action="${pageContext.request.contextPath}/stu/save.do" method="post">
            用户名：<input type="text" id="name" name="name"><br>
            性别：<input type="text" id="sex" name="sex"><br>
            <input type="button" value="提交json格式数据" onclick="register();">
            <input type="submit">
        </form>--%>
    <%--只有响应是json格式的表单--%>
        <form action="${pageContext.request.contextPath}/stu/save1.do" method="post">
            用户名：<input type="text" id="name" name="name"><br>
            性别：<input type="text" id="sex" name="sex"><br>
            <input type="button" value="提交json格式数据" onclick="register();">
            <input type="submit" value="提交普通格式数据">
        </form>
    </body>
</html>
