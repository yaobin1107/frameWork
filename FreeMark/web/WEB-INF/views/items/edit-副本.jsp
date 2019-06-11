<%--
  Created by IntelliJ IDEA.
  User: gyf
  Date: 2018/5/25
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑商品</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script>
        function submitImage() {
            alert("提交图片到后台");
            //封装请求数据
            var options = {
                type:'post',
                dataType:'json',
                //data里面写追加的数据
                data:{
                    //此处表示，除了提交form表单数据外，还会提交这个username
                    username:'yb'
                },
                url:'${pageContext.request.contextPath}/upload/itemspic.do',
                success:function (respData) {
                    //如果dataType写的是text则需要转成json对象↓
                    //var jsonObj = $.parseJSON(respData);
                    //console.log(respData.imgUrl);打印数据到浏览器控制台
                    $('#pic').attr('src',respData.imgUrl);
                    $('#hiddenPic').val(respData.imgUrl);
                }
            }
            //提交表单
            $('#itemsForm').ajaxSubmit(options)
        }
    </script>
</head>
<body>
<form id="itemsForm" action="${pageContext.request.contextPath}/items/update.do" method="post">
<table border="1">
    <tr>
        <td>名称</td>
        <td>
            <input type="text" name="name" value="${itemsById.name}">
            <input type="hidden" name="id" value="${itemsById.id}">
        </td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="price" value="${itemsById.price}"></td>
    </tr>
    <tr>
        <td>描述</td>
        <td><textarea cols="20" rows="5" name="detail">${itemsById.detail}</textarea> </td>
    </tr>
    <tr>
        <td>图片</td>
        <td>
            <img id="pic" src="${itemsById.pic}" width="100px" height="100px">
            <%--这里的事件选用onchange是因为，要选择图片之后才提交--%>
            <input type="file" name="itemspic1" onchange="submitImage();">
            <input id="hiddenPic" type="hidden" name="pic" value="${itemsById.pic}">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="更新">
        </td>
    </tr>
</table>

</form>
</body>
</html>
