<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
	<link rel="stylesheet" type="text/css" href="${resRoot}/plugins/bootstrap-3.3.5/dist/css/bootstrap.min.css">
	<style type="text/css">
		h3{
			font-weight: 600;
			color: #888;
		}
		.gray-bg{
			background-color:#f3f3f4;
		}
		.middle-box{
			max-width: 400px;
			z-index: 100;
			margin: 0 auto;
			padding-top: 40px;
			width: 300px;
		}
		header{max-width: 400px;margin: 0 auto;}
		.logo-name{
			color: #e6e6e6;
			font-size: 100px;
			font-weight: 800;
			letter-spacing: -10px;
			margin-bottom: 0;
		}
		.full-width{
			width:100%;
		}
	</style>
</head>
<body class="gray-bg">
	
	<!-- <header><h1 class="logo-name">投票系统</h1></header> -->
	<div class="middle-box text-center">
		<div>
			<h3>登 录</h3>
			<form class="" action="" method="post">
				<div class="form-group">
					<input class="form-control" placeholder="请输入用户名" required="" type="text">
				</div>
				<div class="form-group">
                    <input class="form-control" placeholder="请输入密码" required="" type="password">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
                <p class="text-muted text-center"><small>还没有账户？</small><a href="${ctxPath}/base/page/register">点此注册</a>
                </p>
			</form>
		</div>
	</div>
	<script type="text/javascript" href="${resRoot}/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" href="${resRoot}/plugins/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
</body>
</html>
