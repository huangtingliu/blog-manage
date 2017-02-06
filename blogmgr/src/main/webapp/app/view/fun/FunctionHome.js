/**
 * 系统功能管理 - 主页
 */
Ext.define('BlogMgr.view.fun.FunctionHome', {
			id : 'functionHome',
			extend : 'Ext.panel.Panel',
			alias : ['widget.functionhome'],
			uses : ['BlogMgr.view.fun.FunctionTree', 
					'BlogMgr.view.fun.FunctionGrid',
					'BlogMgr.view.fun.FunctionHomeController',
					'BlogMgr.view.fun.FunctionHomeModel'],
			layout : 'border',
			controller : 'functionhome',
			viewModel : {
				type : 'functionhome'
			},
			items : [{
						region : 'west',
						title : '',
						bodyPadding : 7,
						width : 200,
						split : true,
						items : {
							xtype : 'functiontree'
						}
					}, {
						region : 'center',
						layout : 'fit',
						items : {
							reference:'functionGrid',
							xtype : 'functiongrid'
						}
					}]
		});