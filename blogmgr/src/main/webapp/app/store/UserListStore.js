/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserListStore', {
			model : 'BlogMgr.model.MgrUser',
			extend:'Ext.data.Store',
			alias:'store.mgrUsers',
			storeId : 's_mgruserlist',
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
				url : '/blogmgr/mgruser/paging.data',
				reader : {
					type : 'json',
					successProperty : 'success',
					rootProperty : 'pageContent',
					messageProperty : 'content',
					totalProperty : 'total'
				}
			}
});
Ext.create('BlogMgr.store.UserListStore');