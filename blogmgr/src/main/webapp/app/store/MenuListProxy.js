/**
 * 菜单ajax数据代理
 */
Ext.define('BlogMgr.store.MenuListProxy', {
			extend : 'Ext.data.proxy.Ajax',
			alias: 'proxy.menu_list',
			model : 'BlogMgr.model.Menu',
			url : '/blogmgr/menu/list.data',
			constructor:function(config){
				this.callParent(arguments);
			},
			reader : {
				type : 'json',
				rootProperty : 'menulist',
				successProperty : 'success',
				messageProperty : 'message'
			}
		});