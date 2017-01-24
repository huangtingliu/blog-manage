/**
 * 首页控制器
 */
Ext.define('BlogMgr.view.home.center.HomeIndexController',{
	extend:'Ext.app.ViewController',
	alias:'controller.home_index',
	logout:function(){
		window.location.href = '/blogmgr/logout.do';
	}
});