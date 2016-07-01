/**
 * 菜单ajax数据代理
 */
Ext.define('BlogMgr.store.home.MenuDataProxy', {
			uses : ['BlogMgr.model.home.Menu'],
			extend : 'Ext.data.proxy.Ajax',
			alias: 'proxy.menu_proxy',
			model : 'BlogMgr.model.home.Menu',
			url : '/blogmgr/menu/menus.data',
			constructor:function(config){
				//console.info(arguments);
				this.callParent(arguments);
			},
			reader : {
				type : 'json',
				successProperty : 'success',
				rootProperty : 'data',
				messageProperty : 'content'
			}
			
		});