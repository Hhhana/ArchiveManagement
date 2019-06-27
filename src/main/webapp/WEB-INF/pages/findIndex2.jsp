<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>找回登记页面</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">找回登记</a></li>
    </ul>
    </div>
    
	    <div class="formbody">
	    
		    <div class="formtitle"><span>基本信息</span></div>
		    	<form action="${pageContext.request.contextPath}/find/findRegister" onsubmit="return check()" class="forminfo">
					<li><label>档案编号</label><input type="text" name="archiveId" id="archiveId" maxlength="5" class="dfinput"><i>档案编号不能超过7个字符</i></li>
										<input type="button" value="查询" onclick="judge()" class="btn">
						   <input type="reset" value="重置" onclick="func()" class="btn">
						   <div id="div1" style="display:none;color:red">*档案已丢失，请及时登记找回</div>
						   <div id="div2" style="display:none;color:red">*档案未丢失，请核查后重新输入</div>
						   <a href="#" id="a1" style="display:none;" onclick="find()" class="btn">找回</a><br><br>
					<div id="div3" style="display:none;">
						<li><label>操作用户id</label><input type="text" name="loginId" maxlength="5" id="loginId" class="dfinput"} ></li>
						<li><label>找回用户id</label><input type="text" name="findId" maxlength="5" id="findId" class="dfinput"></li>
						<li><label>找回用户姓名</label><input type="text" name="finder" id="finder" class="dfinput"></li>
						<li><label>找回日期</label><input type="date" name="findTime" id="findTime" step="01" class="dfinput"></li>
						<li><label>备注信息</label><textarea name="remark" cols="10" rows="5" class="textinput"> </textarea></li> 
										<input type="submit" value="提交" class="btn">
										<input type="reset" value="重置" class="btn">
						</div>
					
				</form>
		</div>
    
 
    	<script>
		function func(){
			document.getElementById("div1").style.display="none";
			document.getElementById("div2").style.display="none";
			document.getElementById("div3").style.display="none";
			document.getElementById("a1").style.display="none";
			
		}
		function check() {
			//获取值
			var archiveId = document.getElementById("archiveId").value;
			var loginId = document.getElementById("loginId").value;
			var findId = document.getElementById("findId").value;
			var finder = document.getElementById("finder").value;
			var findTime = document.getElementById("findTime").value;
			
			if( archiveId.trim() == ""){
				alert("档案编号不能为空，请重新输入");
				return false;
			} else if(loginId.trim() == "") {
				alert("操作用户id不能为空，请重新输入");
				return false;
			}  else if (findId.trim() == "") {
				alert("找回用户id不能为空，请重新输入");
				return false;
			} else if ( finder.trim() == "") {
				alert("找回用户姓名不能为空，请重新输入");
				return false;
			} else if ( findTime.trim() == "") {
				alert("找回日期不能为空，请重新选择");
				return false;
			}	
			return true;
		}
		
		
		//若状态为丢失，显示“找回”按钮进行登记
		function find() {
			document.getElementById("div3").style.display="inline";
		}
		
		//Ajax
		var xmlHttp;	
		function judge() {
			func();
			var archiveId = document.getElementById("archiveId").value; 
			if (window.XMLHttpRequest) {
				xmlHttp = new XMLHttpRequest();
			} else {
				xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
			}
	  	    //调用open(),post请求,预处理Http请求
			var url = "checkState";
			xmlHttp.open("POST",url,true);  //默认是异步传输
			xmlHttp.onreadystatechange = feedback;
			var data = "archiveId=" + archiveId;
			xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
			xmlHttp.send(data);
			
		}
		//回调函数
		function feedback() {
			console.log("xml对象的状态"+xmlHttp.readyState); //xml对象的状态
			console.log("http响应的状态"+xmlHttp.status); //http响应的状态
			var archiveId = document.getElementById("archiveId").value;
			if ( xmlHttp.readyState == 4 && xmlHttp.status == 200) {	
				var text = xmlHttp.responseText;
				if(archiveId.trim() != "") {
					if( text.substr(4) == "丢失") {
						document.getElementById("div1").style.display="inline"; 
						document.getElementById("a1").style.display="inline";
					} else {
						document.getElementById("div2").style.display="inline"; 		
					}
				}
			}
			
		}
	
	</script>
    
    
</body>
</html>