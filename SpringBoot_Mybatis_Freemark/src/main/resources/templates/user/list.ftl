<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <script src="${request.contextPath}/js/jquery.js"></script>
    <script>
        $(function () {
            //添加图片点击数据
            $("#img1").click(function () {
                alert("不要点我!");
            });
        });
    </script>
</head>
<body>
ABC<br>
<img id="img1" src="${request.contextPath}/imgs/Cookie响应原理.jpg" width="300px" height="300px">
</body>
</html>