<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>档案异常记录查询页面</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="#">首页</a></li>
	    <li><a href="#">数据表</a></li>
	    <li><a href="#">档案异常查询</a></li>
	    </ul>
    </div>
    
    <div class="rightinfo"> 
	 	    <div class="formbody">
		    <div class="formtitle"><span>查询信息</span></div>
		    		<div>
						<form id="form" class="forminfo">
						<li><label>开始时间        </label><input type="date" name="startTime" id="startTime" class="dfinput"></li>
						<div id="div1" style="display:none;color:red">*开始时间不能为空，请重新选择</div><br>
						<li><label>结束时间       </label><input type="date" name="endTime" id="endTime" class="dfinput"></li>
		  	   			<div id="div2" style="display:none;color:red">*结束时间不能为空，请重新选择</div><br>
						</form><br>
						<button id="button1" class="btn">提交</button>
						<button id="button2" class="btn">重置</button>				 
					</div>
			</div>	
    
	    <table id="tableFind" class="tablelist">
	    	<caption id="capFind" style="font-family:微软雅黑;font-size:15px;border:2px"></caption>
	    	<thead id="theadFind"></thead>
	        <tbody id="tbodyFind"></tbody>
	    </table>
    	<div id="divFind" style="text-align:center"></div><br>
    	
    	<table id="tableLose" class="tablelist">
		<caption id="capLose" style="font-family:微软雅黑;font-size:15px;border:2px"></caption>
		<thead id="theadLose"></thead>
		<tbody id="tbodyLose"></tbody>
	</table>
		<div id="divLose" style="text-align:center"></div><br>

		<table id="tableDestroy" class="tablelist">
			<caption id="capDestroy" style="font-family:微软雅黑;font-size:15px;border:2px"></caption>
			<thead id="theadDestroy"></thead>
			<tbody id="tbodyDestroy"></tbody>
		</table>
		<div id="divDestroy" style="text-align:center"></div>

    </div>
    
    <script type="text/javascript" src="/js/jquery-3.3.1.js" ></script>
    <script>
	$('.tablelist tbody tr:odd').addClass('odd');

	$(document).ready(function(){
		$("#button2").click(function(){
			//reset触发
			$("#form")[0].reset();
			$("#div1").hide();
			$("#div2").hide();
		});
		
        $("#button1").click(function(){
          	//清除元素
          	$("#capFind").empty();
        	$("#tableFind>thead").empty();
        	$("#tableFind>tbody").empty();
        	$("#divFind").empty();
        	$("#capLose").empty();
        	$("#tableLose>thead").empty();
        	$("#tableLose>tbody").empty();
        	$("#divLose").empty();
        	$("#div1").hide();
        	$("#div2").hide();
			//检查输入是否合法
    		var startTime = $("#startTime").val();
    		var endTime = $("#endTime").val();
    		
    		if( startTime != "" && endTime != "") {
    			//进行Ajax提交
                $.ajax({           	
                    type:"post",        
                    url:"searchByTime",
                    data:$("#form").serialize(),    
                    cache:false,    
                    dataType:"json",  
                    success:function(data){
                    	console.log(data);
                    	var list = data.find;
                    	var list2 = data.lose;
						var list3 = data.destroy;
                    	var capFind = "找回记录";
                    	$("#capFind").append(capFind);
    	               	var theadFind = "<tr>" + "<th>序号</th>" + "<th>档案编号</th>"
						+ "<th>操作用户id</th>" + "<th>找回用户id</th>" + "<th>找回用户姓名</th>"
						+ "<th>找回日期</th>" + "<th>备注信息</th>" + "<th>档案类型</th>" + "</tr>";
						$("#theadFind").append(theadFind);
						if(list == "") {
							var input = "找到0条记录";
							$("#divFind").append(input);
						}
			            $.each(list,function(i,n){
			                var str="<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" " 
			                		+ " onmouseout=\"this.style.backgroundColor='#d4e3e5';\">";
			                str += "<td>" + (i+1) + "</td>";
			              	str += "<td>" + n.archiveId + "</td>";                    
			              	str += "<td>"+ n.loginId + "</td>";                    
			              	str += "<td>" + n.findId + "</td>"; 
			              	str += "<td>" + n.finder + "</td>";
			              	str += "<td>" + n.findTime + "</td>";
			              	str += "<td>" + n.remark + "</td>";
			              	str += "<td>" + n.typeId + "</td>"
			              	str += "</tr>";
			              	$("#tbodyFind").append(str);
			            });  
			            
                    	var capLose = "异常记录";
                    	$("#capLose").append(capLose);
			            var theadLose = "<tr>" + "<th>序号</th>" + "<th>档案编号</th>"
			            				+ "<th>异常类型</th>" 
										+ "<th>操作用户id</th>" + "<th>当事用户姓名</th>"
										+ "<th>当事日期</th>" + "<th>备注信息</th>" + "</tr>";
						$("#theadLose").append(theadLose);
			            if(list2 == "") {
							var input = "找到0条记录";
							$("#divLose").append(input);
						}
			            $.each(list2,function(i,n){
			                var str="<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" " 
			                		+ " onmouseout=\"this.style.backgroundColor='#d4e3e5';\">";
			                str += "<td>" + (i+1) + "</td>";
			              	str += "<td>" + n.archiveId + "</td>";                    
			              	str += "<td>"+ n.state + "</td>";                    
			              	str += "<td>" + n.loginId + "</td>"; 
			              	str += "<td>" + n.loser + "</td>";
			              	str += "<td>" + n.loseTime + "</td>";
			              	str += "<td>" + n.remark + "</td>";
			              	str += "</tr>";
			              	$("#tbodyLose").append(str);
			            });

						var capDestroy = "销毁记录";
						$("#capDestroy").append(capDestroy);
						var theadDestroy = "<tr>" + "<th>序号</th>" + "<th>档案编号</th>"
								+ "<th>操作用户id</th>"
								+ "<th>当事日期</th>" + "<th>备注信息</th>" + "</tr>";
						$("#theadDestroy").append(theadDestroy);
						if(list3 == "") {
							var input = "找到0条记录";
							$("#divDestroy").append(input);
						}
						$.each(list3,function(i,n){
							var str="<tr onmouseover=\"this.style.backgroundColor='#ffff66';\" "
									+ " onmouseout=\"this.style.backgroundColor='#d4e3e5';\">";
							str += "<td>" + (i+1) + "</td>";
							str += "<td>" + n.archiveId + "</td>";
							str += "<td>" + n.loginId + "</td>";
							str += "<td>" + n.destroyTime + "</td>";
							str += "<td>" + n.remark + "</td>";
							str += "</tr>";
							$("#tbodyDestroy").append(str);
						});



					}
          		});//ajax    			
    		} else {
    	 		if( startTime == ""){
        			document.getElementById("div1").style.display="inline";
        		} 
        		if(endTime == "") {
        			document.getElementById("div2").style.display="inline";
        		}
    			
    		}
    		
         });  //click() 
    });//ready()
	
	</script>	
	
</body>
</html>