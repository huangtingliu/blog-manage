/**
 * 后台用户stroe
 */
 Ext.define('BlogMgr.store.UserListStore', {
 		    uses:['BlogMgr.model.MgrUser'],
			model : 'BlogMgr.model.MgrUser',
			extend:'Ext.data.Store',
			storeId : 's_mgruserlist',
			proxy : {
				type : 'ajax',
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