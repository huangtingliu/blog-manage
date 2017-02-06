/**
 * 系统功能配置主页viewModel
 */
Ext.define('BlogMgr.view.fun.FunctionHomeModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.functionhome',
	constructor : function() {  
		this.callParent(arguments);  
		var menus = BlogMgr.view.fun.MenuFactory.getToolBarMenu(null,'C0010006');
		Ext.apply(this.data, menus);
	},
	data:{}
});