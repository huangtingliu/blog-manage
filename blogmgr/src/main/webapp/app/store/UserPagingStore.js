/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserPagingStore', {
			model : 'BlogMgr.model.User',
			extend:'Ext.data.Store',
			alias:'store.user_paging',
			storeId : 'userPagingStore',
			pageSize:5,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
//				actionMethods: {
//	                create : 'POST',
//	                read   : 'POST',
//	                update : 'POST',
//	                destroy: 'POST'
//	            },
			//	headers: {'Content-Type': "application/x-www-form-urlencoded; charset=UTF-8" },
				url : '/blogmgr/user/paging.data',
				limitParam:'pageSize',
				pageParam:'pageNo',
				noCache:false,
				paramsAsJson:true,
				reader : {
					type : 'json',
					rootProperty : 'userlist',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});
Ext.create('BlogMgr.store.UserPagingStore');