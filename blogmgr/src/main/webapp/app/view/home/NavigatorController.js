/**
 * 导航栏 controller
 */
Ext.define('BlogMgr.view.home.NavigatorController',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.navigator',
	refreshView:function(records){	//根据所传过来的数据重新，刷新视图
		var view = this.getView();
		Ext.each(records,function(menu){
			view.add({
				data:{
					fId:menu.get('fId'),
					fName:menu.get('fName'),
					fLink:menu.get('fLink')
				},
				title:menu.get('fName'),
				xtype : 'menugrid',
				store : 'BlogMgr.store.home.MenuStore'
			});
		});
	}
    
});