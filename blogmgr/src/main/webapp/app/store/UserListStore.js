/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserListStore', {
			model : 'BlogMgr.model.User',
			extend:'Ext.data.Store',
			alias:'store.user',
			storeId : 's_userlist',
			pageSize:15,
			remoteSort:false,
			remoteFilter:true,
			sorters:[],
			proxy : {
				limitParam:'pageNo',
				pageParam:'pageSize',
				//actionMethods:{ create: 'POST', read: 'POST', update: 'POST', destroy: 'POST' },
				type : 'ajax',
				noCache:false,
				paramsAsJson:true,
				url : '/blogmgr/user/paging.data',
				reader : {
					type : 'json',
					rootProperty : 'pageContent',
					totalProperty : 'total'
					//messageProperty : 'content',
					//successProperty : 'success',
				}
			},
			listeners:{
				/*update:function( _this , record , operation , modifiedFieldNames , details , eOpts ){
					alert("update");
				} */
			}
});
Ext.create('BlogMgr.store.UserListStore');