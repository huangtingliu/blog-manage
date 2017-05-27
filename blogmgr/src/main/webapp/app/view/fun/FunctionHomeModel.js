/**
 * 系统功能配置主页viewModel
 */
Ext.define('BlogMgr.view.fun.FunctionHomeModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.functionhome',
	constructor : function() {  
		this.callParent(arguments);  
		var menus = BlogMgr.factory.FunctionFactory.getToolBar(null,this.viewParentId);
		Ext.apply(this.data, menus);
	},
	data:{}
});