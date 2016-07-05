/**
 * home 面的导航栏组件
 */
Ext.define('BlogMgr.view.home.Navigator', {
			id:'home_navigator',
			uses : ['BlogMgr.view.home.NavigatorModel',
					'BlogMgr.view.home.NavigatorController',
					'BlogMgr.view.home.MenuGrid'],
			extend : 'Ext.panel.Panel',
			alias : 'widget.navigator',
			viewModel:'navigator',
			controller : 'navigator',
			title : '导航',
			glyph : 0xf0c9,
			
			layout : {
				type : 'accordion',
				animate : true
			},
			defaults : {
				bodyPadding : '10 0 0 0'
			},
			initComponent:function(){
				  var viewModel = this.getViewModel().get('rootMenu');
				  viewModel.load();
				  this.callParent(arguments);  
			},
			listeners:{
				proxyLoad:'refreshView'	//当加载完数据就刷新该控件
			},
			items : []
		});
