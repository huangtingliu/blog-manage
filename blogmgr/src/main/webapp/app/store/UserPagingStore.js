/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserPagingStore', {
			model : 'BlogMgr.model.User',
			extend:'Ext.data.Store',
			alias:'store.user_paging',
			storeId : 'userPagingStore',
			pageSize:15,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				type : 'ajax',
				url : '/blogmgr/user/paging.data',
				limitParam:'pageNo',
				pageParam:'pageSize',
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