/**
 * 菜单管理列表 stroe
 */
Ext.define('BlogMgr.store.MenuPagingStore', {
			model : 'BlogMgr.model.Menu',
			extend : 'Ext.data.Store',
			alias : 'store.menu_paging',
			storeId : 'menuPagingStore',
			pageSize : 15,
			remoteSort : true,
			remoteFilter : true,
			sorters : [],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/menu/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					totalProperty : 'total',
					rootProperty : 'menulist',
					successProperty : 'success',
					messageProperty : 'message'
				}
			},
			listeners : {}
		});
Ext.create('BlogMgr.store.MenuPagingStore');