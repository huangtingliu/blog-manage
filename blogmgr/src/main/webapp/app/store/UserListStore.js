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
				paramsAsJson:true,
				url : '/blogmgr/mgruser/paging.data',
				reader : {
					type : 'json',
					rootProperty : 'pageContent',
					totalProperty : 'total'
					//messageProperty : 'content',
					//successProperty : 'success',
				}
			}
});
Ext.create('BlogMgr.store.UserListStore');