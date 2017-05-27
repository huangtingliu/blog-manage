/**
 * 后台用户列表 - 视图模型
 */
Ext.define('BlogMgr.view.user.UserHomeModel', {
			extend : 'Ext.app.ViewModel',
			alias : 'viewmodel.userhome',
			constructor : function() {  
				// 这一句是关键，如果没有的话，this还没有初始化完成,下面的Ext.apply(me.data,....)这句就会出错  
				this.callParent(arguments);
				var menus = BlogMgr.factory.FunctionFactory.getToolBar(null,this.viewParentId);
				Ext.apply(this.data, menus);
			},
			data:{}
})