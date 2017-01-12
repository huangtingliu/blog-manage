/**
 * 首页头部控制器
 */
Ext.define('BlogMgr.view.home.HomeHeaderController',{
	extend:'Ext.app.ViewController',
	alias:'controller.home_header',
	logout:function(){
		window.location.href = '/blogmgr/logout.do';
	}
});