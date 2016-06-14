<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>博文列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<%@include file="../comm/comm.jsp"%>
	<%@include file="../comm/header.jsp"%>
	<div class="layout">
		<div class="pageContent">
			
		</div>
	</div>
	
	<script type="text/javascript">
		$.ajax({
			type : "post",
			url : "${ctxPath}/base/ajax/blog/blogDetail",
			data : {
				"blogId" : '${param.blogId}'
			},
			//dataType:"josn",
			success : function(data) {
				data = data.resultData;
				$(".pageContent").html(data.preview_html);
			}
		});
	</script>
</body>
</html>
