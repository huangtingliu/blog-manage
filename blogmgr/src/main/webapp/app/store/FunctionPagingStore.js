/**
 * 系统功能管理列表 stroe
 */
Ext.define('BlogMgr.store.FunctionPagingStore', {
			model : 'BlogMgr.model.Function',
			extend : 'Ext.data.Store',
			alias : 'store.function_paging',
			storeId : 'functionPagingStore',
			pageSize : 15,
			remoteSort : true,
			remoteFilter : true,
			sorters : [],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/function/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					totalProperty : 'total',
					rootProperty : 'functionlist',
					successProperty : 'success',
					messageProperty : 'message'
				}
			},
			listeners : {}
		});
Ext.create('BlogMgr.store.FunctionPagingStore');