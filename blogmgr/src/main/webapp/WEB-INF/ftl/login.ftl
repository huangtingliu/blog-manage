<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" type="text/css" href="resource/css/common.css">
	<!--<link rel="stylesheet" type="text/css" href="plugin/iconfont/iconfont.css">-->
	<!-- 海王星 -->
	<link rel="stylesheet" type="text/css" href="framework/Ext/ext-theme-neptune/resources/ext-theme-neptune-all.css">
	<script type="text/javascript" src="framework/Ext/bootstrap.js"></script>
	<script type="text/javascript" src="framework/Ext/ext-theme-neptune/ext-theme-neptune.js"></script>
	<script type="text/javascript" src="framework/Ext/ext-locale-zh_CN.js"></script> 
</head>
	<body>
		<script type="text/javascript" >
			 Ext.Loader.setConfig({
				enabled:true,
				paths:{
					BlogMgr:'app',
					'Ux' : 'framework/Ux'
				}
			});
			Ext.require(['BlogMgr.view.login.LoginHome',
						 'Ux.toast.ColorfulToast'])
			Ext.onReady(function() {
				Ext.create('BlogMgr.view.login.LoginHome');
			});
		</script> 
	</body>
</html>