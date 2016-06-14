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
	<%@include file="../comm/header.jsp"%>
	<div id="layout">
		<div class="pageContent">
			<div class="list-group">
				<c:forEach items="${responseDataBean.resultData}" var="blog">
					<a href="${ctxPath}/base/page/blog/blogDetail?blogId=${blog.blog_id}"
						class="list-group-item">
						<h4 class="list-group-item-heading">${blog.title}<small
								style="float: right;">${blog.create_time}</small>
						</h4>
	
					</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@include file="../comm/comm.jsp"%>
</body>
</html>
