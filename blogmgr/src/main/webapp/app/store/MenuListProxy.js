/**
 * 菜单ajax数据代理,通过该proxy获取的菜单有带有权限
 */
Ext.define('BlogMgr.store.MenuListProxy', {
			extend : 'Ext.data.proxy.Ajax',
			alias: 'proxy.menu_list',
			model : 'BlogMgr.model.Menu',
			url : '/blogmgr/menu/authMenus.data',
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