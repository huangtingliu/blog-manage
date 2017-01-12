/**
 * 角色分页 store
 */
Ext.define('BlogMgr.store.RolePagingStroe',{
	model : 'BlogMgr.model.Role',
	extend:'Ext.data.Store',
	alias:'store.role_paging',
	storeId : 'rolePagingStroe',
	pageSize:15,
	remoteSort:true,
	remoteFilter:true,
	/**sorters:[{
		direction:'DESC',
		property:'fName'
	}],*/
	proxy : {
		type : 'ajax',
		url : '/blogmgr/role/paging.data',
		limitParam:'pageSize',
		pageParam:'pageNo',
		noCache:false,
		paramsAsJson:true,
		reader : {
			type : 'json',
			rootProperty : 'rolelist',
			totalProperty : 'total',
			messageProperty : 'message',
			successProperty : 'success'
		}
	},
	listeners:{}
});
Ext.create('BlogMgr.store.RolePagingStroe');