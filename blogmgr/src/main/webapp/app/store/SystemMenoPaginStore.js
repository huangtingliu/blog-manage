/**
 * 系统备忘录stroe
 */
 Ext.define('BlogMgr.store.SystemMenoPaginStore', {
			model : 'BlogMgr.model.debug.SystemMeno',
			extend:'Ext.data.Store',
			alias:'store.system_meno_paging',
			storeId : 'systemMenoPaginStore',
			pageSize:15,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/debug/meno/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					rootProperty : 'menolist',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});
Ext.create('BlogMgr.store.SystemMenoPaginStore');