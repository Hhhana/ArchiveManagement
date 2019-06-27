<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <h2>时间段内档案查询</h2>
    <form action="${pageContext.request.contextPath}/find/searchByTime" method="post">
        起始时间:<input type="date" name="startTime" id="startTime">
        结束时间:<input type="date" name="endTime" id="endTime">
                <input type="submit" value="提交">
    </form>
</body>
</html>
