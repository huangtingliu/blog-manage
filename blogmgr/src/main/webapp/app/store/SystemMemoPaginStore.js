/**
 * 系统备忘录stroe
 */
 Ext.define('BlogMgr.store.SystemMemoPaginStore', {
			model : 'BlogMgr.model.debug.SystemMemo',
			extend:'Ext.data.Store',
			alias:'store.system_memo_paging',
			storeId : 'systemMemoPaginStore',
			pageSize:15,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/debug/memo/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					rootProperty : 'memolist',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});
Ext.create('BlogMgr.store.SystemMemoPaginStore');