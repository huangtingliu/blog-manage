<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#show tr th{
	font-size: 15px;
	padding: 10px;
	background-color: #d6e4ef
}
#show tr td img{
padding: 1px 10px 1px 0px
}
#commImgTable td {
	padding: 5px;
}
.imgTd img{
	width: 150px;
	height: 150px
}
.imgDiv{
	margin:10px;
	width: 158px;
	height: 158px;
	position: relative;
	display: inline-block;
}
.imgDiv .closeImg{
	width: 20px;
	height: 20px;
	top:-10px;
	right:-3px;
	background: url("${resRoot}/img/close.png") no-repeat scroll 0% 0%;
	position: absolute;
	cursor:pointer;
	
}
</style>
<script type="text/javascript">
//添加认证图片
function addPic(){
	$.pdialog.open(_contextPath +"/topic/addPic", 
		"view", '新增图片', {mask:true, width: 460, height:300});
}

//回填认证图片
function initImgTable(){
	//获取认证图片
$.ajax({
	type : "post",
		url : "${ctxPath}/topic/ajax/cpwb$getObjectByUuid",
		dataType : "json",
		data:{
			//不同页面id不能相同
			uuid:$("#companyAuthuuid").val()
		},
		async : false,
		success : function(data) {
			data = data.resultObj;
			$("#qy_maxImgNum").val(data.length);
			var html = "";
			for(var i=0;i<data.length;i++){
				var path = data[i].PATH;
				var text = data[i].TEXT;
				var code = data[i].CODE;
				var html="";
				//填充表格
				if($("tr[id='qy"+code+"']").length >= 1){
					html +="<div class='imgDiv'><div class='closeImg' onclick='delThisImg(this)'></div><img id='"+""+"' src=\"${ctxPath }/pic/"+path+"\" ></img>";
					html +="<input type=\"hidden\" name='img_"+i+"' value=\""+code+"~"+path+"\"></input></div>";
					$("#show tbody tr[id='qy"+code+"'] td.imgTd").append(html);
				}else{
					var tr_index = $("#show tbody tr").length;
					html+="<tr id=\"qy"+code+"\" class='imgTr'>";
					html+="<td align=\"center\"><span>"+text+"</span></td>";
					html+="<td class=\"imgTd\">";
					html+="<div class='imgDiv'><div class='closeImg' onclick='delThisImg(this)'></div><img id='"+""+"' src=\"${ctxPath }/pic/"+path+"\" ></img>";
					html +="<input type=\"hidden\" name='img_"+i+"' value=\""+code+"~"+path+"\"></input></div>";
					html+="</td>";
					html+="<td align=\"center\"><button type=\"button\" onclick='delThisRow(this)'>删除</button></td>";
					html+="</tr>";
					$("#show tbody").append(html);
				}
			}
		}
});
}
//删除本行的信息（所有图片）
function delThisRow(obj){
	//button --> td --> tr
	$(obj).parent().parent().remove();
}
//删除单张图片
function delThisImg(obj){
	$(obj).parent().find("img").remove();
	$(obj).parent().remove();
}
</script>
<table id="commImgTable">
	<tr>
		<td style="padding: 0px">相关证件：
			<button type="button" style="float: right;" onclick="addPic()">新增</button>
		</td>
	</tr>
	<tr>
		<td>
			<table id="show" border="1">
				<thead>
					<tr>
						<th style="min-width: 100px" align="center">证件类型</th>
						<th style="min-width: 800px" align="center">图片</th>
						<th width="100px" align="center">操作</th>
					</tr>
				</thead>
				<tbody>
					<input id="demo_maxImgNum" name="demo_maxImgNum" type="hidden"
						value="0" />
				</tbody>
			</table>
		</td>
	</tr>
</table>