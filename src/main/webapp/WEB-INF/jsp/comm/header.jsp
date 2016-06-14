<%@ page language="java" pageEncoding="utf-8"%>
<style>
.nav-title{
	color:#ccc
}
.nav-title:HOVER{
	color:#666
}
</style>
<div class="nav-content" style="position:relative;height: 350px;background-repeat: no-repeat;background-image: url('${resRoot}/img/bg_road.jpg');background-size:cover;">
	<div style="position:relative;height: 80% "></div>
	<div style="position:relative;height: 20% ">
		<!-- 首页导航 -->
		<nav class="navbar navbar-default" style="background-color:rgba(0,0,0,0.5);border-radius:0px;border:0 ">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#" >
		<!--       <a class="navbar-brand" href="#" style="padding: 7.5px 15px"> -->
		        <img alt="Home" src="" >
		<%--          <img alt="Home" src="${resRoot}/img/null_img.png" height="35px" width="105px"> --%> 
		      </a>
		    </div>
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			    <ul class="nav navbar-nav">
			    	<li class=""><a href="${ctxPath}/base/blog/blogList?currentPage=blogList" class=""><span class="nav-title">博文列表</span></a></li>
			    	<li class=""><a href="${ctxPath}/base/page/blog/issue_blog?currentPage=issueBlog" class=""><span class="nav-title">发布博文</span></a></li>
			    	<li class=""><a href="#" class=""><span class="nav-title">个人中心</span></a></li>
			    </ul>
			    <form class="navbar-form navbar-right" role="search">
				  <div class="form-group" style="display: inline-block;position: relative;">
				    <input type="text" class="form-control" placeholder="请输入搜索内容" style="background: rgba(0,0,0,0.15);border-color: #666;color:#fff;width: 400PX">
				  	<a href="#" style="position: absolute;display: block;top: 8px;right: 0;width: 30px;height: 30px"><i class="glyphicon glyphicon-search" style="color: #666"></i></a>
				  </div>
				  <!-- <button type="submit" class="btn btn-default" style="background-color: rgba(255,255,255,0);border: 0">
				  </button> -->
				</form>
			</div>
		  </div>
		</nav>
	</div>
</div>