/**
 * 登录日志 stroe
 */
Ext.define('BlogMgr.store.LoginLogStore', {
			model : 'BlogMgr.model.Function',
			extend : 'Ext.data.Store',
			alias : 'store.login_log_paging',
			storeId : 'loginLogPagingStore',
			pageSize : 15,
			remoteSort : true,
			remoteFilter : true,
			sorters : [],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/loginlog/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					totalProperty : 'total',
					rootProperty : 'list',
					successProperty : 'success',
					messageProperty : 'message'
				}
			},
			listeners : {}
		});
Ext.create('BlogMgr.store.LoginLogStore');