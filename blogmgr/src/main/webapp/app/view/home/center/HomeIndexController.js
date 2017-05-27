/**
 * 首页控制器
 */
Ext.define('BlogMgr.view.home.center.HomeIndexController',{
	extend:'Ext.app.ViewController',
	alias:'controller.home_index',
	logout:function(){
		window.location.href = '/blogmgr/logout.do';
	},
	ckEditor:function(){
		Ext.create('BlogMgr.view.home.center.demo.CkeditorDemo').show();
	},
	closeLastTab:function(){
		var tabPanel = Ext.getCmp('home-center');
		var tabTotal = tabPanel.items.length;
		if(tabTotal != 1){
			var lastTab = tabPanel.items.get(tabTotal-1);
			tabPanel.remove(lastTab);
		}
		
	}
	
});