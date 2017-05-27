/**
 * 后台用户列表 - 视图模型
 */
Ext.define('BlogMgr.view.auth.AuthHomeModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.authhome',
			constructor : function() {  
				this.callParent(arguments);  
				var menus = BlogMgr.factory.FunctionFactory.getToolBar(null,this.viewParentId);
				Ext.apply(this.data, menus);
			},
			data:{}
})