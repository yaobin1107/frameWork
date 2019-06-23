<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
${username}
<#if (age < 18)>,欢迎小朋友！
<#elseif (age > 30)>,欢迎您！
<#else>,欢迎帅哥美女！
</#if>
<br>
学生列表：<br>
<table border="1">
    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>性别</td>
    </tr>

    <#list stuList?sort_by("id")?reverse as stu>
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.gender}</td>
        </tr>
    </#list>
</table>
</body>
</html>