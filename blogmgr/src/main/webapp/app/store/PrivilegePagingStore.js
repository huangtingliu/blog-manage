/**
 * 表格权限分页 store
 */
Ext.define('BlogMgr.store.PrivilegePagingStore',{
	model : 'BlogMgr.model.Privilege',
	extend:'Ext.data.Store',
	alias:'store.privilege_paging',
	storeId : 'privilegePagingStore',
	pageSize:15,
	remoteSort:true,
	remoteFilter:true,
	sorters:[{
		direction:'ASC',
		property:'fFunId'
	}],
	proxy : {
		type : 'ajax',
		url : '/blogmgr/privilege/paging.data',
		limitParam:'pageSize',
		pageParam:'pageNo',
		noCache:false,
		paramsAsJson:true,
		reader : {
			type : 'json',
			rootProperty : 'privilegelist',
			totalProperty : 'total',
			messageProperty : 'message',
			successProperty : 'success'
		}
	},
	listeners:{}
});
Ext.create('BlogMgr.store.PrivilegePagingStore');