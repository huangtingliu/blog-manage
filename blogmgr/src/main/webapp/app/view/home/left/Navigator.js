/**
 * home 面的导航栏组件
 */
Ext.define('BlogMgr.view.home.left.Navigator', {
			id:'home_navigator',
			uses : ['BlogMgr.view.home.left.NavigatorModel',
					'BlogMgr.view.home.left.NavigatorController',
					'BlogMgr.view.home.left.NavigatorMenu'],
			extend : 'Ext.panel.Panel',
			alias : 'widget.navigator',
			viewModel:'navigator',
			controller : 'navigator',
			title : '导航',
			glyph : 0xe65a,
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
