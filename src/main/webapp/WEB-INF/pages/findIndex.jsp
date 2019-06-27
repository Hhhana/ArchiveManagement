<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>档案找回登记查询</h2>
<form action="${pageContext.request.contextPath}/find/findRegister" method="post">
    <li><label>档案编号</label>
        <input type="text" name="archiveId" id="archiveId" maxlength="5" class="dfinput"><i>档案编号不能超过7个字符</i></li>


    <li><label>操作用户id</label><input type="text" name="loginId" maxlength="5" id="loginId" class="dfinput"} ></li>
    <li><label>找回用户id</label><input type="text" name="findId" maxlength="5" id="findId" class="dfinput"></li>
    <li><label>找回用户姓名</label><input type="text" name="finder" id="finder" class="dfinput"></li>
    <li><label>找回日期</label><input type="date" name="findTime" id="findTime" step="01" class="dfinput"></li>
    <li><label>备注信息</label><textarea name="remark" cols="10" rows="5" class="textinput"> </textarea></li>
    <input type="submit" value="提交" class="btn">
    <input type="reset" value="重置" class="btn">
    </div>

    <input type="submit" value="提交">
</form>

</body>
</html>
