/**
 * 菜单ajax数据代理
 */
Ext.define('BlogMgr.store.MenuDataProxy', {
			extend : 'Ext.data.proxy.Ajax',
			alias: 'proxy.menu_proxy',
			model : 'BlogMgr.model.Menu',
			url : '/blogmgr/menu/list.data',
			constructor:function(config){
				this.callParent(arguments);
			},
			reader : {
				type : 'json',
				rootProperty : 'menuList',
				successProperty : 'success',
				messageProperty : 'message'
			}
		});