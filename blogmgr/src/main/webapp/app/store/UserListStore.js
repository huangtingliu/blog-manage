/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserListStore', {
			model : 'BlogMgr.model.User',
			extend:'Ext.data.Store',
			alias:'store.user',
			storeId : 's_userlist',
			pageSize:15,
			remoteSort:true,
			remoteFilter:true,
			sorters:[],
			proxy : {
				limitParam:'pageNo',
				pageParam:'pageSize',
				type : 'ajax',
				noCache:false,
				paramsAsJson:true,
				url : '/blogmgr/user/paging.data',
				reader : {
					type : 'json',
					rootProperty : 'userList',
					totalProperty : 'total',
					messageProperty : 'message',
					successProperty : 'success'
				}
			},
			listeners:{}
});
Ext.create('BlogMgr.store.UserListStore');