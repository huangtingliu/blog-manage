/**
 * 备忘录列表 - 视图模型
 */
Ext.define('BlogMgr.view.debug.memo.SystemMemoHomeModel', {
			extend : 'Ext.app.ViewModel',
			uses: ['BlogMgr.view.fun.MenuFactory'],
			alias : 'viewmodel.system_memo_home',
			constructor : function() {  
				// 这一句是关键，如果没有的话，this还没有初始化完成,下面的Ext.apply(me.data,....)这句就会出错  
				this.callParent(arguments);  
				var menus = BlogMgr.view.fun.MenuFactory.getToolBarMenu(null,'Z0010001');
				Ext.apply(this.data, menus);
			},
			data:{}
})