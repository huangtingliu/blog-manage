/**
 * 后台用户列表 - 视图模型
 */
Ext.define('BlogMgr.view.auth.AuthHomeModel', {
			extend : 'Ext.app.ViewModel',
			uses: ['BlogMgr.view.menu.MenuFactory'],
			alias : 'viewmodel.authhome',
			constructor : function() {  
				this.callParent(arguments);  
				var menus = BlogMgr.view.menu.MenuFactory.getToolBarMenu(null,'C0010005');
				Ext.apply(this.data, menus);
			},
			data:{}
})