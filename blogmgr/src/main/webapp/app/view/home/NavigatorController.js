/**
 * 导航栏 controller
 */
Ext.define('BlogMgr.view.home.NavigatorController',{
	extend: 'Ext.app.ViewController',
    alias: 'controller.navigator',
	refreshView:function(records){	//根据所传过来的数据重新，刷新视图
		if(Ext.isEmpty(records)){return;}
		var view = this.getView();
		var expandId = null;	//要展开的面板
		Ext.each(records,function(menu){
			view.add({
				itemId:menu.get('fId'),
				title:menu.get('fName'),
				authPriority:menu.get('authPriority'),
				xtype : 'navigatormenu'
			});
			//TODO 初始化选中时太生硬了,展开的顺序设置菜单的order值
			/*if(menu.get('fExpand')==1){
				view.getComponent(menu.get('fId')).expand(true);
			}*/
		});
	}
});