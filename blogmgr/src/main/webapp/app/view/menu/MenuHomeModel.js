/**
 * 菜单配置主页viewModel
 */
Ext.define('BlogMgr.view.menu.MenuHomeModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.menuhome',
	constructor : function() {  
		this.callParent(arguments);  
		var menus = BlogMgr.view.menu.MenuFactory.getToolBarMenu(null,'C0010006');
		Ext.apply(this.data, menus);
	},
	data:{}
});