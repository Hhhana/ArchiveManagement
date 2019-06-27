<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>档案查询页面</title>
</head>
<body>
    <h2>查询记录</h2>
    <div>
        <div>Find表中记录:${requestScope.map.find}</div><br><br>
        <div>Lose表中记录:${requestScope.map.lose}</div><br><br>
        <div>Destroy表中记录:${requestScope.map.destroy}</div><br><br>


    </div>

</body>
</html>
