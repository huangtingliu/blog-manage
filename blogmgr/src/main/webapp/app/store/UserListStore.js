/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserListStore', {
 		    uses:['BlogMgr.model.MgrUser'],
			model : 'BlogMgr.model.MgrUser',
			extend:'Ext.data.Store',
			storeId : 's_mgruserlist',
			pageSize:15,
			proxy : {
				limitParam:'pageNo',
				pageParam:'pageSize',
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